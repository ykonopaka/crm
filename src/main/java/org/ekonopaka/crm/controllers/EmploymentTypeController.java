package org.ekonopaka.crm.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.ekonopaka.crm.handlers.LocatizationTool;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.service.interfaces.IEmploymentTypeService;
import org.ekonopaka.crm.validators.ClientValidatorSpecificEmploymentType;
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
public class EmploymentTypeController {

	@Autowired
	ClientValidatorSpecificEmploymentType specificEmploymentTypeValidator;

	@Autowired
	IEmploymentTypeService employmentTypeService;

	@Autowired
	LocatizationTool locatizationTool;

	@Autowired
	MessageSource messageSource;

	@Autowired
	MessageGenerator messageGenerator;

	@RequestMapping(value = "/administration/manageempltypes", method = RequestMethod.GET)
	public String manageEmploymentTypes(
					Model model, 
					Locale locale) {

		List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();
		model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));

		return "manageempltypes";
	}

	@RequestMapping(value = "/administration/addempltype", method = RequestMethod.GET)
	public String addEmploymentTypeGet(
					Model model) {
		
		model.addAttribute("employmentType", employmentTypeService.getNewEmploymentType());
		return "addempltype";
	}

	@RequestMapping(value = "/administration/addempltype", method = RequestMethod.POST)
	public String addEmploymentTypePost(
					Model model,
					@Valid @ModelAttribute("employmentType") EmploymentType employmentType,
					BindingResult result, Locale locale) {

		if (result.hasErrors()) {
			String msg = messageSource.getMessage("employment.type.has.not.been.created.validation", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("employmentType", employmentType);
			return "addempltype";
		}

		employmentTypeService.addEmploymentType(employmentType);
		String msg = messageSource.getMessage("employment.type.has.been.created.message", null, locale);
		List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();

		model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		return "manageempltypes";
	}

	@RequestMapping(value = "/administration/delete/empltype/{employmentTypeId}", method = RequestMethod.GET)
	public String deleteEmploymentTypeGet(
					Model model, 
					@PathVariable("employmentTypeId") int employmentTypeId, 
					Locale locale) {
		
		EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(employmentTypeId);
		
		if (employmentType == null)	 {
			return "404";
		}
		
		model.addAttribute("employmentType", locatizationTool.processEmploymentType(employmentType, locale));
		return "deleteempltype";
	}

	@RequestMapping(value = "/administration/delete/empltype/{employmentTypeId}", method = RequestMethod.POST)
	public String deleteEmploymentTypePost(
					Model model, 
					@PathVariable("employmentTypeId") int employmentTypeId, 
					Locale locale) {
		
		EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(employmentTypeId);
		
		if (employmentType == null)	 {
			return "404";
		}
		
		employmentTypeService.deleteEmploymentType(employmentType);

		String msg = messageSource.getMessage("employment.type.has.been.deleted.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();
		model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));

		return "manageempltypes";
	}

	@RequestMapping(value = "/administration/edit/empltype/{employmentTypeId}", method = RequestMethod.GET)
	public String editEmploymentTypeGet(
					Model model, 
					@PathVariable("employmentTypeId") int employmentTypeId, 
					Locale locale) {
		
		EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(employmentTypeId);
		
		if (employmentType == null)	 {
			return "404";
		}
		
		model.addAttribute("employmentType", locatizationTool.processEmploymentType(employmentType, locale));
		return "editempltype";
	}

	@RequestMapping(value = "/administration/edit/empltype/{employmentTypeId}", method = RequestMethod.POST)
	public String editEmploymentTypePost(
					Model model,
					@Valid @ModelAttribute("employmentTypeId") EmploymentType fEmploymentType,
					BindingResult result,
					@PathVariable("employmentTypeId") int employmentTypeId,
					Locale locale) {

		if (result.hasErrors()) {
			String msg = messageSource.getMessage("employment.type.has.not.been.changed.validation", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("employmentType", locatizationTool.processEmploymentType(fEmploymentType, locale));
			return "editempltype";
		}

		EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(employmentTypeId);
		
		if (employmentType == null)	 {
			return "404";
		}

		employmentType.setDescription(fEmploymentType.getDescription());
		employmentTypeService.updateEmploymentType(employmentType);

		String msg = messageSource.getMessage("employment.type.has.been.changed.validation", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();
		model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));

		return "manageempltypes";
	}

}
