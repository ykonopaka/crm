package org.ekonopaka.crm.controllers;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.ekonopaka.crm.actions.Action;
import org.ekonopaka.crm.constants.Employments;
import org.ekonopaka.crm.constants.MaritalStatuses;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.AdditionalWorkingPlace;
import org.ekonopaka.crm.model.Address;
import org.ekonopaka.crm.model.Attachment;
import org.ekonopaka.crm.model.Comment;
import org.ekonopaka.crm.model.ContactPersons;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.CreditCard;
import org.ekonopaka.crm.model.Customer;
import org.ekonopaka.crm.model.CustomerPhoneSet;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.IncomeOutcome;
import org.ekonopaka.crm.model.Marriage;
import org.ekonopaka.crm.model.Passport;
import org.ekonopaka.crm.model.PreviousWorkingPlace;
import org.ekonopaka.crm.model.Property;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.WorkingPlace;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.service.interfaces.IAdditionalWorkingPlaceService;
import org.ekonopaka.crm.service.interfaces.IAddressService;
import org.ekonopaka.crm.service.interfaces.IAttachmentService;
import org.ekonopaka.crm.service.interfaces.ICommentsService;
import org.ekonopaka.crm.service.interfaces.IConstansService;
import org.ekonopaka.crm.service.interfaces.IContactPersonService;
import org.ekonopaka.crm.service.interfaces.ICreditCardService;
import org.ekonopaka.crm.service.interfaces.ICreditService;
import org.ekonopaka.crm.service.interfaces.ICustomerPhoneSetService;
import org.ekonopaka.crm.service.interfaces.ICustomerService;
import org.ekonopaka.crm.service.interfaces.IDealService;
import org.ekonopaka.crm.service.interfaces.IEmploymentTypeService;
import org.ekonopaka.crm.service.interfaces.IIncomeOutcomeService;
import org.ekonopaka.crm.service.interfaces.IMarriageService;
import org.ekonopaka.crm.service.interfaces.IPassportService;
import org.ekonopaka.crm.service.interfaces.IPreviousWorkingPlaceService;
import org.ekonopaka.crm.service.interfaces.IPropertyService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.ekonopaka.crm.service.interfaces.IWorkflowService;
import org.ekonopaka.crm.service.interfaces.IWorkingPlaceService;
import org.ekonopaka.crm.validators.deals.DealCreditCardsValidator;
import org.ekonopaka.crm.validators.deals.DealCreditValidator;
import org.ekonopaka.crm.validators.deals.DealCustomerValidator;
import org.ekonopaka.crm.validators.deals.DealIncomeOutcomeValidator;
import org.ekonopaka.crm.validators.deals.DealMarriageValidator;
import org.ekonopaka.crm.validators.deals.DealPassportValidator;
import org.ekonopaka.crm.validators.deals.DealPropertyValidator;
import org.ekonopaka.crm.validators.deals.DealWorkingPlaceValidator;
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
public class DealController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	MessageGenerator messageGenerator;
	
	@Autowired
	IConstansService constansService;
	
	@Autowired
	IEmploymentTypeService employmentTypeService;
	
	@Autowired
	ICreditService creditService;
	
	@Autowired
	IContactPersonService contactPersonService;
	
	@Autowired
	IPropertyService propertyService;
	
	@Autowired
	IIncomeOutcomeService incomeOutcomeService;
	
	@Autowired
	ICreditCardService creditCardService;
	
	@Autowired
	ICommentsService commentsService;
	
	@Autowired
	IWorkingPlaceService workingPlaceService;
	
	@Autowired
	IAdditionalWorkingPlaceService additionalWorkingPlaceService;
	
	@Autowired
	IPreviousWorkingPlaceService previousWorkingPlaceService;
	
	@Autowired
	ICustomerPhoneSetService customerPhoneSetService;
	
	@Autowired
	IDealService dealService;
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IPassportService passportService;
	
	@Autowired
	IMarriageService marriageService;
	
	@Autowired
	IAddressService addressService;
	
	@Autowired
	DealCreditValidator creditValidator;
	
	@Autowired
	DealCustomerValidator customerValidator;
	
	@Autowired
	DealPassportValidator passportValidator;
	
	@Autowired
	DealWorkingPlaceValidator workingPlaceValidator;
	
	@Autowired
	DealIncomeOutcomeValidator incomeOutcomeValidator;
	
	@Autowired
	DealPropertyValidator propertyValidator;
	
	@Autowired
	DealCreditCardsValidator cardsValidator;
	
	@Autowired
	DealMarriageValidator marriageValidator;
	
	@Autowired
	IAttachmentService attachmentService;
	
	@Autowired
	IWorkflowService workflowService;
	
	@RequestMapping(value = "/workflow/managedeals/init", method = RequestMethod.GET)
	public String manageCalls() {
		return "managedeals";
	}
	
	@RequestMapping(value = "/workflow/managedeals/serverprocessing", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String manageCallsSSP(	HttpServletRequest request, 
												HttpServletResponse response, 
												Locale locale	) throws UnsupportedEncodingException {
		User user = userService.getCurrentUser();
		
		DataTableHandler dataTableHandler = new DataTableHandler(request);
		
		String output = dealService.getDeals(dataTableHandler, user, user, locale);
		return output;
	}
	
	@RequestMapping(value = "/workflow/managedeals/user/{userId}/init", method = RequestMethod.GET)
	public String manageDealsByUser(Model model, @PathVariable("userId") int userId) {
		User userToGetDeals = userService.getUserById(userId);
		
		model.addAttribute("user", userToGetDeals);
		return "manageuserdeals";
	}
	
	@RequestMapping(value = "/workflow/managedeals/user/{userId}/serverprocessing", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public @ResponseBody String manageCallsSSPByUser(	HttpServletRequest request, 
													HttpServletResponse response, 
													@PathVariable("userId") int userId, 
													Locale locale	) throws UnsupportedEncodingException {
		User user = userService.getCurrentUser();
		User userToGetCalls = userService.getUserById(userId);
		
		DataTableHandler dataTableHandler = new DataTableHandler(request);
		String output = dealService.getDeals(dataTableHandler, user, userToGetCalls ,locale);
		return output;
	}
	
	@RequestMapping(value = "/workflow/managedeals/user/view/deal/{dealId}", method = RequestMethod.GET)
	public String viewDealRedirect(@PathVariable("dealId") int dealId){
		return "redirect:/workflow/view/deal/" + dealId; 
	}
	
	@RequestMapping(value = "/workflow/managedeals/user/edit/deal/{dealId}", method = RequestMethod.GET)
	public String editDealRedirect(@PathVariable("dealId") int dealId){
		return "redirect:/workflow/edit/deal/" + dealId;
	}

	@RequestMapping(value = "/workflow/managedeals/user/delete/deal/{dealId}", method = RequestMethod.GET)
	public String deleteDealRedirect(@PathVariable("dealId") int dealId){
		return "redirect:/workflow/delete/deal/" + dealId;
	}
	
	@RequestMapping(value = "/workflow/adddeal", method = RequestMethod.GET)
	public String addDealGet(Model model, Locale locale)	{
		
		model.addAttribute("credit", new Credit());
		model.addAttribute("creditObjectiveTypesList", constansService.getObjectiveTypes(locale));
		
		return "adddeal";
	}
	
	@RequestMapping(value = "/workflow/adddeal", method = RequestMethod.POST)
	public String addDealPost(	Model model, 
								@Valid @ModelAttribute("credit") Credit credit, 
								BindingResult result, 
								Locale locale)	{
		
		creditValidator.validate(credit, result);
		
		if (result.hasErrors()) {
			model.addAttribute("credit", credit);
			model.addAttribute("creditObjectiveTypesList", constansService.getObjectiveTypes(locale));
			return "adddeal";
		}
		
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		creditService.addCredit(credit);
		
		Deal deal = dealService.createDeal();
		deal.setCredit(credit);
		deal.setUser(user);
		dealService.addDeal(deal);
		
		String link = "/workflow/deal/" + deal.getId() + "/credit/" + credit.getId();
		
		dealService.updateDeal(deal, Deal.CREDIT_INFO_STEP, link);
		
		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}", 
							method = RequestMethod.GET)
	public String addDealPersonalDataGet(	Model model, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											Locale locale)	{
		
		model.addAttribute("customer", customerService.getNewCustomer());
		model.addAttribute("convictionTypesList", constansService.getConvictionTypes(locale));
		model.addAttribute("educationTypesList", constansService.getEducationTypes(locale));
		model.addAttribute("genderTypesList", constansService.getGenderTypes(locale));
		model.addAttribute("militaryServiceTypesList", constansService.getMilitaryServiceTypes(locale));
		
		return "adddealcustomer";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}", 
							method = RequestMethod.POST)
	public String addDealPersonalDataPost(	Model model, 
											@Valid @ModelAttribute("customer") Customer customer, BindingResult result, 
											@PathVariable int dealId, 
											@PathVariable int creditId,  
											Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		EmploymentType employmentType = employmentTypeService.getEmploymentTypeById(Employments.ID_OTHER);
		
		if ( 	deal == null || 
				credit == null)	 {
			return "404";
		}
		
		customerValidator.validate(customer, result);
		
		if (result.hasErrors())	{
			model.addAttribute("customer", customer);
			model.addAttribute("convictionTypesList", constansService.getConvictionTypes(locale));
			model.addAttribute("educationTypesList", constansService.getEducationTypes(locale));
			model.addAttribute("genderTypesList", constansService.getGenderTypes(locale));
			model.addAttribute("militaryServiceTypesList", constansService.getMilitaryServiceTypes(locale));
			
			return "adddealcustomer";
		}
		
		customer.setEmploymentType(employmentType);
		customerService.addCustomer(customer);
		deal.setCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
				"/credit/" + credit.getId() + 
				"/customer/" + customer.getId();
		
		dealService.updateDeal(deal, Deal.PERSONAL_DATA_STEP, link);
		
		return "redirect:" + link;
	}
	
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}", 
							method = RequestMethod.GET)
	public String addDealPassportDataGet(	Model model, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											Locale locale)	{
		model.addAttribute("passport", passportService.createNewPassport());
		return "adddealpassport";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}", 
							method = RequestMethod.POST)
	public String addDealPassportDataPost(	Model model, 
											@Valid @ModelAttribute Passport passport, BindingResult result, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		
		if (	deal == null || 
				credit == null || 
				customer == null)	 {
			return "404";
		}
		
		passportValidator.validate(passport, result);
		
		if (result.hasErrors())	{
			model.addAttribute("passport", passport);
			return "adddealpassport";
		}
		
		passportService.addPassport(passport);
		customer.setPassport(passport);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
				"/credit/" + credit.getId() + 
				"/customer/" + customer.getId() + 
				"/passport/" + passport.getId();
		
		dealService.updateDeal(deal, Deal.PASSPORT_DATA_STEP, link);
		
		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}", 
							method = RequestMethod.GET)
	public String addDealMarriageDataGet(	Model model, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											Locale locale)	{
		model.addAttribute("marriage", marriageService.createNewMarriage());
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("maritalStatusTypesList", constansService.getMaritalStatusTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
		
		return "adddealmarriage";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}", 
							method = RequestMethod.POST)
	public String addDealMarriageDataPost(	Model model, 
											@Valid @ModelAttribute Marriage marriage, BindingResult result, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											Locale locale)	{
		
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		
		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null)	 {
			return "404";
		}
		
		if (	(marriage.getMaritalStatusType().getId() == MaritalStatuses.MARRIED_ID) || 
				(marriage.getMaritalStatusType().getId() == MaritalStatuses.CIVIL_ID))	{
			
			marriageValidator.validate(marriage, result);
			
			if (result.hasErrors())	{
				model.addAttribute("marriage", marriage);
				model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
				model.addAttribute("maritalStatusTypesList", constansService.getMaritalStatusTypes(locale));
				model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
				model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
				
				return "adddealmarriage";
			}
		} 
		
		marriageService.addMarriage(marriage);
		customer.setMarriage(marriage);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
						"/credit/" + credit.getId() + 
						"/customer/" + customer.getId() + 
						"/passport/" + passport.getId() + 
						"/marriage/" + marriage.getId();
		
		dealService.updateDeal(deal, Deal.MARRIAGE_DATA_STEP, link);
		
		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}", 
							method = RequestMethod.GET)
	public String addDealAddressDataGet(	Model model, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											@PathVariable int marriageId, 
											Locale locale)	{
		
		model.addAttribute("address", addressService.createNewAddress());
		model.addAttribute("rRegionTypesList", constansService.getRegionTypes(locale));
		model.addAttribute("aRegionTypesList", constansService.getRegionTypes(locale));
		model.addAttribute("aYearsList", constansService.getYears());
		model.addAttribute("rYearsList", constansService.getYears());
		
		return "adddealaddress";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}", method = RequestMethod.POST)
	public String addDealAddressDataPost(	Model model,  
											@Valid @ModelAttribute Address address, BindingResult result, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											@PathVariable int marriageId, 
											Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		
		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null || 
				address == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("address", address);
			model.addAttribute("rRegionTypesList", constansService.getRegionTypes(locale));
			model.addAttribute("aRegionTypesList", constansService.getRegionTypes(locale));
			model.addAttribute("aYearsList", constansService.getYears());
			model.addAttribute("rYearsList", constansService.getYears());
			return "adddealaddress";
		}
		
		addressService.addAddress(address);
		customer.setAddress(address);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
				"/credit/" + credit.getId() + 
				"/customer/" + customer.getId() + 
				"/passport/" + passport.getId() + 
				"/marriage/" + marriage.getId() + 
				"/address/" + address.getId();
		
		dealService.updateDeal(deal, Deal.ADDRESS_DATA_STEP, link);
		
		return "redirect:" + link;

	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}", 
							method = RequestMethod.GET)
	public String addDealPhoneDataGet(	Model model, 
										@PathVariable int dealId, 
										@PathVariable int creditId, 
										@PathVariable int customerId, 
										@PathVariable int passportId, 
										@PathVariable int marriageId, 
										@PathVariable int addressId, 
										Locale locale)	{
		model.addAttribute("customerPhoneSet", customerPhoneSetService.createNewCustomerPhoneSet());
		return "adddealphone";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}", method = RequestMethod.POST)
	public String addDealPhoneDataPost(	Model model, 
										@Valid @ModelAttribute CustomerPhoneSet customerPhoneSet, BindingResult result, 
										@PathVariable int dealId, 
										@PathVariable int creditId, 
										@PathVariable int customerId, 
										@PathVariable int passportId, 
										@PathVariable int marriageId, 
										@PathVariable int addressId, 
										Locale locale)	{
		
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		
		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null || 
				address == null || 
				customerPhoneSet == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("customerPhoneSet", customerPhoneSet);
			return "adddealphone";
		}
		
		customerPhoneSetService.addCustomerPhoneSet(customerPhoneSet);
		customer.setCustomerPhoneSet(customerPhoneSet);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
				"/credit/" + credit.getId() + 
				"/customer/" + customer.getId() + 
				"/passport/" + passport.getId() + 
				"/marriage/" + marriage.getId() + 
				"/address/" + address.getId() + 
				"/phoneset/" + customerPhoneSet.getId();
		
		dealService.updateDeal(deal, Deal.PHONE_DATA_STEP, link);
		
		return "redirect:" + link;

	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}", 
							method = RequestMethod.GET)
	public String addDealContactPeopleDataGet(	Model model, 
												@PathVariable int dealId, 
												@PathVariable int creditId, 
												@PathVariable int customerId, 
												@PathVariable int passportId, 
												@PathVariable int marriageId, 
												@PathVariable int addressId, 
												@PathVariable int phonesetId, 
												Locale locale)	{
		model.addAttribute("contactPersons", contactPersonService.createNewContactPersons());
		model.addAttribute("fpContactPersonTypeList", constansService.getContactPersonTypes(locale));
		model.addAttribute("spContactPersonTypeList", constansService.getContactPersonTypes(locale));
		
		return "adddealcontactpeople";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}", 
							method = RequestMethod.POST)
	public String addDealContactPeopleDataPost(	Model model, 
												@Valid @ModelAttribute ContactPersons contactPersons, BindingResult result, 
												@PathVariable int dealId, 
												@PathVariable int creditId, 
												@PathVariable int customerId, 
												@PathVariable int passportId, 
												@PathVariable int marriageId, 
												@PathVariable int addressId, 
												@PathVariable int phonesetId, 
												Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		
		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null || 
				address == null || 
				customerPhoneSet == null || 
				contactPersons == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("contactPersons", contactPersons);
			model.addAttribute("fpContactPersonTypeList", constansService.getContactPersonTypes(locale));
			model.addAttribute("spContactPersonTypeList", constansService.getContactPersonTypes(locale));
			
			return "adddealcontactpeople";
		}
		
		contactPersonService.addContactPersons(contactPersons);
		
		customer.setContactPersons(contactPersons);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
						"/credit/" + credit.getId() + 
						"/customer/" + customer.getId() + 
						"/passport/" + passport.getId() + 
						"/marriage/" + marriage.getId() + 
						"/address/" + address.getId() + 
						"/phoneset/" + customerPhoneSet.getId() + 
						"/contactpeople/" + contactPersons.getId();
		
		dealService.updateDeal(deal, Deal.CONTACT_PEOPLE_DATA_STEP, link);

		return "redirect:" + link;
	}

	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}", 
							method = RequestMethod.GET)
	public String addDealCurrentWorkingPlaceDataGet(	Model model, 
														@PathVariable int dealId, 
														@PathVariable int creditId, 
														@PathVariable int customerId, 
														@PathVariable int passportId, 
														@PathVariable int marriageId, 
														@PathVariable int addressId, 
														@PathVariable int phonesetId, 
														@PathVariable int contactPersonsId, 
														Locale locale)	{
		model.addAttribute("workingPlace", workingPlaceService.create());
		model.addAttribute("regionTypesList", constansService.getRegionTypes(locale));
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
		model.addAttribute("positionTypesList", constansService.getPositionTypes(locale));
		model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
		model.addAttribute("yearsList", constansService.getYears());
		
		return "adddealcurrentworkingplace";
	}

	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}", method = RequestMethod.POST)
	public String addDealCurrentWorkingPlaceDataPost(	Model model, 
														@Valid @ModelAttribute WorkingPlace workingPlace, BindingResult result, 
														@PathVariable int dealId, 
														@PathVariable int creditId, 
														@PathVariable int customerId, 
														@PathVariable int passportId, 
														@PathVariable int marriageId, 
														@PathVariable int addressId, 
														@PathVariable int phonesetId, 
														@PathVariable int contactPersonsId, 
														Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		ContactPersons contactPersons = contactPersonService.getContactPersons(contactPersonsId);

		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null || 
				address == null || 
				customerPhoneSet == null || 
				contactPersons == null || 
				workingPlace == null)	 {
			return "404";
		}
		
		workingPlaceValidator.validate(workingPlace, result);
		
		if (result.hasErrors())	{
			model.addAttribute("workingPlace", workingPlace);
			model.addAttribute("regionTypesList", constansService.getRegionTypes(locale));
			model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
			model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
			model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
			model.addAttribute("positionTypesList", constansService.getPositionTypes(locale));
			model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
			model.addAttribute("yearsList", constansService.getYears());
			
			return "adddealcurrentworkingplace";
		}
		
		workingPlaceService.add(workingPlace);
		
		customer.setWorkingPlace(workingPlace);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
						"/credit/" + credit.getId() + 
						"/customer/" + customer.getId() + 
						"/passport/" + passport.getId() + 
						"/marriage/" + marriage.getId() + 
						"/address/" + address.getId() + 
						"/phoneset/" + customerPhoneSet.getId() + 
						"/contactpeople/" + contactPersons.getId() + 
						"/workingplace/" + workingPlace.getId();
		
		dealService.updateDeal(deal, Deal.WORKING_PLACE_DATA_STEP, link);

		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}", method = RequestMethod.GET)
	public String addDealAdditionalWorkingPlaceDataGet(	Model model, 
														@PathVariable int dealId, 
														@PathVariable int creditId, 
														@PathVariable int customerId, 
														@PathVariable int passportId, 
														@PathVariable int marriageId, 
														@PathVariable int addressId, 
														@PathVariable int phonesetId, 
														@PathVariable int contactPersonsId, 
														@PathVariable int workingPlaceId, 
														Locale locale)	{
		model.addAttribute("additionalWorkingPlace", additionalWorkingPlaceService.create());
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
		model.addAttribute("workingTermFromYearsList", constansService.getYears());
		model.addAttribute("companyExistingTermYearsList", constansService.getYears());
		
		return "adddealadditionalworkingplace";
	}

	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}", 
							method = RequestMethod.POST)
	public String addDealAdditionalWorkingPlaceDataPost(	Model model, 
															@Valid @ModelAttribute AdditionalWorkingPlace additionalWorkingPlace, BindingResult result, 
															@PathVariable int dealId, 
															@PathVariable int creditId, 
															@PathVariable int customerId, 
															@PathVariable int passportId, 
															@PathVariable int marriageId, 
															@PathVariable int addressId, 
															@PathVariable int phonesetId, 
															@PathVariable int contactPersonsId, 
															@PathVariable int workingPlaceId, 
															Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		ContactPersons contactPersons = contactPersonService.getContactPersons(contactPersonsId);
		WorkingPlace workingPlace = workingPlaceService.get(workingPlaceId);

		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null || 
				address == null || 
				customerPhoneSet == null || 
				contactPersons == null || 
				workingPlace == null || 
				additionalWorkingPlace == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("additionalWorkingPlace", additionalWorkingPlace);
			model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
			model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
			model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
			model.addAttribute("workingTermFromYearsList", constansService.getYears());
			model.addAttribute("companyExistingTermYearsList", constansService.getYears());
			
			return "adddealadditionalworkingplace";
		}
		
		additionalWorkingPlaceService.add(additionalWorkingPlace);
		
		customer.setAdditionalWorkingPlace(additionalWorkingPlace);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
				"/credit/" + credit.getId() + 
				"/customer/" + customer.getId() + 
				"/passport/" + passport.getId() + 
				"/marriage/" + marriage.getId() + 
				"/address/" + address.getId() + 
				"/phoneset/" + customerPhoneSet.getId() + 
				"/contactpeople/" + contactPersons.getId() + 
				"/workingplace/" + workingPlace.getId() + 
				"/additionalwp/" + additionalWorkingPlace.getId();
		
		dealService.updateDeal(deal, Deal.ADDITIONAL_WORKING_PLACE_DATA_STEP, link);

		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
			"credit/{creditId}/" +
			"customer/{customerId}/" +
			"passport/{passportId}/" +
			"marriage/{marriageId}/" +
			"address/{addressId}/" +
			"phoneset/{phonesetId}/" +
			"contactpeople/{contactPersonsId}/" +
			"workingplace/{workingPlaceId}/" +
			"additionalwp/{additionalworkingplaceId}", method = RequestMethod.GET)
	public String addDealPreviousWorkingPlaceDataGet(
			Model model, 
			@PathVariable int dealId, 
			@PathVariable int creditId, 
			@PathVariable int customerId, 
			@PathVariable int passportId, 
			@PathVariable int marriageId, 
			@PathVariable int addressId, 
			@PathVariable int phonesetId, 
			@PathVariable int contactPersonsId, 
			@PathVariable int workingPlaceId, 
			@PathVariable int additionalworkingplaceId, Locale locale)	{
		model.addAttribute("previousWorkingPlace", previousWorkingPlaceService.create());
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
		model.addAttribute("workingTermFromYearsList", constansService.getYears());
		model.addAttribute("companyExistingTermYearsList", constansService.getYears());
		
		return "adddealpreviousworkingplace";
	}

	@RequestMapping(value = "workflow/deal/{dealId}/" +
			"credit/{creditId}/" +
			"customer/{customerId}/" +
			"passport/{passportId}/" +
			"marriage/{marriageId}/" +
			"address/{addressId}/" +
			"phoneset/{phonesetId}/" +
			"contactpeople/{contactPersonsId}/" +
			"workingplace/{workingPlaceId}/" +
			"additionalwp/{additionalworkingplaceId}", method = RequestMethod.POST)
	public String addDealPreviousWorkingPlaceDataPost(	Model model, 
														@Valid @ModelAttribute PreviousWorkingPlace previousWorkingPlace, BindingResult result, 
														@PathVariable int dealId, 
														@PathVariable int creditId, 
														@PathVariable int customerId, 
														@PathVariable int passportId, 
														@PathVariable int marriageId, 
														@PathVariable int addressId, 
														@PathVariable int phonesetId, 
														@PathVariable int contactPersonsId, 
														@PathVariable int workingPlaceId, 
														@PathVariable int additionalworkingplaceId, 
														Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		ContactPersons contactPersons = contactPersonService.getContactPersons(contactPersonsId);
		WorkingPlace workingPlace = workingPlaceService.get(workingPlaceId);
		AdditionalWorkingPlace additionalWorkingPlace = additionalWorkingPlaceService.get(additionalworkingplaceId);

		if (deal == null || 
			credit == null || 
			customer == null || 
			passport == null || 
			marriage == null || 
			address == null || 
			customerPhoneSet == null || 
			contactPersons == null || 
			workingPlace == null || 
			additionalWorkingPlace == null || 
			additionalWorkingPlace == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("previousWorkingPlace", previousWorkingPlace);
			model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
			model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
			model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
			model.addAttribute("workingTermFromYearsList", constansService.getYears());
			model.addAttribute("companyExistingTermYearsList", constansService.getYears());
			
			return "adddealpreviousworkingplace";
		}
		
		previousWorkingPlaceService.add(previousWorkingPlace);
		
		customer.setPreviousWorkingPlace(previousWorkingPlace);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
						"/credit/" + credit.getId() + 
						"/customer/" + customer.getId() + 
						"/passport/" + passport.getId() + 
						"/marriage/" + marriage.getId() + 
						"/address/" + address.getId() + 
						"/phoneset/" + customerPhoneSet.getId() + 
						"/contactpeople/" + contactPersons.getId() + 
						"/workingplace/" + workingPlace.getId() + 
						"/additionalwp/" + additionalWorkingPlace.getId() + 
						"/previouswp/" + previousWorkingPlace.getId();
		
		dealService.updateDeal(deal, Deal.PREVIOUS_WORKING_PLACE_DATA_STEP, link);

		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}/" +
							"additionalwp/{additionalworkingplaceId}/" +
							"/previouswp/{previousWorkingPlaceId}", 
							method = RequestMethod.GET)
	public String addDealIncomeOutcomeDataGet( Model model, 
												@PathVariable int dealId, 
												@PathVariable int creditId, 
												@PathVariable int customerId, 
												@PathVariable int passportId, 
												@PathVariable int marriageId, 
												@PathVariable int addressId, 
												@PathVariable int phonesetId, 
												@PathVariable int contactPersonsId, 
												@PathVariable int workingPlaceId, 
												@PathVariable int additionalworkingplaceId, 
												@PathVariable int previousWorkingPlaceId, 
												Locale locale)	{
		
		model.addAttribute("incomeOutcome", incomeOutcomeService.create());
		model.addAttribute("miIncomeTypeList", constansService.getIncomeTypes(true, false, false, locale));
		model.addAttribute("aiIncomeTypeList", constansService.getIncomeTypes(false, true, false, locale));
		model.addAttribute("siIncomeTypeList", constansService.getIncomeTypes(false, false, true, locale));
		
		return "adddealincomeoutcome";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}/" +
							"additionalwp/{additionalworkingplaceId}"+
							"/previouswp/{previousWorkingPlaceId}", 
							method = RequestMethod.POST)
	public String addDealIncomeOutcomeDataPost( Model model, 
												@Valid @ModelAttribute IncomeOutcome incomeOutcome, BindingResult result, 
												@PathVariable int dealId, 
												@PathVariable int creditId, 
												@PathVariable int customerId, 
												@PathVariable int passportId, 
												@PathVariable int marriageId, 
												@PathVariable int addressId, 
												@PathVariable int phonesetId, 
												@PathVariable int contactPersonsId, 
												@PathVariable int workingPlaceId, 
												@PathVariable int additionalworkingplaceId,
												@PathVariable int previousWorkingPlaceId, 
												Locale locale)	{
		
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		ContactPersons contactPersons = contactPersonService.getContactPersons(contactPersonsId);
		WorkingPlace workingPlace = workingPlaceService.get(workingPlaceId);
		AdditionalWorkingPlace additionalWorkingPlace = additionalWorkingPlaceService.get(additionalworkingplaceId);
		PreviousWorkingPlace previousWorkingPlace = previousWorkingPlaceService.get(previousWorkingPlaceId);

		if (deal == null || 
			credit == null || 
			customer == null || 
			passport == null || 
			marriage == null || 
			address == null || 
			customerPhoneSet == null || 
			contactPersons == null || 
			workingPlace == null || 
			additionalWorkingPlace == null || 
			previousWorkingPlace == null ||
			incomeOutcome == null)	 {
			return "404";
		}
		
		incomeOutcomeValidator.validate(incomeOutcome, result);
		
		if (result.hasErrors())	{
			model.addAttribute("incomeOutcome", incomeOutcome);
			model.addAttribute("miIncomeTypeList", constansService.getIncomeTypes(true, false, false, locale));
			model.addAttribute("aiIncomeTypeList", constansService.getIncomeTypes(false, true, false, locale));
			model.addAttribute("siIncomeTypeList", constansService.getIncomeTypes(false, false, true, locale));
			
			return "adddealincomeoutcome";
		}
		
		incomeOutcomeService.add(incomeOutcome);
		
		customer.setIncomeOutcome(incomeOutcome);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
						"/credit/" + credit.getId() + 
						"/customer/" + customer.getId() + 
						"/passport/" + passport.getId() + 
						"/marriage/" + marriage.getId() + 
						"/address/" + address.getId() + 
						"/phoneset/" + customerPhoneSet.getId() + 
						"/contactpeople/" + contactPersons.getId() + 
						"/workingplace/" + workingPlace.getId() + 
						"/additionalwp/" + additionalWorkingPlace.getId() + 
						"/previouswp/" + previousWorkingPlace.getId() + 
						"/incomeoutcome/" + incomeOutcome.getId();
		
		dealService.updateDeal(deal, Deal.INCOME_OUTCOME_DATA_STEP, link);

		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}/" +
							"additionalwp/{additionalworkingplaceId}/" +
							"/previouswp/{previousWorkingPlaceId}" + 
							"/incomeoutcome/{incomeOutcomeId}" 
			, method = RequestMethod.GET)
	public String addDealPropertyDataGet( Model model, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											@PathVariable int marriageId, 
											@PathVariable int addressId, 
											@PathVariable int phonesetId, 
											@PathVariable int contactPersonsId, 
											@PathVariable int workingPlaceId, 
											@PathVariable int additionalworkingplaceId, 
											@PathVariable int previousWorkingPlaceId, 
											@PathVariable int incomeOutcomeId, 
											Locale locale)	{
		
		model.addAttribute("property", propertyService.create());
		model.addAttribute("carYearsList", constansService.getYears());
		model.addAttribute("epPurchaseYearList", constansService.getYears());
		model.addAttribute("epPropertyTypesList", constansService.getPropertyTypes(true, locale));
		model.addAttribute("gaPropertyTypesList", constansService.getPropertyTypes(true, locale));
		model.addAttribute("propertyHistoryTypesList", constansService.getPropertyHistoryTypes(locale));
		
		return "adddealproperty";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}/" +
							"additionalwp/{additionalworkingplaceId}/"+
							"previouswp/{previousWorkingPlaceId}/"+ 
							"incomeoutcome/{incomeOutcomeId}", 
							method = RequestMethod.POST)
	public String addDealPropertyDataPost(	Model model, 
											@Valid @ModelAttribute Property property, BindingResult result, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											@PathVariable int marriageId, 
											@PathVariable int addressId, 
											@PathVariable int phonesetId, 
											@PathVariable int contactPersonsId, 
											@PathVariable int workingPlaceId, 
											@PathVariable int additionalworkingplaceId,
											@PathVariable int previousWorkingPlaceId, 
											@PathVariable int incomeOutcomeId,
											Locale locale)	{
		
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		ContactPersons contactPersons = contactPersonService.getContactPersons(contactPersonsId);
		WorkingPlace workingPlace = workingPlaceService.get(workingPlaceId);
		AdditionalWorkingPlace additionalWorkingPlace = additionalWorkingPlaceService.get(additionalworkingplaceId);
		PreviousWorkingPlace previousWorkingPlace = previousWorkingPlaceService.get(previousWorkingPlaceId);
		IncomeOutcome incomeOutcome = incomeOutcomeService.get(incomeOutcomeId);

		if (deal == null || 
			credit == null || 
			customer == null || 
			passport == null || 
			marriage == null || 
			address == null || 
			customerPhoneSet == null || 
			contactPersons == null || 
			workingPlace == null || 
			additionalWorkingPlace == null || 
			previousWorkingPlace == null ||
			incomeOutcome == null ||
			property == null)
			{
			return "404";
		}
		
		propertyValidator.validate(property, result);
		
		if (result.hasErrors())	{
			model.addAttribute("property", property);
			model.addAttribute("carYearsList", constansService.getYears());
			model.addAttribute("epPurchaseYearList", constansService.getYears());
			model.addAttribute("epPropertyTypesList", constansService.getPropertyTypes(true, locale));
			model.addAttribute("gaPropertyTypesList", constansService.getPropertyTypes(true, locale));
			model.addAttribute("propertyHistoryTypesList", constansService.getPropertyHistoryTypes(locale));
			
			return "adddealproperty";
		}
		
		propertyService.add(property);
		
		customer.setProperty(property);
		customerService.updateCustomer(customer);
		
		String link = "/workflow/deal/" + deal.getId() + 
						"/credit/" + credit.getId() + 
						"/customer/" + customer.getId() + 
						"/passport/" + passport.getId() + 
						"/marriage/" + marriage.getId() + 
						"/address/" + address.getId() + 
						"/phoneset/" + customerPhoneSet.getId() + 
						"/contactpeople/" + contactPersons.getId() + 
						"/workingplace/" + workingPlace.getId() + 
						"/additionalwp/" + additionalWorkingPlace.getId() + 
						"/previouswp/" + previousWorkingPlace.getId() + 
						"/incomeoutcome/" + incomeOutcome.getId() + 
						"/property/" + property.getId();
		
		dealService.updateDeal(deal, Deal.PROPERTY_DATA_STEP, link);

		return "redirect:" + link;
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}/" +
							"additionalwp/{additionalworkingplaceId}/" +
							"previouswp/{previousWorkingPlaceId}/" + 
							"incomeoutcome/{incomeOutcomeId}/"+
							"/property/{propertyId}", 
							method = RequestMethod.GET)
	public String addDealCreditCardDataGet( Model model, 
											@PathVariable int dealId, 
											@PathVariable int creditId, 
											@PathVariable int customerId, 
											@PathVariable int passportId, 
											@PathVariable int marriageId, 
											@PathVariable int addressId, 
											@PathVariable int phonesetId, 
											@PathVariable int contactPersonsId, 
											@PathVariable int workingPlaceId, 
											@PathVariable int additionalworkingplaceId, 
											@PathVariable int previousWorkingPlaceId, 
											@PathVariable int incomeOutcomeId, 
											@PathVariable int propertyId, 
											Locale locale)	{
		
		model.addAttribute("creditCard", creditCardService.create());
		model.addAttribute("fcCreditTypeList", constansService.getCreditFormTypes(locale));
		model.addAttribute("scCreditTypeList", constansService.getCreditFormTypes(locale));
		model.addAttribute("tcCreditTypeList", constansService.getCreditFormTypes(locale));
		
		return "adddealcreditcards";
	}
	
	@RequestMapping(value = "workflow/deal/{dealId}/" +
							"credit/{creditId}/" +
							"customer/{customerId}/" +
							"passport/{passportId}/" +
							"marriage/{marriageId}/" +
							"address/{addressId}/" +
							"phoneset/{phonesetId}/" +
							"contactpeople/{contactPersonsId}/" +
							"workingplace/{workingPlaceId}/" +
							"additionalwp/{additionalworkingplaceId}/" +
							"previouswp/{previousWorkingPlaceId}/" + 
							"incomeoutcome/{incomeOutcomeId}/"+
							"/property/{propertyId}", 
							method = RequestMethod.POST)
	public String addDealCreditCardDataPost(	Model model, 
												@Valid @ModelAttribute CreditCard creditCard, BindingResult result,
												@PathVariable int dealId, 
												@PathVariable int creditId, 
												@PathVariable int customerId, 
												@PathVariable int passportId, 
												@PathVariable int marriageId, 
												@PathVariable int addressId, 
												@PathVariable int phonesetId, 
												@PathVariable int contactPersonsId, 
												@PathVariable int workingPlaceId, 
												@PathVariable int additionalworkingplaceId, 
												@PathVariable int previousWorkingPlaceId, 
												@PathVariable int incomeOutcomeId, 
												@PathVariable int propertyId, 
												Locale locale)	{
		Deal deal = dealService.getDeal(dealId);
		Credit credit = creditService.getCredit(creditId);
		Customer customer = customerService.getCustomerById(customerId);
		Passport passport = passportService.getPassport(passportId);
		Marriage marriage = marriageService.getMarriage(marriageId);
		Address address = addressService.getAddress(addressId);
		CustomerPhoneSet customerPhoneSet = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		ContactPersons contactPersons = contactPersonService.getContactPersons(contactPersonsId);
		WorkingPlace workingPlace = workingPlaceService.get(workingPlaceId);
		AdditionalWorkingPlace additionalWorkingPlace = additionalWorkingPlaceService.get(additionalworkingplaceId);
		PreviousWorkingPlace previousWorkingPlace = previousWorkingPlaceService.get(previousWorkingPlaceId);
		IncomeOutcome incomeOutcome = incomeOutcomeService.get(incomeOutcomeId);
		Property property = propertyService.get(propertyId);
		
		if (	deal == null || 
				credit == null || 
				customer == null || 
				passport == null || 
				marriage == null || 
				address == null || 
				customerPhoneSet == null || 
				contactPersons == null || 
				workingPlace == null || 
				additionalWorkingPlace == null || 
				previousWorkingPlace == null ||
				incomeOutcome == null ||
				property == null ||
				creditCard == null)
				{
				return "404";
			}
		
		cardsValidator.validate(creditCard, result);
		
		if (result.hasErrors())	{
			model.addAttribute("creditCard", creditCard);
			model.addAttribute("fcCreditTypeList", constansService.getCreditFormTypes(locale));
			model.addAttribute("scCreditTypeList", constansService.getCreditFormTypes(locale));
			model.addAttribute("tcCreditTypeList", constansService.getCreditFormTypes(locale));
			
			return "adddealcreditcards";
		}
		
		creditCardService.add(creditCard);
		
		customer.setCreditCard(creditCard);
		customerService.updateCustomer(customer);
		
		dealService.updateDeal(deal, Deal.FINISHED, null);

		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/view/deal/{dealId}", method = RequestMethod.GET)
	public String viewDealGet(Model model, 
			@PathVariable("dealId") int dealId, 
			 HttpServletRequest request, Locale locale)	{
		
		String basePath = request.getSession().getServletContext().getRealPath("/");
		
		Deal deal = dealService.getDeal(dealId, locale);
		List<Attachment> attachments = attachmentService.getFiles(dealId, basePath);
		
		if (deal == null)	 {
			return "404";
		}
		
		if (deal.getStep() < Deal.FINISHED)	{
			String msg = messageSource.getMessage("deal.is.not.finished", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		}
		
		model.addAttribute("deal", deal);
		model.addAttribute("attachmentsList", attachments);
		
		return "viewdeal";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}", method = RequestMethod.GET)
	public String editDealGet(Model model, 
			@PathVariable("dealId") int dealId, 
			 HttpServletRequest request, Locale locale)	{
		
		String basePath = request.getSession().getServletContext().getRealPath("/");
		
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		
		Deal deal = dealService.getDeal(dealId, locale);
		List<Attachment> filesList = attachmentService.getFiles(dealId, basePath);
		List<Attachment> docsList = attachmentService.getDocs(dealId, basePath);
		
		if (deal == null)	 {
			return "404";
		}
		
		if (deal.getStep() < Deal.FINISHED)	{
			String msg = messageSource.getMessage("deal.is.not.finished", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		}
		
		List<Comment> commentsList = commentsService.getDealComments(deal);
		
		List<Action> actionsList = workflowService.getAvailableActions(deal, user, locale);
		
		boolean coordinatorOnly = false;
		
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		
		model.addAttribute("coordinatorOnly", coordinatorOnly);
		model.addAttribute("deal", deal);
		model.addAttribute("filesList", filesList);
		model.addAttribute("docsList", docsList);
		model.addAttribute("commentsList", commentsList);
		model.addAttribute("actionsList", actionsList);

		
		return "editdeal";
	}
	
	@RequestMapping(value = "/workflow/action/review/deal/{dealId}", method = RequestMethod.GET)
	public String reviewDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.review", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "review";
		
	}
	
	@RequestMapping(value = "/workflow/action/review/deal/{dealId}", method = RequestMethod.POST)
	public String reviewDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.review(deal);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/action/reject/deal/{dealId}", method = RequestMethod.GET)
	public String rejectDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		boolean coordinatorOnly = false;
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		model.addAttribute("coordinatorOnly", coordinatorOnly);
		
		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.reject", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "reject";
		
	}
	
	@RequestMapping(value = "/workflow/action/reject/deal/{dealId}", method = RequestMethod.POST)
	public String rejectDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.reject(deal);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/action/approve/deal/{dealId}", method = RequestMethod.GET)
	public String approveDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		boolean coordinatorOnly = false;
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		model.addAttribute("coordinatorOnly", coordinatorOnly);
		
		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.approve", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "approve";
		
	}
	
	@RequestMapping(value = "/workflow/action/approve/deal/{dealId}", method = RequestMethod.POST)
	public String approveDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.approve(deal);
		
		return "redirect:/workflow/deal/" + deal.getId() + "/docs/upload";
	}
	
	@RequestMapping(value = "/workflow/action/sign/deal/{dealId}", method = RequestMethod.GET)
	public String signDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.sign", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "sign";
		
	}
	
	@RequestMapping(value = "/workflow/action/sign/deal/{dealId}", method = RequestMethod.POST)
	public String signDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.sign(deal);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/action/unsign/deal/{dealId}", method = RequestMethod.GET)
	public String unsignDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.unsign", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "unsign";
		
	}
	
	@RequestMapping(value = "/workflow/action/unsign/deal/{dealId}", method = RequestMethod.POST)
	public String unsignDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.unsign(deal);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/action/close/deal/{dealId}", method = RequestMethod.GET)
	public String closeDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.close", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "close";
		
	}
	
	@RequestMapping(value = "/workflow/action/close/deal/{dealId}", method = RequestMethod.POST)
	public String closeDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.close(deal);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/action/rework/deal/{dealId}", method = RequestMethod.GET)
	public String reworkDealGet(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		model.addAttribute("deal", deal);
		String msg = messageSource.getMessage("label.header.h3.deal.rework", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		
		return "rework";
		
	}
	
	@RequestMapping(value = "/workflow/action/rework/deal/{dealId}", method = RequestMethod.POST)
	public String reworkDealPost(	Model model,
									@PathVariable("dealId") int dealId,
									HttpServletRequest request,
									Locale locale)	{
		Deal deal = dealService.getDeal(dealId, locale);
		
		if (deal == null)	 {
			return "404";
		}

		workflowService.rework(deal);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		 dateFormat.setLenient(false);
		 webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/credit/{creditId}", method = RequestMethod.GET)
	public String editDealCreditGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int creditId)	{
		
		Credit credit = creditService.getCredit(creditId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				credit == null)
			{
			return "404";
		}
		
		model.addAttribute("credit", credit);
		model.addAttribute("deal", deal);
		model.addAttribute("creditObjectiveTypesList", constansService.getObjectiveTypes(locale));
		
		return "editdeal";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/credit/{creditId}", method = RequestMethod.POST)
	public String editDealCreditPost(	Model model, 
								@Valid @ModelAttribute("credit") Credit fCredit, 
								BindingResult result, 
								 @PathVariable int dealId, @PathVariable int creditId,
								Locale locale)	{
		
		Credit pCredit = creditService.getCredit(creditId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				fCredit == null)
			{
			return "404";
		}
		
		creditValidator.validate(fCredit, result);
		
		if (result.hasErrors()) {
			model.addAttribute("credit", fCredit);
			model.addAttribute("creditObjectiveTypesList", constansService.getObjectiveTypes(locale));
			model.addAttribute("deal", deal);
			return "editdeal";
		}
		
		fCredit.setId(pCredit.getId());
		
		creditService.updateCredit(fCredit);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/customer/{customerId}", method = RequestMethod.GET)
	public String editDealCustomerGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int customerId)	{
		
		Customer customer  = customerService.getCustomerById(customerId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				customer == null)
			{
			return "404";
		}
		
		model.addAttribute("customer", customer);
		model.addAttribute("convictionTypesList", constansService.getConvictionTypes(locale));
		model.addAttribute("educationTypesList", constansService.getEducationTypes(locale));
		model.addAttribute("genderTypesList", constansService.getGenderTypes(locale));
		model.addAttribute("militaryServiceTypesList", constansService.getMilitaryServiceTypes(locale));
		model.addAttribute("deal", deal);
		
		return "editdealcustomer";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/customer/{customerId}", method = RequestMethod.POST)
	public String editDealCustomerPost(	Model model, 
								@Valid @ModelAttribute("customer") Customer fCustomer, 
								BindingResult result, 
								 @PathVariable int dealId, @PathVariable int customerId,
								Locale locale)	{
		
		Customer pCustomer = customerService.getCustomerById(customerId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				fCustomer == null)
			{
			return "404";
		}
		
		customerValidator.validate(fCustomer, result);
		
		if (result.hasErrors()) {
			model.addAttribute("customer", fCustomer);
			model.addAttribute("convictionTypesList", constansService.getConvictionTypes(locale));
			model.addAttribute("educationTypesList", constansService.getEducationTypes(locale));
			model.addAttribute("genderTypesList", constansService.getGenderTypes(locale));
			model.addAttribute("militaryServiceTypesList", constansService.getMilitaryServiceTypes(locale));
			model.addAttribute("deal", deal);
			return "editdealcustomer";
		}
		
		fCustomer.setId(pCustomer.getId());
		
		customerService.copy(pCustomer, fCustomer);
		customerService.updateCustomer(pCustomer);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/passport/{passportId}", method = RequestMethod.GET)
	public String editDealPassportGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int passportId)	{
		Passport passport  = passportService.getPassport(passportId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				passport == null)
			{
			return "404";
		}
		
		model.addAttribute("passport", passport);
		model.addAttribute("deal", deal);
		
		return "editdealpassport";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/passport/{passportId}", method = RequestMethod.POST)
	public String editDealPassportPost(Model model, @Valid @ModelAttribute("passport") Passport fPassport, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int passportId)	{
		Deal deal = dealService.getDeal(dealId);
		Passport pPassport  = passportService.getPassport(passportId);
		
		if (	deal == null || pPassport == null)	{
			return "404";
		}
		
		passportValidator.validate(fPassport, result);
		
		if (result.hasErrors())	{
			model.addAttribute("passport", fPassport);
			model.addAttribute("deal", deal);
			return "adddealpassport";
		}
		
		fPassport.setId(pPassport.getId());
		
		passportService.updatePassport(fPassport);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}


	@RequestMapping(value = "/workflow/edit/deal/{dealId}/marriage/{marriageId}", method = RequestMethod.GET)
	public String editDealMarriageGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int marriageId)	{
		Marriage marriage  = marriageService.getMarriage(marriageId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				marriage == null)
			{
			return "404";
		}
		
		model.addAttribute("marriage", marriage);
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("maritalStatusTypesList", constansService.getMaritalStatusTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
		model.addAttribute("deal", deal);
		
		return "editdealmarriage";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/marriage/{marriageId}", method = RequestMethod.POST)
	public String editDealMarriagePost(Model model, @Valid @ModelAttribute("marriage") Marriage fMarriage, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int marriageId)	{
		Deal deal = dealService.getDeal(dealId);
		Marriage pMarriage  = marriageService.getMarriage(marriageId);
		
		if (	deal == null || pMarriage == null)	{
			return "404";
		}
		
		if (	(fMarriage.getMaritalStatusType().getId() == MaritalStatuses.MARRIED_ID) || 
				(fMarriage.getMaritalStatusType().getId() == MaritalStatuses.CIVIL_ID))	{
			
			marriageValidator.validate(fMarriage, result);
			
			if (result.hasErrors())	{
				model.addAttribute("marriage", fMarriage);
				model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
				model.addAttribute("maritalStatusTypesList", constansService.getMaritalStatusTypes(locale));
				model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
				model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
				model.addAttribute("deal", deal);
				
				return "adddealmarriage";
			}
		}
		
		fMarriage.setId(pMarriage.getId());
		
		marriageService.updateMarriage(fMarriage);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/address/{addressId}", method = RequestMethod.GET)
	public String editDealAddressGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int addressId)	{
		Address address  = addressService.getAddress(addressId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				address == null)
			{
			return "404";
		}
		
		model.addAttribute("address", address);
		model.addAttribute("rRegionTypesList", constansService.getRegionTypes(locale));
		model.addAttribute("aRegionTypesList", constansService.getRegionTypes(locale));
		model.addAttribute("aYearsList", constansService.getYears());
		model.addAttribute("rYearsList", constansService.getYears());
		model.addAttribute("deal", deal);
		
		return "editdealaddress";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/address/{addressId}", method = RequestMethod.POST)
	public String editDealAddressPost(Model model, @Valid @ModelAttribute("address") Address fAddress, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int addressId)	{
		Deal deal = dealService.getDeal(dealId);
		Address pAddress  = addressService.getAddress(addressId);
		
		if (	deal == null || pAddress == null)	{
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("address", fAddress);
			model.addAttribute("rRegionTypesList", constansService.getRegionTypes(locale));
			model.addAttribute("aRegionTypesList", constansService.getRegionTypes(locale));
			model.addAttribute("aYearsList", constansService.getYears());
			model.addAttribute("rYearsList", constansService.getYears());
			model.addAttribute("deal", deal);
			return "adddealaddress";
		}
		
		fAddress.setId(pAddress.getId());
		
		addressService.updateAddress(fAddress);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/phoneset/{phonesetId}", method = RequestMethod.GET)
	public String editDealPhoneSetGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int phonesetId)	{
		CustomerPhoneSet customerPhoneSet  = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				customerPhoneSet == null)
			{
			return "404";
		}
		
		model.addAttribute("customerPhoneSet", customerPhoneSet);
		model.addAttribute("deal", deal);
		
		return "editdealphone";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/phoneset/{phonesetId}", method = RequestMethod.POST)
	public String editDealPhoneSetPost(Model model, @Valid @ModelAttribute("customerPhoneSet") CustomerPhoneSet fCustomerPhoneSet, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int phonesetId)	{
		Deal deal = dealService.getDeal(dealId);
		CustomerPhoneSet pCustomerPhoneSet  = customerPhoneSetService.getCustomerPhoneSet(phonesetId);
		
		if (	deal == null || pCustomerPhoneSet == null)	{
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("customerPhoneSet", pCustomerPhoneSet);
			model.addAttribute("deal", deal);
			return "adddealphone";
		}
		
		fCustomerPhoneSet.setId(pCustomerPhoneSet.getId());
		
		customerPhoneSetService.updateCustomerPhoneSet(fCustomerPhoneSet);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/contactpeople/{contactPeopleId}", method = RequestMethod.GET)
	public String editDealContactPeopleGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int contactPeopleId)	{
		ContactPersons contactPersons  = contactPersonService.getContactPersons(contactPeopleId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				contactPersons == null)
			{
			return "404";
		}
		
		model.addAttribute("contactPersons", contactPersons);
		model.addAttribute("fpContactPersonTypeList", constansService.getContactPersonTypes(locale));
		model.addAttribute("spContactPersonTypeList", constansService.getContactPersonTypes(locale));
		model.addAttribute("deal", deal);
		
		return "editdealcontactpeople";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/contactpeople/{contactPeopleId}", method = RequestMethod.POST)
	public String editDealContactPeoplePost(Model model, @Valid @ModelAttribute("contactPersons") ContactPersons fContactPersons, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int contactPeopleId)	{
		Deal deal = dealService.getDeal(dealId);
		ContactPersons pContactPersons  = contactPersonService.getContactPersons(contactPeopleId);
		
		if (	deal == null || pContactPersons == null)	{
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("contactPersons", fContactPersons);
			model.addAttribute("fpContactPersonTypeList", constansService.getContactPersonTypes(locale));
			model.addAttribute("spContactPersonTypeList", constansService.getContactPersonTypes(locale));
			model.addAttribute("deal", deal);
			return "adddealcontactpeople";
		}
		
		fContactPersons.setId(pContactPersons.getId());
		
		contactPersonService.updateContactPersons(fContactPersons);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/workingplace/{workingPlaceId}", method = RequestMethod.GET)
	public String editDealWorkingPlaceGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int workingPlaceId)	{
		WorkingPlace workingPlace  = workingPlaceService.get(workingPlaceId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				workingPlace == null)
			{
			return "404";
		}
		
		model.addAttribute("workingPlace", workingPlace);
		model.addAttribute("regionTypesList", constansService.getRegionTypes(locale));
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
		model.addAttribute("positionTypesList", constansService.getPositionTypes(locale));
		model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
		model.addAttribute("yearsList", constansService.getYears());
		model.addAttribute("deal", deal);
		
		return "editdealcurrentworkingplace";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/workingplace/{workingPlaceId}", method = RequestMethod.POST)
	public String editDealWorkingPlacePost(Model model, @Valid @ModelAttribute("workingPlace") WorkingPlace fWorkingPlace, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int workingPlaceId)	{
		Deal deal = dealService.getDeal(dealId);
		WorkingPlace pWorkingPlace  = workingPlaceService.get(workingPlaceId);
		
		if (	deal == null || pWorkingPlace == null)	{
			return "404";
		}
		
		workingPlaceValidator.validate(fWorkingPlace, result);
		
		if (result.hasErrors())	{
			model.addAttribute("workingPlace", fWorkingPlace);
			model.addAttribute("regionTypesList", constansService.getRegionTypes(locale));
			model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
			model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
			model.addAttribute("jobTypesList", constansService.getJobTypes(locale));
			model.addAttribute("positionTypesList", constansService.getPositionTypes(locale));
			model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
			model.addAttribute("yearsList", constansService.getYears());
			model.addAttribute("deal", deal);
			return "adddealcurrentworkingplace";
		}
		
		fWorkingPlace.setId(pWorkingPlace.getId());
		
		workingPlaceService.update(fWorkingPlace);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/additionalwp/{additionalWorkingPlaceId}", method = RequestMethod.GET)
	public String editDealAdditionalWPGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int additionalWorkingPlaceId)	{
		AdditionalWorkingPlace additionalWorkingPlace  = additionalWorkingPlaceService.get(additionalWorkingPlaceId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				additionalWorkingPlace == null)
			{
			return "404";
		}
		
		model.addAttribute("additionalWorkingPlace", additionalWorkingPlace);
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
		model.addAttribute("workingTermFromYearsList", constansService.getYears());
		model.addAttribute("companyExistingTermYearsList", constansService.getYears());
		model.addAttribute("deal", deal);
		
		return "editdealadditionalworkingplace";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/additionalwp/{additionalWorkingPlaceId}", method = RequestMethod.POST)
	public String editDealAdditionalWPPost(Model model, @Valid @ModelAttribute("additionalWorkingPlace") AdditionalWorkingPlace fAdditionalWorkingPlace, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int additionalWorkingPlaceId)	{
		Deal deal = dealService.getDeal(dealId);
		AdditionalWorkingPlace pAdditionalWorkingPlace  = additionalWorkingPlaceService.get(additionalWorkingPlaceId);
		
		if (	deal == null || pAdditionalWorkingPlace == null)	{
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("additionalWorkingPlace", fAdditionalWorkingPlace);
			model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
			model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
			model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
			model.addAttribute("workingTermFromYearsList", constansService.getYears());
			model.addAttribute("companyExistingTermYearsList", constansService.getYears());
			
			return "adddealadditionalworkingplace";
		}
		
		fAdditionalWorkingPlace.setId(pAdditionalWorkingPlace.getId());
		
		additionalWorkingPlaceService.update(fAdditionalWorkingPlace);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/previouswp/{previousWorkingPlaceId}", method = RequestMethod.GET)
	public String editDealPreviousWPGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int previousWorkingPlaceId)	{
		PreviousWorkingPlace previousWorkingPlace = previousWorkingPlaceService.get(previousWorkingPlaceId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				previousWorkingPlace == null)
			{
			return "404";
		}
		
		model.addAttribute("previousWorkingPlace", previousWorkingPlace);
		model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
		model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
		model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
		model.addAttribute("workingTermFromYearsList", constansService.getYears());
		model.addAttribute("companyExistingTermYearsList", constansService.getYears());
		model.addAttribute("deal", deal);
		
		return "editdealpreviousworkingplace";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/previouswp/{previousWorkingPlaceId}", method = RequestMethod.POST)
	public String editDealPreviousWPPost(Model model, @Valid @ModelAttribute("previousWorkingPlace") PreviousWorkingPlace fPreviousWorkingPlace, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int previousWorkingPlaceId)	{
		Deal deal = dealService.getDeal(dealId);
		PreviousWorkingPlace pPreviousWorkingPlace = previousWorkingPlaceService.get(previousWorkingPlaceId);
		
		if (	deal == null || pPreviousWorkingPlace == null)	{
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("previousWorkingPlace", fPreviousWorkingPlace);
			model.addAttribute("businessLineTypesList", constansService.getBusinessLineTypes(locale));
			model.addAttribute("organizationTypesList", constansService.getOrganizationTypes(locale));
			model.addAttribute("companySizeTypesList", constansService.getCompanySizeTypes(locale));
			model.addAttribute("workingTermFromYearsList", constansService.getYears());
			model.addAttribute("companyExistingTermYearsList", constansService.getYears());
			model.addAttribute("deal", deal);
			return "adddealpreviousworkingplace";
		}
		
		fPreviousWorkingPlace.setId(pPreviousWorkingPlace.getId());
		
		previousWorkingPlaceService.update(fPreviousWorkingPlace);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/incomeoutcome/{incomeOutcomeId}", method = RequestMethod.GET)
	public String editDealIncomeOutcomeGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int incomeOutcomeId)	{
		IncomeOutcome incomeOutcome = incomeOutcomeService.get(incomeOutcomeId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				incomeOutcome == null)
			{
			return "404";
		}
		
		model.addAttribute("incomeOutcome", incomeOutcome);
		model.addAttribute("miIncomeTypeList", constansService.getIncomeTypes(true, false, false, locale));
		model.addAttribute("aiIncomeTypeList", constansService.getIncomeTypes(false, true, false, locale));
		model.addAttribute("siIncomeTypeList", constansService.getIncomeTypes(false, false, true, locale));
		model.addAttribute("deal", deal);
		
		return "editdealincomeoutcome";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/incomeoutcome/{incomeOutcomeId}", method = RequestMethod.POST)
	public String editDealIncomeOutcomePost(Model model, @Valid @ModelAttribute("incomeOutcome") IncomeOutcome fIncomeOutcome, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int incomeOutcomeId)	{
		Deal deal = dealService.getDeal(dealId);
		IncomeOutcome pIncomeOutcome = incomeOutcomeService.get(incomeOutcomeId);
		
		if (	deal == null || pIncomeOutcome == null)	{
			return "404";
		}
		
		incomeOutcomeValidator.validate(fIncomeOutcome, result);
		
		if (result.hasErrors())	{
			model.addAttribute("incomeOutcome", fIncomeOutcome);
			model.addAttribute("miIncomeTypeList", constansService.getIncomeTypes(true, false, false, locale));
			model.addAttribute("aiIncomeTypeList", constansService.getIncomeTypes(false, true, false, locale));
			model.addAttribute("siIncomeTypeList", constansService.getIncomeTypes(false, false, true, locale));
			model.addAttribute("deal", deal);
			return "adddealincomeoutcome";
		}
		
		fIncomeOutcome.setId(pIncomeOutcome.getId());
		
		incomeOutcomeService.update(fIncomeOutcome);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/property/{propertyId}", method = RequestMethod.GET)
	public String editDealPropertyGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int propertyId)	{
		Property property = propertyService.get(propertyId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				property == null)
			{
			return "404";
		}
		
		model.addAttribute("property", property);
		model.addAttribute("carYearsList", constansService.getYears());
		model.addAttribute("epPurchaseYearList", constansService.getYears());
		model.addAttribute("epPropertyTypesList", constansService.getPropertyTypes(true, locale));
		model.addAttribute("gaPropertyTypesList", constansService.getPropertyTypes(true, locale));
		model.addAttribute("propertyHistoryTypesList", constansService.getPropertyHistoryTypes(locale));
		model.addAttribute("deal", deal);
		
		return "editdealproperty";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/property/{propertyId}", method = RequestMethod.POST)
	public String editDealPropertyPost(Model model, @Valid @ModelAttribute("property") Property fProperty, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int propertyId)	{
		Deal deal = dealService.getDeal(dealId);
		Property pProperty = propertyService.get(propertyId);
		
		if (	deal == null || pProperty == null)	{
			return "404";
		}
		
		propertyValidator.validate(fProperty, result);
		
		if (result.hasErrors())	{
			model.addAttribute("property", fProperty);
			model.addAttribute("carYearsList", constansService.getYears());
			model.addAttribute("epPurchaseYearList", constansService.getYears());
			model.addAttribute("epPropertyTypesList", constansService.getPropertyTypes(true, locale));
			model.addAttribute("gaPropertyTypesList", constansService.getPropertyTypes(true, locale));
			model.addAttribute("propertyHistoryTypesList", constansService.getPropertyHistoryTypes(locale));
			model.addAttribute("deal", deal);
			return "adddealproperty";
		}
		
		fProperty.setId(pProperty.getId());
		
		propertyService.update(fProperty);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/creditcard/{creditCardId}", method = RequestMethod.GET)
	public String editDealCreditCardGet(Model model, Locale locale, @PathVariable int dealId, @PathVariable int creditCardId)	{
		CreditCard creditCard  = creditCardService.get(creditCardId);
		Deal deal = dealService.getDeal(dealId);
		
		if (	deal == null || 
				creditCard == null)
			{
			return "404";
		}
		
		model.addAttribute("creditCard", creditCard);
		model.addAttribute("fcCreditTypeList", constansService.getCreditFormTypes(locale));
		model.addAttribute("scCreditTypeList", constansService.getCreditFormTypes(locale));
		model.addAttribute("tcCreditTypeList", constansService.getCreditFormTypes(locale));
		model.addAttribute("deal", deal);
		
		return "editdealcreditcards";
	}
	
	@RequestMapping(value = "/workflow/edit/deal/{dealId}/creditcard/{creditCardId}", method = RequestMethod.POST)
	public String editDealCreditCardPost(Model model, @Valid @ModelAttribute("creditCard") CreditCard fCreditCard, BindingResult result, Locale locale, @PathVariable int dealId, @PathVariable int creditCardId)	{
		Deal deal = dealService.getDeal(dealId);
		CreditCard pCreditCard  = creditCardService.get(creditCardId);
		
		if (	deal == null || pCreditCard == null)	{
			return "404";
		}
		
		cardsValidator.validate(fCreditCard, result);
		
		if (result.hasErrors())	{
			model.addAttribute("creditCard", fCreditCard);
			model.addAttribute("fcCreditTypeList", constansService.getCreditFormTypes(locale));
			model.addAttribute("scCreditTypeList", constansService.getCreditFormTypes(locale));
			model.addAttribute("tcCreditTypeList", constansService.getCreditFormTypes(locale));
			model.addAttribute("deal", deal);
			return "adddealcreditcards";
		}
		
		fCreditCard.setId(pCreditCard.getId());
		
		creditCardService.update(fCreditCard);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/workflow/delete/deal/{dealId}", method = RequestMethod.GET)
	public String deleteDealGet(Model model, 
			@PathVariable("dealId") int dealId, HttpServletRequest request, 
			Locale locale)	{
		
		String basePath = request.getSession().getServletContext().getRealPath("/");
		
		Deal deal = dealService.getDeal(dealId, locale);
		List<Attachment> attachments = attachmentService.getFiles(dealId, basePath);
		
		if (deal == null)	 {
			return "404";
		}
		
		if (deal.getStep() < Deal.FINISHED)	{
			String msg = messageSource.getMessage("deal.is.not.finished", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		}
		
		model.addAttribute("deal", deal);
		model.addAttribute("attachmentsList", attachments);
		
		return "deletedeal";
	}
	
	@RequestMapping(value = "/workflow/delete/deal/{dealId}", method = RequestMethod.POST)
	public String deleteDealPost(Model model, 
			@PathVariable("dealId") int dealId, 
			Locale locale)	{
		
		Deal deal = dealService.getDeal(dealId);
		
		if (deal == null)	 {
			return "404";
		}
		
		dealService.deleteDeal(deal);
		
		return "redirect:/workflow/managedeals/init";
	}
	
	@RequestMapping(value = "/workflow/deal/{dealId}/comment/add", method = RequestMethod.GET)
	public String addCommentGet(Model model, 
			@PathVariable("dealId") int dealId, 
			Locale locale)	{
		
		Deal deal = dealService.getDeal(dealId);
		
		if (deal == null)	 {
			return "404";
		}
		
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		boolean coordinatorOnly = false;
		
		if (user.getIsCoordinator()&&!user.getIsOperator())	{
			coordinatorOnly = true;
		}
		
		model.addAttribute("coordinatorOnly", coordinatorOnly);
		model.addAttribute("comment", commentsService.create());
		
		return "addcomment";
	}
	
	@RequestMapping(value = "/workflow/deal/{dealId}/comment/add", method = RequestMethod.POST)
	public String addCommentPost(Model model, @Valid @ModelAttribute("comment") Comment comment, BindingResult result, Locale locale, 
			@PathVariable("dealId") int dealId)	{
		
		Deal deal = dealService.getDeal(dealId);
		
		if (deal == null)	 {
			return "404";
		}
		
		if (result.hasErrors())	{
			model.addAttribute("comment", comment);
			return "addcomment";
		}
		
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		comment.setUser(user);
		comment.setDate(new Date());
		comment.setDeal(deal);
		commentsService.add(comment);
		
		return "redirect:/workflow/edit/deal/" + deal.getId();
	}
	
	@RequestMapping(value = "/dashboard/mydeals")
	public String dashboardMyPage(Model model, Locale locale) {
		
		User user = userService.getUserByUsername(userService.getCurrentUser().getUsername());
		
		model.addAttribute("myDealsList", dealService.getMyActiveDeals(user, locale));
		
		return "mypage";
	}

}
