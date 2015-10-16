package org.ekonopaka.crm.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.service.interfaces.IOfficeService;
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
public class OfficeController {

	@Autowired
	IOfficeService officeService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	MessageGenerator messageGenerator;
	
	@RequestMapping(value = "/administration/manageoffices", method = RequestMethod.GET)
	public String manageoffices(
					Model model) {
		
		List<Office> officesList = officeService.getOffices();
		model.addAttribute("officesList", officesList);
		return "manageoffices";
	}

	@RequestMapping(value = "/administration/addoffice", method = RequestMethod.GET)
	public String addOfficeGet(
					Model model) {

		model.addAttribute("office", officeService.getNewOffice());
		return "addoffice";
	}

	@RequestMapping(value = "/administration/addoffice", method = RequestMethod.POST)
	public String addOfficePost(
					Model model,
					@Valid @ModelAttribute("office") Office fOffice,
					BindingResult result, 
					Locale locale) {
		
		if (result.hasErrors()) {
			String msg = messageSource.getMessage("office.has.not.been.created.validation", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("office", fOffice);
			return "addoffice";
		}

		officeService.addOffice(fOffice);
		
		String msg = messageSource.getMessage("office.has.been.created.message", null, locale);
		List<Office> officesList = officeService.getOffices();
		model.addAttribute("officesList", officesList);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		
		return "manageoffices";
	}

	@RequestMapping(value = "/administration/edit/office/{officeId}", method = RequestMethod.GET)
	public String editOfficeGet(
					Model model, 
					@PathVariable("officeId") int officeId	) {
		
		Office office = officeService.getOfficeById(officeId);
		model.addAttribute("office", office);
		
		return "editoffice";
	}

	@RequestMapping(value = "/administration/edit/office/{officeId}", method = RequestMethod.POST)
	public String editOfficePost(
					Model model,
					@Valid @ModelAttribute("office") Office office,
					BindingResult result, @PathVariable("officeId") int officeId,
					Locale locale) {
		
		if (result.hasErrors()) {
			String msg = messageSource.getMessage("office.has.not.been.updated.validation", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("office", office);
			return "editoffice";
		}

		Office pOffice = officeService.getOfficeById(officeId);
		if (pOffice == null)	 {
			return "404";
		}
		
		office.setId(pOffice.getId());
		officeService.updateOffice(office);
		
		String msg = messageSource.getMessage("office.has.been.updated.message", null, locale);
		
		List<Office> officesList = officeService.getOffices();
		model.addAttribute("officesList", officesList);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		
		return "manageoffices";
	}

	@RequestMapping(value = "/administration/delete/office/{officeId}", method = RequestMethod.GET)
	public String deleteOfficeGet(
					Model model,
					@PathVariable("officeId") int officeId, 
					Locale locale) {
		
		Office office = officeService.getOfficeById(officeId);
		
		if (office == null)	 {
			return "404";
		}
		
		model.addAttribute("office", office);
		return "deleteoffice";
	}

	@RequestMapping(value = "/administration/delete/office/{officeId}", method = RequestMethod.POST)
	public String deleteOfficePost(
					Model model, 
					@PathVariable("officeId") int officeId, 
					Locale locale) {
		
		Office office = officeService.getOfficeById(officeId);
		if (office == null)	 {
			return "404";
		}
		
		officeService.deleteOffice(office);

		String msg = messageSource.getMessage("office.has.been.deleted.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		List<Office> officesList = officeService.getOffices();
		model.addAttribute("officesList", officesList);
		return "manageoffices";
	}

}
