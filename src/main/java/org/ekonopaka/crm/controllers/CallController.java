package org.ekonopaka.crm.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.ekonopaka.crm.form.CallWrapper;
import org.ekonopaka.crm.handlers.LocatizationTool;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.AdditionalCallInfo;
import org.ekonopaka.crm.model.Call;
import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.ClientPhoneNumber;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.PhoneNumber;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.types.CreditType;
import org.ekonopaka.crm.model.types.CurrencyType;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.service.interfaces.ICallService;
import org.ekonopaka.crm.service.interfaces.IClientPhoneService;
import org.ekonopaka.crm.service.interfaces.IClientService;
import org.ekonopaka.crm.service.interfaces.IConstansService;
import org.ekonopaka.crm.service.interfaces.ICreditService;
import org.ekonopaka.crm.service.interfaces.IEmploymentTypeService;
import org.ekonopaka.crm.service.interfaces.IInfoSourceService;
import org.ekonopaka.crm.service.interfaces.IPhoneService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.ekonopaka.crm.validators.ClientValidatorPhoneNumbersValidator;
import org.ekonopaka.crm.validators.ClientValidatorSpecificEmploymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CallController {
	
	@Autowired
	IClientService clientService;
	
	@Autowired
	LocatizationTool locatizationTool;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ICallService callService;
	
	@Autowired
	IEmploymentTypeService employmentTypeService;
	
	@Autowired
	MessageGenerator messageGenerator;

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	IClientPhoneService clientPhoneService;
	
	@Autowired
	IPhoneService phoneService;
	
	@Autowired
	ICreditService creditService;
	
	@Autowired
	IInfoSourceService infoSourceService;
	
	@Autowired
	ClientValidatorPhoneNumbersValidator phoneNumbersValidator;

	@Autowired
	ClientValidatorSpecificEmploymentType specificEmploymentTypeValidator;
	
	@Autowired
	IConstansService constansService;

	/**
	 * First step. Client Info. Get Method
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/workflow/addcall", method = RequestMethod.GET)
	public String addCallClientGet(	Model model, Locale locale) {
		
		List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();

		Client client = clientService.getNewClient(false);

		model.addAttribute("client", client);
		model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));

		return "addcallclient";
	}
	
	/**
	 * First step. Client Info. Post Method
	 * @param model
	 * @param client
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/workflow/addcall", method = RequestMethod.POST)
	public String addCallClientPost(	Model model, 
										@Valid @ModelAttribute("client") Client client, 
										BindingResult result, 
										Locale locale	) 	{

		specificEmploymentTypeValidator.validate(client, result);

		if (result.hasErrors()) {
			List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();
			model.addAttribute("client", client);
			model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));
			return "addcallclient";
		}

		if (client.getSpecificEmploymentType() != null && !client.getSpecificEmploymentType().equals("")) {
			EmploymentType employmentType = employmentTypeService.getNewEmploymentType();
			employmentType.setDescription(client.getSpecificEmploymentType());
			employmentTypeService.addEmploymentType(employmentType);
			client.setEmploymentType(employmentType);
		}
		
		clientService.addClient(client);

		return "redirect:/workflow/addcall/client/" + client.getId();
	}
	
	/**
	 * Second step. Office Phone Numbers Info. Get Method
	 * @param model
	 * @param clientId
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/workflow/addcall/client/{clientId}", method = RequestMethod.GET)
	public String addCallOfficePhoneNumberGet(	Model model, 
										@PathVariable int clientId, 
										Locale locale)	{

		User user = userService.getCurrentUser();
		List<PhoneNumber> phoneNumbersList = null;
		
		if (user.getIsAdmin())	{
			phoneNumbersList = phoneService.getPhoneNumbers();
		} else {
			phoneNumbersList = phoneService.getPhoneNumbers(userService.getCurrentUser().getOffice());
		}
		
		model.addAttribute("phoneNumbersList", locatizationTool.processPhoneNumbers(phoneNumbersList, locale));
		model.addAttribute("callWrapper", new CallWrapper());
		
		return "addcallofficephone";
	}
	
	/**
	 * Second step. Office Phone Numbers Info. Post Method
	 * @param model
	 * @param callWrapper
	 * @param result
	 * @param clientId
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/workflow/addcall/client/{clientId}", method = RequestMethod.POST)
	public String addCallOfficePhoneNumberPost(	Model model, 
										@Valid @ModelAttribute("callWrapper") CallWrapper callWrapper, 
										BindingResult result,
										@PathVariable int clientId, 
										Locale locale)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(callWrapper.getPhoneNumber().getId());
		
		if (client == null || phoneNumber == null)	 {
			return "404";
		}
		
		return "redirect:/workflow/addcall/client/" + client.getId() + "/officephone/" + phoneNumber.getId();
	}
	
	/**
	 * Third step. Credit Info. Get Method
	 * @param model
	 * @param clientId
	 * @param officePhoneNumberId
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}", method = RequestMethod.GET)
	public String addCallAddCreditGet(	Model model,
										@PathVariable int clientId, 
										@PathVariable int officePhoneNumberId,
										Locale locale)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		
		if (client == null || phoneNumber == null)	 {
			return "404";
		}
		
		List<CreditType> creditTypesList = creditService.getCreditTypes();
		List<CurrencyType> currencyTypes = constansService.getCurrencyTypes(locale);
				
		model.addAttribute("credit", new Credit());
		model.addAttribute("creditTypesList", locatizationTool.processCreditTypes(creditTypesList, locale));
		model.addAttribute("currencyTypesList", currencyTypes);
		
		return "addcallcredit";
	}
	
	/**
	 * Third step. Credit Info. Post Method
	 * @param model
	 * @param credit
	 * @param result
	 * @param clientId
	 * @param officePhoneNumberId
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}", method = RequestMethod.POST)
	public String addCallAddCreditPost(	Model model,
			@Valid @ModelAttribute Credit credit,
			BindingResult result,
			@PathVariable int clientId, 
			@PathVariable int officePhoneNumberId,
			Locale locale)	{
		
		if (result.hasErrors())	{
			List<CreditType> creditTypesList = creditService.getCreditTypes();
			List<CurrencyType> currencyTypes = constansService.getCurrencyTypes(locale);
			model.addAttribute("credit", credit);
			model.addAttribute("creditTypesList", locatizationTool.processCreditTypes(creditTypesList, locale));
			model.addAttribute("currencyTypesList", currencyTypes);
			return "addcallcredit";
		}
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		
		if (client == null || phoneNumber == null)	 {
			return "404";
		}
		
		credit.setIsDealCredit(false);
		creditService.addCredit(credit);
		
		return "redirect:/workflow/addcall/" +
				"client/" +	client.getId() + 
				"/officephone/" +	phoneNumber.getId() + 
				"/credit/" + credit.getId();
	}
	
	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}/credit/{creditId}", method = RequestMethod.GET)
	public String addCallSourceGet(	Model model,
											@PathVariable int clientId, 
											@PathVariable int officePhoneNumberId,
											@PathVariable int creditId,
											Locale locale	)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		Credit credit = creditService.getCredit(creditId);
		List<InfoSource> infoSourcesList = infoSourceService.getInfoSources();
		
		if (client == null || phoneNumber == null || credit == null)	 {
			return "404";
		}
		
		model.addAttribute("callWrapper", new CallWrapper());
		model.addAttribute("infoSourcesList", locatizationTool.processInfoSources(infoSourcesList, locale));
		
		return "addcallsource";
	}
	
	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}/credit/{creditId}", method = RequestMethod.POST)
	public String addCallSourcePost(	Model model,
										@Valid @ModelAttribute("callWrapper") CallWrapper callWrapper, 
										@PathVariable int clientId, 
										@PathVariable int officePhoneNumberId,
										@PathVariable int creditId,
										Locale locale	)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		Credit credit = creditService.getCredit(creditId);
		
		if (client == null || phoneNumber == null || credit == null)	 {
			return "404";
		}
		
		InfoSource source = infoSourceService.getInfoSourceById(callWrapper.getInfoSource().getId());
		
		return "redirect:/workflow/addcall/" +
				"client/" +	client.getId() + 
				"/officephone/" +	phoneNumber.getId() + 
				"/credit/" + credit.getId() + 
				"/source/" + source.getId();
	}

	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}/credit/{creditId}/source/{sourceId}", method = RequestMethod.GET)
	public String addCallAdditionalInfoGet(	Model model,
											@PathVariable int clientId, 
											@PathVariable int officePhoneNumberId,
											@PathVariable int creditId,
											@PathVariable int sourceId,
											Locale locale)	{
		model.addAttribute("additionalCallInfo", new AdditionalCallInfo());
		model.addAttribute("interestTypesList", constansService.getInterestTypes(locale));
		return "addcalladditionalcallinfo";
	}

	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}/credit/{creditId}/source/{sourceId}", method = RequestMethod.POST)
	public String addCallAdditionalInfoPost(	Model model,
												@Valid @ModelAttribute("additionalCallInfo") AdditionalCallInfo additionalCallInfo,
												BindingResult result,
												@PathVariable int clientId, 
												@PathVariable int officePhoneNumberId,
												@PathVariable int creditId,
												@PathVariable int sourceId,
												Locale locale)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		Credit credit = creditService.getCredit(creditId);
		InfoSource source = infoSourceService.getInfoSourceById(sourceId);
		
		if (client == null || phoneNumber == null || credit == null || source == null || additionalCallInfo == null)	 {
			return "404";
		}
		
		if (result.hasErrors()) {
			model.addAttribute("additionalCallInfo", additionalCallInfo);
			return "addcalladditionalcallinfo";
		}
		
		callService.addAdditionalInfo(additionalCallInfo);
		
		return "redirect:/workflow/addcall/" +
				"client/" +	client.getId() + 
				"/officephone/" +	phoneNumber.getId() + 
				"/credit/" + credit.getId() + 
				"/source/" + source.getId() + 
				"/additionalinfo/" + additionalCallInfo.getId();
	}
	
	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}/credit/{creditId}/source/{sourceId}/additionalinfo/{addInfoId}", method = RequestMethod.GET)
	public String addCallClientPhoneGet(	Model model,
										@PathVariable int clientId, 
										@PathVariable int officePhoneNumberId,
										@PathVariable int creditId,
										@PathVariable int sourceId,
										@PathVariable int addInfoId,
										Locale locale)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		Credit credit = creditService.getCredit(creditId);
		InfoSource source = infoSourceService.getInfoSourceById(sourceId);
		AdditionalCallInfo info = callService.getAdditionalInfo(addInfoId);
		
		if (client == null || phoneNumber == null || credit == null || source == null || info == null)	 {
			return "404";
		}
		
		model.addAttribute("clientPhoneNumber", new ClientPhoneNumber());
		return "addcallclientnumber";
	}
	
	@RequestMapping(value = "/workflow/addcall/client/{clientId}/officephone/{officePhoneNumberId}/credit/{creditId}/source/{sourceId}/additionalinfo/{addInfoId}", method = RequestMethod.POST)
	public String addCallClientPhonePost(	Model model,
										@Valid @ModelAttribute ClientPhoneNumber clientPhoneNumber,
										BindingResult result,
										@PathVariable int clientId, 
										@PathVariable int officePhoneNumberId,
										@PathVariable int creditId,
										@PathVariable int sourceId,
										@PathVariable int addInfoId,
										Locale locale)	{
		
		Client client = clientService.getClientById(clientId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		Credit credit = creditService.getCredit(creditId);
		InfoSource source = infoSourceService.getInfoSourceById(sourceId);
		AdditionalCallInfo info = callService.getAdditionalInfo(addInfoId);
		
		if (client == null || phoneNumber == null || credit == null || source == null || info == null)	 {
			return "404";
		}
		
		if (result.hasErrors()) {
			model.addAttribute("clientPhoneNumber", clientPhoneNumber);
			return "addcallclientnumber";
		}
		
		clientPhoneService.addClientPhoneNumber(clientPhoneNumber);
		User user = userService.getCurrentUser();
		
		Call call = new Call();
		
		call.setClientPhoneNumber(clientPhoneNumber);
		call.setCredit(credit);
		call.setUser(user);
		call.setInfoSource(source);
		call.setOfficePhoneNumber(phoneNumber);
		call.setClient(client);
		call.setAdditionalCallInfo(info);
		
		callService.addCall(call);
		
		String msg = messageSource.getMessage("call.has.been.created.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		
		return "workflow";
	}
	
	@RequestMapping(value = "/workflow/managecalls/init", method = RequestMethod.GET)
	public String manageCalls() {
		return "managecalls";
	}
	
	@RequestMapping(value = "/workflow/managecalls/serverprocessing", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String manageCallsSSP(	HttpServletRequest request, 
													HttpServletResponse response, 
													Locale locale	) {
		User user = userService.getCurrentUser();
		
		DataTableHandler dataTableHandler = new DataTableHandler(request);
		String output = callService.getCalls(dataTableHandler, user, null ,locale);
		return output;
	}
	
	@RequestMapping(value = "/workflow/managecalls/user/{userId}/init", method = RequestMethod.GET)
	public String manageCallsByUser(Model model, @PathVariable("userId") int userId) {
		User userToGetCalls = userService.getUserById(userId);
		
		model.addAttribute("user", userToGetCalls);
		return "manageusercalls";
	}
	
	@RequestMapping(value = "/workflow/managecalls/user/view/call/{callId}", method = RequestMethod.GET)
	public String viewCallRedirect(@PathVariable("callId") int callId){
		return "redirect:/workflow/view/call/" + callId; 
	}
	
	@RequestMapping(value = "/workflow/managecalls/user/edit/call/{callId}", method = RequestMethod.GET)
	public String editCallRedirect(@PathVariable("callId") int callId){
		return "redirect:/workflow/edit/call/" + callId;
	}

	@RequestMapping(value = "/workflow/managecalls/user/delete/call/{callId}", method = RequestMethod.GET)
	public String deleteCallRedirect(@PathVariable("callId") int callId){
		return "redirect:/workflow/delete/call/" + callId;
	}
	
	@RequestMapping(value = "/workflow/managecalls/user/{userId}/serverprocessing", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String manageCallsSSPByUser(	HttpServletRequest request, 
													HttpServletResponse response, 
													@PathVariable("userId") int userId, 
													Locale locale	) {
		User user = userService.getCurrentUser();
		User userToGetCalls = userService.getUserById(userId);
		
		DataTableHandler dataTableHandler = new DataTableHandler(request);
		String output = callService.getCalls(dataTableHandler, user, userToGetCalls ,locale);
		return output;
	}
	
	@RequestMapping(value = "/workflow/delete/call/{callId}", method = RequestMethod.GET)
	public String deleteCallGet(Model model, 
			@PathVariable("callId") int callId, 
			Locale locale)	{
		
		Call call = callService.getCall(callId);
		
		if (call == null)	 {
			return "404";
		}
		
		call.getCredit().setCreditType(locatizationTool.processCreditType(call.getCredit().getCreditType(), locale));
		
		model.addAttribute("call", call);
		
		return "deletecall";
	}
	
	@RequestMapping(value = "/workflow/delete/call/{callId}", method = RequestMethod.POST)
	public String deleteCallPost(Model model, 
			@PathVariable("callId") int clientId, 
			Locale locale)	{
		
		Call call = callService.getCall(clientId);
		
		if (call == null)	 {
			return "404";
		}
		
		callService.deleteCall(call);
		
		String msg = messageSource.getMessage("call.has.been.deleted.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		
		return "workflow";
	}
	
	@RequestMapping(value = "/workflow/view/call/{callId}", method = RequestMethod.GET)
	public String viewCallGet(Model model, 
			@PathVariable("callId") int clientId, 
			Locale locale)	{
		
		Call call = callService.getCall(clientId);
		
		if (call == null)	 {
			return "404";
		}
		
		call.getCredit().setCreditType(locatizationTool.processCreditType(call.getCredit().getCreditType(), locale));
		call.setInfoSource(locatizationTool.processInfoSource(call.getInfoSource(), locale));
		call.getCredit().setCurrencyType(locatizationTool.processCurrencyType(call.getCredit().getCurrencyType(), locale));
		call.getClient().setEmploymentType(locatizationTool.processEmploymentType(call.getClient().getEmploymentType(), locale));
		call.getAdditionalCallInfo().setInterestType(locatizationTool.process(call.getAdditionalCallInfo().getInterestType(), locale));
		
		model.addAttribute("call", call);
		
		return "viewcall";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}", method = RequestMethod.GET)
	public String editCallGet(Model model, 
			@PathVariable("callId") int clientId, 
			Locale locale)	{
		
		Call call = callService.getCall(clientId);
		
		if (call == null)	 {
			return "404";
		}
		
		call.getCredit().setCreditType(locatizationTool.processCreditType(call.getCredit().getCreditType(), locale));
		call.setInfoSource(locatizationTool.processInfoSource(call.getInfoSource(), locale));
		call.getCredit().setCurrencyType(locatizationTool.processCurrencyType(call.getCredit().getCurrencyType(), locale));
		call.getClient().setEmploymentType(locatizationTool.processEmploymentType(call.getClient().getEmploymentType(), locale));
		call.getAdditionalCallInfo().setInterestType(locatizationTool.process(call.getAdditionalCallInfo().getInterestType(), locale));
		
		model.addAttribute("call", call);
		
		return "editcall";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/client/{clientId}", method = RequestMethod.GET)
	public String editCallClientGet(	Model model, 
										@PathVariable("callId") int callId,
										@PathVariable("clientId") int clientId,
										Locale locale) {
		
		Call call = callService.getCall(callId);
		Client client = clientService.getClientById(clientId);
		
		if (call == null || client == null)	 {
			return "404";
		}

		List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();
		model.addAttribute("client", client);
		model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));
		model.addAttribute("call", call);

		return "editcallclient";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/client/{clientId}", method = RequestMethod.POST)
	public String editCallClientPost(	Model model, 
			@Valid @ModelAttribute("client") Client client, 
			BindingResult result, 
			@PathVariable("callId") int callId,
			@PathVariable("clientId") int clientId,
			Locale locale	) 	{
		
		Call call = callService.getCall(callId);
		
		if (call == null || client == null)	 {
			return "404";
		}

		if (result.hasErrors()) {
			List<EmploymentType> employmentTypesList = employmentTypeService.getEmploymentTypes();
			model.addAttribute("client", client);
			model.addAttribute("employmentTypesList", locatizationTool.processEmploymentTypes(employmentTypesList, locale));
			return "editcallclient";
		}
		
		client.setId(clientId);
		clientService.updateClient(client);
		
		return "redirect:/workflow/view/call/" + call.getId();
	}
	
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/officephone/{officePhoneNumberId}", method = RequestMethod.GET)
	public String editCallOfficePhoneNumberGet(	Model model, 
			@PathVariable("callId") int callId,
			@PathVariable("officePhoneNumberId") int officePhoneNumberId,
			Locale locale) {
		Call call = callService.getCall(callId);
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(officePhoneNumberId);
		
		if (call == null || phoneNumber == null)	 {
			return "404";
		}
		
		User user = userService.getCurrentUser();
		List<PhoneNumber> phoneNumbersList = null;
		
		if (user.getIsAdmin())	{
			phoneNumbersList = phoneService.getPhoneNumbers();
		} else {
			phoneNumbersList = phoneService.getPhoneNumbers(userService.getCurrentUser().getOffice());
		}
		
		CallWrapper callWrapper = new CallWrapper();
		callWrapper.setPhoneNumber(phoneNumber);
		
		model.addAttribute("phoneNumbersList", locatizationTool.processPhoneNumbers(phoneNumbersList, locale));
		model.addAttribute("callWrapper", callWrapper);
		model.addAttribute("call", call);
		
		return "editcallofficephone";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/officephone/{officePhoneNumberId}", method = RequestMethod.POST)
	public String editCallClientPost(	Model model, 
			@Valid @ModelAttribute("callWrapper") CallWrapper callWrapper, 
			BindingResult result, 
			@PathVariable("callId") int callId,
			@PathVariable("officePhoneNumberId") int officePhoneNumberId,
			Locale locale	) 	{
		
		Call call = callService.getCall(callId);
		
		PhoneNumber phoneNumber = phoneService.getPhoneNumberById(callWrapper.getPhoneNumber().getId());
		
		call.setOfficePhoneNumber(phoneNumber);
		
		callService.updateCall(call);
		
		return "redirect:/workflow/view/call/" + call.getId();
	}

	@RequestMapping(value = "/workflow/edit/call/{callId}/credit/{creditId}", method = RequestMethod.GET)
	public String editCallAddCreditGet(	Model model,
			@PathVariable int callId, 
			@PathVariable int creditId,
			Locale locale)	{

		Call call = callService.getCall(callId);
		Credit credit = creditService.getCredit(creditId);
		
		if (call == null || credit == null)	 {
			return "404";
		}
		
		List<CreditType> creditTypesList = creditService.getCreditTypes();
		List<CurrencyType> currencyTypes = constansService.getCurrencyTypes(locale);
		
		model.addAttribute("credit", credit);
		model.addAttribute("creditTypesList", locatizationTool.processCreditTypes(creditTypesList, locale));
		model.addAttribute("currencyTypesList", currencyTypes);
		model.addAttribute("call", call);
		
		return "editcallcredit";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/credit/{creditId}", method = RequestMethod.POST)
	public String editCallClientPost(	Model model, 
			@Valid @ModelAttribute("credit") Credit fCredit, 
			BindingResult result, 
			@PathVariable("callId") int callId,
			@PathVariable("creditId") int creditId,
			Locale locale	) 	{
		
		Call call = callService.getCall(callId);
		Credit pCredit = creditService.getCredit(creditId);
		
		if (call == null || pCredit == null || fCredit == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			List<CreditType> creditTypesList = creditService.getCreditTypes();
			List<CurrencyType> currencyTypes = constansService.getCurrencyTypes(locale);
			model.addAttribute("credit", fCredit);
			model.addAttribute("creditTypesList", locatizationTool.processCreditTypes(creditTypesList, locale));
			model.addAttribute("currencyTypesList", currencyTypes);
			return "editcallcredit";
		}
		
		fCredit.setId(pCredit.getId());
		creditService.updateCredit(fCredit);
		
		return "redirect:/workflow/view/call/" + call.getId();
	}

	@RequestMapping(value = "/workflow/edit/call/{callId}/source/{infoSourceId}", method = RequestMethod.GET)
	public String editCallSourceGet(	Model model,
			@PathVariable int callId, 
			@PathVariable int infoSourceId,
			Locale locale	)	{
		
		Call call = callService.getCall(callId);
		InfoSource source = infoSourceService.getInfoSourceById(infoSourceId);
		
		if (call == null || source == null)	 {
			return "404";
		}

		List<InfoSource> infoSourcesList = infoSourceService.getInfoSources();
		
		CallWrapper callWrapper = new CallWrapper();
		callWrapper.setInfoSource(source);
		
		model.addAttribute("callWrapper", callWrapper);
		model.addAttribute("infoSourcesList", locatizationTool.processInfoSources(infoSourcesList, locale));
		model.addAttribute("call", call);
		
		return "editcallsource";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/source/{infoSourceId}", method = RequestMethod.POST)
	public String editCallSourcePost(	Model model,
			@Valid @ModelAttribute("callWrapper") CallWrapper callWrapper,
			BindingResult result,
			@PathVariable int callId, 
			@PathVariable int infoSourceId,
			Locale locale)	{
		
		Call call = callService.getCall(callId);
		
		InfoSource source = callWrapper.getInfoSource();
		
		if (source == null)	 {
			return "404";
		}
		
		call.setInfoSource(source);
		
		callService.updateCall(call);
		
		return "redirect:/workflow/view/call/" + call.getId();
	}

	@RequestMapping(value = "/workflow/edit/call/{callId}/additionalinfo/{additionalCallInfoId}", method = RequestMethod.GET)
	public String editCallAdditionalInfoGet(	Model model,
												@PathVariable int callId, 
												@PathVariable int additionalCallInfoId,
												Locale locale)	{
		Call call = callService.getCall(callId);
		AdditionalCallInfo info = callService.getAdditionalInfo(additionalCallInfoId);
		
		if (call == null || info == null)	 {
			return "404";
		}
		
		model.addAttribute("additionalCallInfo", info);
		model.addAttribute("interestTypesList", constansService.getInterestTypes(locale));
		model.addAttribute("call", call);
		return "editcalladditionalcallinfo";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/additionalinfo/{additionalCallInfoId}", method = RequestMethod.POST)
	public String editCallClientPost(	Model model, 
			@Valid @ModelAttribute("additionalCallInfo") AdditionalCallInfo fAdditionalCallInfo, 
			BindingResult result, 
			@PathVariable("callId") int callId,
			@PathVariable("additionalCallInfoId") int additionalCallInfoId,
			Locale locale	) 	{
		
		Call call = callService.getCall(callId);
		AdditionalCallInfo pAdditionalCallInfo = callService.getAdditionalInfo(additionalCallInfoId);
		
		if (call == null || pAdditionalCallInfo == null || fAdditionalCallInfo == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("additionalCallInfo", fAdditionalCallInfo);
			return "editcalladditionalcallinfo";
		}
		
		fAdditionalCallInfo.setId(pAdditionalCallInfo.getId());
		callService.updateAdditionalInfo(fAdditionalCallInfo);
		
		return "redirect:/workflow/view/call/" + call.getId();
	}

	@RequestMapping(value = "/workflow/edit/call/{callId}/clientphone/{clientPhoneNumberId}", method = RequestMethod.GET)
	public String editCallClientPhoneGet(	Model model,
			@PathVariable int callId, 
			@PathVariable int clientPhoneNumberId,
			Locale locale)	{

		Call call = callService.getCall(callId);
		ClientPhoneNumber clientPhoneNumber = clientPhoneService.getClientPhoneNumber(clientPhoneNumberId);

		if (call == null || call == null)	 {
			return "404";
		}

		model.addAttribute("clientPhoneNumber", clientPhoneNumber);
		model.addAttribute("call", call);
		return "editcallclientnumber";
	}
	
	@RequestMapping(value = "/workflow/edit/call/{callId}/clientphone/{clientPhoneNumberId}", method = RequestMethod.POST)
	public String editCallClientPhonePost(	Model model, 
			@Valid @ModelAttribute("clientPhoneNumber") ClientPhoneNumber fClientPhoneNumber, 
			BindingResult result, 
			@PathVariable("callId") int callId,
			@PathVariable("clientPhoneNumberId") int clientPhoneNumberId,
			Locale locale	) 	{
		
		Call call = callService.getCall(callId);
		ClientPhoneNumber pClientPhoneNumber = clientPhoneService.getClientPhoneNumber(clientPhoneNumberId);
		
		if (call == null || pClientPhoneNumber == null || fClientPhoneNumber == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("clientPhoneNumber", fClientPhoneNumber);
			return "editcalladditionalcallinfo";
		}
		
		fClientPhoneNumber.setId(pClientPhoneNumber.getId());

		clientPhoneService.updateClientPhoneNumber(fClientPhoneNumber);
		
		return "redirect:/workflow/view/call/" + call.getId();
	}

	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 dateFormat.setLenient(false);
		 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }
	
}
