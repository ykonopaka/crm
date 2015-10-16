package org.ekonopaka.crm.init;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.Client;
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

public class Configuration {

	List<InfoSource> infoSources = new ArrayList<InfoSource>();
	List<User> users = new ArrayList<User>();
	List<Role> roles = new ArrayList<Role>();
	List<Office> offices = new ArrayList<Office>();
	List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
	List<Client> clients = new ArrayList<Client>();
	
	List<BusinessLineType> businessLineTypes = new ArrayList<BusinessLineType>();
	List<CompanySizeType> companySizeTypes = new ArrayList<CompanySizeType>();
	List<ContactPersonType> contactPersonTypes = new ArrayList<ContactPersonType>();
	List<ConvictionType> convictionTypes = new ArrayList<ConvictionType>();
	List<CreditObjectiveType> creditObjectiveTypes = new ArrayList<CreditObjectiveType>();
	List<CreditType> creditTypes = new ArrayList<CreditType>();
	List<EducationType> educationTypes = new ArrayList<EducationType>();
	List<EmploymentType> employmentTypes = new ArrayList<EmploymentType>();
	List<GenderType> genderTypes = new ArrayList<GenderType>();
	List<IncomeType> incomeTypes = new ArrayList<IncomeType>();
	List<InfoSourceType> infoSourceTypes = new ArrayList<InfoSourceType>();
	List<JobType> jobTypes = new ArrayList<JobType>();
	List<MaritalStatusType> maritalStatusTypes = new ArrayList<MaritalStatusType>();
	List<MilitaryServiceType> militaryServiceTypes = new ArrayList<MilitaryServiceType>();
	List<OrganizationType> organizationTypes = new ArrayList<OrganizationType>();
	List<PositionType> positionTypes = new ArrayList<PositionType>();
	List<PropertyHistoryType> propertyHistoryTypes = new ArrayList<PropertyHistoryType>();
	List<PropertyType> propertyTypes = new ArrayList<PropertyType>();
	List<RegionType> regionTypes = new ArrayList<RegionType>();
	List<CreditFormType> creditFormTypes = new ArrayList<CreditFormType>();
	List<InterestType> interestTypes = new ArrayList<InterestType>();
	List<CurrencyType> currencyTypes = new ArrayList<CurrencyType>();
	List<DealStateType> dealStateTypes = new ArrayList<DealStateType>();
	List<DealWorkflowSideType> dealWorkflowSideTypes = new ArrayList<DealWorkflowSideType>();
	List<DealWorkflowType> dealWorkflowTypes = new ArrayList<DealWorkflowType>();
	
	public List<InfoSource> getInfoSources() {
		return infoSources;
	}
	
	public void setInfoSources(List<InfoSource> infoSources) {
		this.infoSources = infoSources;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Office> getOffices() {
		return offices;
	}
	
	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}
	
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public List<BusinessLineType> getBusinessLineTypes() {
		return businessLineTypes;
	}
	
	public void setBusinessLineTypes(List<BusinessLineType> businessLineTypes) {
		this.businessLineTypes = businessLineTypes;
	}
	
	public List<CompanySizeType> getCompanySizeTypes() {
		return companySizeTypes;
	}
	
	public void setCompanySizeTypes(List<CompanySizeType> companySizeTypes) {
		this.companySizeTypes = companySizeTypes;
	}
	
	public List<ContactPersonType> getContactPersonTypes() {
		return contactPersonTypes;
	}
	
	public void setContactPersonTypes(List<ContactPersonType> contactPersonTypes) {
		this.contactPersonTypes = contactPersonTypes;
	}
	
	public List<ConvictionType> getConvictionTypes() {
		return convictionTypes;
	}
	
	public void setConvictionTypes(List<ConvictionType> convictionTypes) {
		this.convictionTypes = convictionTypes;
	}
	
	public List<CreditObjectiveType> getCreditObjectiveTypes() {
		return creditObjectiveTypes;
	}
	
	public void setCreditObjectiveTypes(
			List<CreditObjectiveType> creditObjectiveTypes) {
		this.creditObjectiveTypes = creditObjectiveTypes;
	}
	
	public List<CreditType> getCreditTypes() {
		return creditTypes;
	}
	
	public void setCreditTypes(List<CreditType> creditTypes) {
		this.creditTypes = creditTypes;
	}
	
	public List<EducationType> getEducationTypes() {
		return educationTypes;
	}
	
	public void setEducationTypes(List<EducationType> educationTypes) {
		this.educationTypes = educationTypes;
	}
	
	public List<EmploymentType> getEmploymentTypes() {
		return employmentTypes;
	}
	
	public void setEmploymentTypes(List<EmploymentType> employmentTypes) {
		this.employmentTypes = employmentTypes;
	}
	
	public List<GenderType> getGenderTypes() {
		return genderTypes;
	}
	
	public void setGenderTypes(List<GenderType> genderTypes) {
		this.genderTypes = genderTypes;
	}
	
	public List<IncomeType> getIncomeTypes() {
		return incomeTypes;
	}
	
	public void setIncomeTypes(List<IncomeType> incomeTypes) {
		this.incomeTypes = incomeTypes;
	}
	
	public List<InfoSourceType> getInfoSourceTypes() {
		return infoSourceTypes;
	}
	
	public void setInfoSourceTypes(List<InfoSourceType> infoSourceTypes) {
		this.infoSourceTypes = infoSourceTypes;
	}
	
	public List<JobType> getJobTypes() {
		return jobTypes;
	}
	
	public void setJobTypes(List<JobType> jobTypes) {
		this.jobTypes = jobTypes;
	}
	
	public List<MaritalStatusType> getMaritalStatusTypes() {
		return maritalStatusTypes;
	}
	
	public void setMaritalStatusTypes(List<MaritalStatusType> maritalStatusTypes) {
		this.maritalStatusTypes = maritalStatusTypes;
	}
	
	public List<MilitaryServiceType> getMilitaryServiceTypes() {
		return militaryServiceTypes;
	}
	
	public void setMilitaryServiceTypes(
			List<MilitaryServiceType> militaryServiceTypes) {
		this.militaryServiceTypes = militaryServiceTypes;
	}
	
	public List<OrganizationType> getOrganizationTypes() {
		return organizationTypes;
	}
	
	public void setOrganizationTypes(List<OrganizationType> organizationTypes) {
		this.organizationTypes = organizationTypes;
	}
	
	public List<PositionType> getPositionTypes() {
		return positionTypes;
	}
	
	public void setPositionTypes(List<PositionType> positionTypes) {
		this.positionTypes = positionTypes;
	}
	
	public List<PropertyHistoryType> getPropertyHistoryTypes() {
		return propertyHistoryTypes;
	}
	
	public void setPropertyHistoryTypes(
			List<PropertyHistoryType> propertyHistoryTypes) {
		this.propertyHistoryTypes = propertyHistoryTypes;
	}
	
	public List<PropertyType> getPropertyTypes() {
		return propertyTypes;
	}
	
	public void setPropertyTypes(List<PropertyType> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}
	
	public List<RegionType> getRegionTypes() {
		return regionTypes;
	}
	
	public void setRegionTypes(List<RegionType> regionTypes) {
		this.regionTypes = regionTypes;
	}
	
	public void addBusinessLineType(BusinessLineType businessLineType) {
		businessLineTypes.add(businessLineType);
	}
	
	public void addCompanySizeType(CompanySizeType companySizeType) {
		companySizeTypes.add(companySizeType);
	}
	
	public void addContactPersonType(ContactPersonType contactPersonType) {
		contactPersonTypes.add(contactPersonType);
	}
	
	public void addConvictionType(ConvictionType convictionType) {
		convictionTypes.add(convictionType);
	}
	
	public void addCreditObjectiveType(CreditObjectiveType creditObjectiveType) {
		creditObjectiveTypes.add(creditObjectiveType);
	}
	
	public void addCreditType(CreditType creditType) {
		creditTypes.add(creditType);
	}
	
	public void addEducationType(EducationType educationType) {
		educationTypes.add(educationType);
	}
	
	public void addEmploymentType(EmploymentType employmentType) {
		employmentTypes.add(employmentType);
	}
	
	public void addGenderType(GenderType genderType) {
		genderTypes.add(genderType);
	}
	
	public void addIncomeType(IncomeType incomeType) {
		incomeTypes.add(incomeType);
	}
	
	public void addInfoSourceType(InfoSourceType infoSourceType) {
		infoSourceTypes.add(infoSourceType);
	}
	
	public void addJobType(JobType jobType) {
		jobTypes.add(jobType);
	}
	
	public void addMaritalStatusType(MaritalStatusType maritalStatusType) {
		maritalStatusTypes.add(maritalStatusType);
	}
	
	public void addMilitaryServiceType(MilitaryServiceType militaryServiceType) {
		militaryServiceTypes.add(militaryServiceType);
	}
	
	public void addOrganizationType(OrganizationType organizationType) {
		organizationTypes.add(organizationType);
	}
	
	public void addPositionType(PositionType positionType) {
		positionTypes.add(positionType);
	}
	
	public void addPropertyHistoryType(PropertyHistoryType propertyHistoryType) {
		propertyHistoryTypes.add(propertyHistoryType);
	}
	
	public void addPropertyType(PropertyType propertyType) {
		propertyTypes.add(propertyType);
	}
	
	public void addRegionType(RegionType regionType) {
		regionTypes.add(regionType);
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void addOffice(Office office) {
		offices.add(office);
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}

	public void addInfoSource(InfoSource infoSource) {
		infoSources.add(infoSource);
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public List<CreditFormType> getCreditFormTypes() {
		return creditFormTypes;
	}

	public void setCreditFormTypes(List<CreditFormType> creditFormTypes) {
		this.creditFormTypes = creditFormTypes;
	}

	public List<InterestType> getInterestTypes() {
		return interestTypes;
	}

	public void setInterestTypes(List<InterestType> interestTypes) {
		this.interestTypes = interestTypes;
	}

	public List<CurrencyType> getCurrencyTypes() {
		return currencyTypes;
	}

	public void setCurrencyTypes(List<CurrencyType> currencyTypes) {
		this.currencyTypes = currencyTypes;
	}

	public List<DealStateType> getDealStateTypes() {
		return dealStateTypes;
	}

	public void setDealStateTypes(List<DealStateType> dealStateTypes) {
		this.dealStateTypes = dealStateTypes;
	}

	public List<DealWorkflowSideType> getDealWorkflowSideTypes() {
		return dealWorkflowSideTypes;
	}

	public void setDealWorkflowSideTypes(
			List<DealWorkflowSideType> dealWorkflowSideTypes) {
		this.dealWorkflowSideTypes = dealWorkflowSideTypes;
	}

	public List<DealWorkflowType> getDealWorkflowTypes() {
		return dealWorkflowTypes;
	}

	public void setDealWorkflowTypes(List<DealWorkflowType> dealWorkflowTypes) {
		this.dealWorkflowTypes = dealWorkflowTypes;
	}
	
}
