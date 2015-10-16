package org.ekonopaka.crm.controllers;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;
import org.ekonopaka.crm.service.interfaces.IOfficeService;
import org.ekonopaka.crm.service.interfaces.IPhoneService;
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
public class PhoneNumberController {

	@Autowired
	IPhoneService phoneService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	MessageGenerator messageGenerator;

	@Autowired
	IOfficeService officeService;

	@RequestMapping(value = "/administration/managephonenumbers", method = RequestMethod.GET)
	public String managePhoneNumbers(
					Model model	) {
		
		List<PhoneNumber> phoneNumbersList = phoneService.getPhoneNumbers();

		model.addAttribute("phoneNumbersList", phoneNumbersList);
		return "managephonenumbers";
	}
	
	@RequestMapping(value = "/administration/addphonenumber", method = RequestMethod.GET)
	public String addPhoneNumberGet(
					Model model	) {
		
		List<Office> officesList = officeService.getOffices();

		model.addAttribute("officesList", officesList);
		model.addAttribute("phoneNumber", phoneService.getNewPhoneNumber());
		return "addphonenumber";
	}

	@RequestMapping(value = "/administration/addphonenumber", method = RequestMethod.POST)
	public String addPhoneNumberPost(
					Model model, 
					@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, 
					BindingResult result, 
					Locale locale) {
		
		if (result.hasErrors()) {
			List<Office> officesList = officeService.getOffices();
			model.addAttribute("officesList", officesList);
			model.addAttribute("phoneNumber", phoneNumber);
			String msg = messageSource.getMessage("phone.number.has.not.been.created.validation", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			return "addphonenumber";
		}

		if (phoneNumber.getOffice() == null) {
			String msg = messageSource.getMessage("phone.number.has.been.created.with.no.office", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		} else {
			String msg = messageSource.getMessage("phone.number.has.been.created", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		}

		phoneService.addPhoneNumber(phoneNumber);

		List<PhoneNumber> phoneNumbersList = phoneService.getPhoneNumbers();
		model.addAttribute("phoneNumbersList", phoneNumbersList);
		
		return "managephonenumbers";
	}

	@RequestMapping(value = "/administration/delete/phonenumber/{phoneNumberId}", method = RequestMethod.GET)
	public String deletePhoneNumberGet(
					Model model, 
					@PathVariable("phoneNumberId") int phoneNumberId, 
					Locale locale) {
		
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(phoneNumberId);
		
		if (phoneNumber == null)	 {
			return "404";
		}
		
		model.addAttribute("phoneNumber", phoneNumber);
		return "deletephonenumber";
	}

	@RequestMapping(value = "/administration/delete/phonenumber/{phoneNumberId}", method = RequestMethod.POST)
	public String deletePhoneNumberPost(
					Model model, 
					@PathVariable("phoneNumberId") int phoneNumberId, 
					Locale locale) {
		
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(phoneNumberId);
		if (phoneNumber == null)	 {
			return "404";
		}
		
		phoneService.deletePhoneNumber(phoneNumber);

		String msg = messageSource.getMessage("phone.number.has.been.deleted.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		List<PhoneNumber> phoneNumbersList = phoneService.getPhoneNumbers();
		model.addAttribute("phoneNumbersList", phoneNumbersList);
		return "managephonenumbers";
	}

	@RequestMapping(value = "/administration/edit/phonenumber/{phoneNumberId}", method = RequestMethod.GET)
	public String editPhoneNumberGet(
					Model model, 
					@PathVariable("phoneNumberId") int phoneNumberId) {

		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(phoneNumberId);
		if (phoneNumber == null)	 {
			return "404";
		}
		
		List<Office> officesList = officeService.getOffices();

		model.addAttribute("officesList", officesList);
		model.addAttribute("phoneNumber", phoneNumber);
		return "editphonenumber";
	}

	@RequestMapping(value = "/administration/edit/phonenumber/{phoneNumberId}", method = RequestMethod.POST)
	public String editPhoneNumberPost(
					Model model, 
					@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, 
					BindingResult result, 
					@PathVariable("phoneNumberId") int phoneNumberId, 
					Locale locale) {
		
		if (result.hasErrors()) {
			List<Office> officesList = officeService.getOffices();
			String msg = messageSource.getMessage("phone.number.has.not.been.updated.validation", null,	locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("phoneNumber", phoneNumber);
			model.addAttribute("officesList", officesList);
			return "editphonenumber";
		}

		PhoneNumber pPhoneNumber = phoneService.getPhoneNumberById(phoneNumberId);
		if (pPhoneNumber == null)	 {
			return "404";
		}
		phoneNumber.setId(pPhoneNumber.getId());

		phoneService.updatePhoneNumber(phoneNumber);
		String msg = messageSource.getMessage("phone.number.has.been.updated.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		List<PhoneNumber> phoneNumbersList = phoneService.getPhoneNumbers();
		model.addAttribute("phoneNumbersList", phoneNumbersList);
		return "managephonenumbers";
	}

}
