package org.ekonopaka.crm.init;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.ekonopaka.crm.handlers.ClasspathFileReader;
import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;
import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.types.BusinessLineType;
import org.ekonopaka.crm.model.types.CompanySizeType;
import org.ekonopaka.crm.model.types.ContactPersonType;
import org.ekonopaka.crm.model.types.ConvictionType;
import org.ekonopaka.crm.model.types.CreditFormType;
import org.ekonopaka.crm.model.types.CreditObjectiveType;
import org.ekonopaka.crm.model.types.CreditType;
import org.ekonopaka.crm.model.types.CurrencyType;
import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;
import org.ekonopaka.crm.model.types.EducationType;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.model.types.GenderType;
import org.ekonopaka.crm.model.types.IncomeType;
import org.ekonopaka.crm.model.types.InfoSourceType;
import org.ekonopaka.crm.model.types.InterestType;
import org.ekonopaka.crm.model.types.JobType;
import org.ekonopaka.crm.model.types.MaritalStatusType;
import org.ekonopaka.crm.model.types.MilitaryServiceType;
import org.ekonopaka.crm.model.types.OrganizationType;
import org.ekonopaka.crm.model.types.PositionType;
import org.ekonopaka.crm.model.types.PropertyHistoryType;
import org.ekonopaka.crm.model.types.PropertyType;
import org.ekonopaka.crm.model.types.RegionType;
import org.ekonopaka.crm.service.interfaces.IClientService;
import org.ekonopaka.crm.service.interfaces.IConstansService;
import org.ekonopaka.crm.service.interfaces.ICreditService;
import org.ekonopaka.crm.service.interfaces.IEmploymentTypeService;
import org.ekonopaka.crm.service.interfaces.IInfoSourceService;
import org.ekonopaka.crm.service.interfaces.IOfficeService;
import org.ekonopaka.crm.service.interfaces.IPhoneService;
import org.ekonopaka.crm.service.interfaces.IRoleService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.XStream;

@Component
public class InitConfigurator {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	IUserService userService;
	
	@Autowired
	IConstansService constansService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IInfoSourceService infoSourceService;

	@Autowired
	ICreditService creditService;

	@Autowired
	IClientService clientService;

	@Autowired
	IEmploymentTypeService employmentTypeService;

	@Autowired
	IOfficeService officeService;

	@Autowired
	IPhoneService phoneService;

	@Autowired
	ClasspathFileReader classpathFileReader;

	XStream xStream = new XStream();
	Configuration configuration;
	String xml;

	String path = "init.xml";

	public void process(String path) {
		try {
			xml = classpathFileReader.readFile(path);

			configuration = (Configuration) xStream.fromXML(xml);
			
			List<BusinessLineType> businessLineTypes = configuration.getBusinessLineTypes();
			if (businessLineTypes!=null)	{
			for (Object object : businessLineTypes) {
					constansService.add(object);
				}
			}
			
			List<CurrencyType> currencyTypes = configuration.getCurrencyTypes();
			if (currencyTypes!=null)	{
			for (Object object : currencyTypes) {
					constansService.add(object);
				}
			}
			
			List<DealStateType> dealStateTypes = configuration.getDealStateTypes();
			if (dealStateTypes!=null)	{
			for (Object object : dealStateTypes) {
					constansService.add(object);
				}
			}
			
			List<DealWorkflowSideType> dealWorkflowSideTypes = configuration.getDealWorkflowSideTypes();
			if (dealWorkflowSideTypes!=null)	{
			for (Object object : dealWorkflowSideTypes) {
					constansService.add(object);
				}
			}
			
			List<DealWorkflowType> dealWorkflowTypes = configuration.getDealWorkflowTypes();
			if (dealWorkflowTypes!=null)	{
			for (Object object : dealWorkflowTypes) {
					constansService.add(object);
				}
			}
			
			List<InterestType> interestTypes = configuration.getInterestTypes();
			if (interestTypes!=null)	{
			for (Object object : interestTypes) {
					constansService.add(object);
				}
			}
			
			List<CompanySizeType> companySizeTypes = configuration.getCompanySizeTypes();
			if (companySizeTypes!=null)	{
			for (Object object : companySizeTypes) {
					constansService.add(object);
				}
			}
			
			List<ContactPersonType> contactPersonTypes = configuration.getContactPersonTypes();
			if (contactPersonTypes!=null)	{
			for (Object object : contactPersonTypes) {
					constansService.add(object);
				}
			}
			
			List<ConvictionType> convictionTypes = configuration.getConvictionTypes();
			if (convictionTypes!=null)	{
			for (Object object : convictionTypes) {
					constansService.add(object);
				}
			}
			
			List<CreditObjectiveType> creditObjectiveTypes = configuration.getCreditObjectiveTypes();
			if (creditObjectiveTypes!=null)	{
			for (Object object : creditObjectiveTypes) {
					constansService.add(object);
				}
			}
			
			List<CreditType> creditTypes = configuration.getCreditTypes();
			if (creditTypes!=null)	{
			for (Object object : creditTypes) {
					constansService.add(object);
				}
			}
			
			List<EducationType> educationTypes = configuration.getEducationTypes();
			if (educationTypes!=null)	{
			for (Object object : educationTypes) {
					constansService.add(object);
				}
			}
			
			List<EmploymentType> employmentTypes = configuration.getEmploymentTypes();
			if (employmentTypes!=null)	{
			for (Object object : employmentTypes) {
					constansService.add(object);
				}
			}
			
			List<GenderType> genderTypes = configuration.getGenderTypes();
			if (genderTypes!=null)	{
			for (Object object : genderTypes) {
					constansService.add(object);
				}
			}
			
			List<IncomeType> incomeTypes = configuration.getIncomeTypes();
			if (incomeTypes!=null)	{
			for (Object object : incomeTypes) {
					constansService.add(object);
				}
			}
			
			List<InfoSourceType> infoSourceTypes = configuration.getInfoSourceTypes();
			if (infoSourceTypes!=null)	{
			for (Object object : infoSourceTypes) {
					constansService.add(object);
				}
			}
			
			List<JobType> jobTypes = configuration.getJobTypes();
			if (jobTypes!=null)	{
			for (Object object : jobTypes) {
					constansService.add(object);
				}
			}
			
			List<MaritalStatusType> maritalStatuses = configuration.getMaritalStatusTypes();
			if (maritalStatuses!=null)	{
			for (Object object : maritalStatuses) {
					constansService.add(object);
				}
			}
			
			List<MilitaryServiceType> militaryServiceTypes = configuration.getMilitaryServiceTypes();
			if (militaryServiceTypes!=null)	{
			for (Object object : militaryServiceTypes) {
					constansService.add(object);
				}
			}
			
			List<OrganizationType> organizationTypes = configuration.getOrganizationTypes();
			if (organizationTypes!=null)	{
			for (Object object : organizationTypes) {
					constansService.add(object);
				}
			}
			
			List<PositionType> positionTypes = configuration.getPositionTypes();
			if (positionTypes!=null)	{
			for (Object object : positionTypes) {
					constansService.add(object);
				}
			}
			
			List<PropertyHistoryType> propertyHistoryTypes = configuration.getPropertyHistoryTypes();
			if (propertyHistoryTypes!=null)	{
			for (Object object : propertyHistoryTypes) {
					constansService.add(object);
				}
			}
			
			List<PropertyType> propertyTypes = configuration.getPropertyTypes();
			if (propertyTypes!=null)	{
			for (Object object : propertyTypes) {
					constansService.add(object);
				}
			}
			
			List<RegionType> regionTypes = configuration.getRegionTypes();
			if (regionTypes!=null)	{
			for (Object object : regionTypes) {
					constansService.add(object);
				}
			}
			
			List<CreditFormType> creditFormTypes = configuration.getCreditFormTypes();
			if (creditFormTypes!=null)	{
			for (Object object : creditFormTypes) {
					constansService.add(object);
				}
			}
			
			List<Role> roles = configuration.getRoles();
			if (roles!=null)	{
				for (Role role : roles) {
					roleService.addRole(role);
				}
			}

			List<Office> offices = configuration.getOffices();
			if (offices!=null)	{
				for (Office office : offices) {
					officeService.addOffice(office);
				}
			}

			List<PhoneNumber> phoneNumbers = configuration.getPhoneNumbers();
			if (phoneNumbers!=null)	{
				for (PhoneNumber phoneNumber : phoneNumbers) {
					phoneService.addPhoneNumber(phoneNumber);
				}
			}

			List<User> users = configuration.getUsers();
			if (users!=null)	{
				for (User user : users) {
					userService.addUser(user);
				}
			}

			List<InfoSource> infoSources = configuration.getInfoSources();
			if (infoSources!=null)	{
				for (InfoSource infoSource : infoSources) {
					infoSourceService.addSource(infoSource);
				}
			}

			List<Client> clients = configuration.getClients();
			if (clients!=null)	{
				for (Client client : clients) {
					clientService.addClient(client);
				}
			}

		} catch (IOException e) {
			logger.error("Unable to get init.xml file. Initial data inserting failed.");
		}
	}
	
	public void process() {
		process(this.path);
	}

	public InitConfigurator() {
		xStream.alias("infoSourceType", InfoSourceType.class);
		xStream.alias("employmentType", EmploymentType.class);
		xStream.alias("businessLineType", BusinessLineType.class);
		xStream.alias("companySizeType", CompanySizeType.class);
		xStream.alias("contactPersonType", ContactPersonType.class);
		xStream.alias("convictionType", ConvictionType.class);
		xStream.alias("creditObjectiveType", CreditObjectiveType.class);
		xStream.alias("educationType", EducationType.class);
		xStream.alias("genderType", GenderType.class);
		xStream.alias("incomeType", IncomeType.class);
		xStream.alias("jobType", JobType.class);
		xStream.alias("maritalStatusType", MaritalStatusType.class);
		xStream.alias("militaryServiceType", MilitaryServiceType.class);
		xStream.alias("organizationType", OrganizationType.class);
		xStream.alias("positionType", PositionType.class);
		xStream.alias("propertyType", PropertyType.class);
		xStream.alias("regionType", RegionType.class);
		xStream.alias("creditFormType", CreditFormType.class);
		xStream.alias("dealStateType", DealStateType.class);
		xStream.alias("dealWorkflowSideType", DealWorkflowSideType.class);
		xStream.alias("dealWorkflowType", DealWorkflowType.class);		
		
		xStream.alias("user", User.class);
		xStream.alias("role", Role.class);
		xStream.alias("infoSource", InfoSource.class);
		xStream.alias("configuration", Configuration.class);
		xStream.alias("creditType", CreditType.class);
		xStream.alias("credit", Credit.class);
		xStream.alias("client", Client.class);
		xStream.alias("office", Office.class);
		xStream.alias("phoneNumber", PhoneNumber.class);
		xStream.alias("client", Client.class);
	}

	public void init() {
		try {
			userService.getUserByUsername(User.ADMIN_USERNAME);
		} catch (UsernameNotFoundException unfe) {
			logger.info("This is first start of the application. Trying to create initial entities");
			process();
		}
	}
}
