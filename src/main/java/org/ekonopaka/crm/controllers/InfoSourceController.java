package org.ekonopaka.crm.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.ekonopaka.crm.handlers.LocatizationTool;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.types.InfoSourceType;
import org.ekonopaka.crm.service.interfaces.IInfoSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoSourceController {

	@Autowired
	IInfoSourceService infoSourceService;

	@Autowired
	LocatizationTool locatizationTool;

	@Autowired
	MessageGenerator messageGenerator;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = "/administration/manageinfosources", method = RequestMethod.GET)
	public String manageInfoSources(
					Model model, 
					Locale locale) {
		
		List<InfoSource> infoSourcesList = infoSourceService.getInfoSources();

		model.addAttribute("infoSourcesList", locatizationTool.processInfoSources(infoSourcesList, locale));
		return "manageinfosources";
	}

	@RequestMapping(value = "/administration/addinfosource", method = RequestMethod.GET)
	public String addInfoSourceGet(
					Model model, 
					Locale locale) {
		
		List<InfoSourceType> infoSourceTypesList = infoSourceService.getInfoSourceTypes();

		model.addAttribute("infoSourceTypesList", locatizationTool.processInfoSourceTypes(infoSourceTypesList, locale));
		model.addAttribute("infoSource", infoSourceService.getNewInfoSource());
		return "addinfosource";
	}

	@RequestMapping(value = "/administration/addinfosource", method = RequestMethod.POST)
	public String addInfoSourcePost(
					Model model,
					@Valid @ModelAttribute("infoSource") InfoSource infoSource,
					BindingResult result, Locale locale) {

		if (result.hasErrors()) {
			String msg = messageSource.getMessage("info.source.has.not.been.created.validation", null, locale);
			List<InfoSourceType> infoSourceTypesList = infoSourceService.getInfoSourceTypes();
			model.addAttribute("infoSourceTypesList", locatizationTool.processInfoSourceTypes(infoSourceTypesList, locale));
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			return "addinfosource";
		}

		infoSourceService.addSource(infoSource);

		String msg = messageSource.getMessage("info.source.has.been.created", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		List<InfoSource> infoSourcesList = infoSourceService.getInfoSources();
		model.addAttribute("infoSourcesList", locatizationTool.processInfoSources(infoSourcesList, locale));
		return "manageinfosources";
	}

	@RequestMapping(value = "/administration/edit/infosource/{infoSourceId}", method = RequestMethod.GET)
	public String editInfoSourceGet(
					Model model, 
					@PathVariable("infoSourceId") int infoSourceId, 
					Locale locale) {
		
		InfoSource infoSource = infoSourceService.getInfoSourceById(infoSourceId);
		
		if (infoSource == null)	 {
			return "404";
		}
		
		List<InfoSourceType> infoSourceTypesList = infoSourceService.getInfoSourceTypes();

		model.addAttribute("infoSource", infoSource);
		model.addAttribute("infoSourceTypesList", locatizationTool.processInfoSourceTypes(infoSourceTypesList, locale));
		return "editinfosource";
	}

	@RequestMapping(value = "/administration/edit/infosource/{infoSourceId}", method = RequestMethod.POST)
	public String editInfoSourcePost(
					Model model,
					@Valid @ModelAttribute("infoSource") InfoSource infoSource,
					BindingResult result,
					@PathVariable("infoSourceId") int infoSourceId, Locale locale) {
		
		if (result.hasErrors()) {
			List<InfoSourceType> infoSourceTypesList = infoSourceService.getInfoSourceTypes();
			String msg = messageSource.getMessage("info.source.has.not.been.updated.validation", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("infoSource", infoSource);
			model.addAttribute("infoSourceTypesList", locatizationTool.processInfoSourceTypes(infoSourceTypesList, locale));
			return "editinfosource";
		}

		InfoSource pInfoSource = infoSourceService.getInfoSourceById(infoSourceId);
		
		if (infoSource == null)	 {
			return "404";
		}

		infoSource.setId(pInfoSource.getId());
		infoSourceService.updateInfoSource(infoSource);

		String msg = messageSource.getMessage("info.source.has.been.updated", null, locale);
		List<InfoSource> infoSourcesList = infoSourceService.getInfoSources();
		model.addAttribute("infoSourcesList", locatizationTool.processInfoSources(infoSourcesList, locale));
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		return "manageinfosources";
	}

	@RequestMapping(value = "/administration/delete/infosource/{infoSourceId}", method = RequestMethod.GET)
	public String deleteInfoSourceGet(
					Model model,
					@PathVariable("infoSourceId") int infoSourceId, 
					Locale locale) {
		
		InfoSource infoSource = infoSourceService.getInfoSourceById(infoSourceId);
		
		if (infoSource == null)	 {
			return "404";
		}
		
		model.addAttribute("infoSource", locatizationTool.processInfoSource(infoSource, locale));
		return "deleteinfosource";
	}

	@RequestMapping(value = "/administration/delete/infosource/{infoSourceId}", method = RequestMethod.POST)
	public String deleteInfoSourcePost(
					Model model, 
					@PathVariable("infoSourceId") int infoSourceId, 
					Locale locale) {
		
		InfoSource infoSource = infoSourceService.getInfoSourceById(infoSourceId);
		
		if (infoSource == null)	 {
			return "404";
		}
		
		infoSourceService.deleteSource(infoSource);

		String msg = messageSource.getMessage("info.source.has.been.deleted.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		List<InfoSource> infoSourcesList = infoSourceService.getInfoSources();
		model.addAttribute("infoSourcesList", locatizationTool.processInfoSources(infoSourcesList, locale));
		return "manageinfosources";
	}

}
