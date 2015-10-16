package org.ekonopaka.crm.handlers;

import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.actions.Action;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.PhoneNumber;
import org.ekonopaka.crm.model.Role;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class LocatizationTool {

	@Autowired
	MessageSource messageSource;

	public List<Role> processRoles(List<Role> rolesList, Locale locale) {
		for (Role role : rolesList) {
			role.setDescription(messageSource.getMessage(role.getCode(), null,
					locale));
		}
		return rolesList;
	}

	public Role processRole(Role role, Locale locale) {
		role.setCode(messageSource.getMessage(role.getCode(), null, locale));
		return role;
	}

	public InfoSource processInfoSource(InfoSource infoSource, Locale locale) {
		InfoSourceType infoSourceType = infoSource.getInfoSourceType();
		infoSourceType.setDescription(messageSource.getMessage(infoSourceType.getCode(), null, locale));
		return infoSource;
	}

	public List<InfoSource> processInfoSources(List<InfoSource> infoSources,
			Locale locale) {
		for (InfoSource infoSource : infoSources) {
			InfoSourceType infoSourceType = infoSource.getInfoSourceType();
			infoSourceType.setDescription(messageSource.getMessage(infoSourceType.getCode(), null, locale));
		}
		return infoSources;
	}

	public List<InfoSourceType> processInfoSourceTypes(
			List<InfoSourceType> infoSourceTypes, Locale locale) {
		for (InfoSourceType infoSourceType : infoSourceTypes) {
			infoSourceType.setDescription(messageSource.getMessage(infoSourceType.getCode(), null, locale));
		}
		return infoSourceTypes;
	}

	public List<EmploymentType> processEmploymentTypes(
			List<EmploymentType> employmentTypes, Locale locale) {
		for (EmploymentType employmentType : employmentTypes) {
			if (employmentType.getDescription() == null || employmentType.getDescription().equals("")) {
				employmentType.setDescription(messageSource.getMessage(employmentType.getCode(), null, locale));
			}
		}
		return employmentTypes;
	}

	public EmploymentType processEmploymentType(EmploymentType employmentType,
			Locale locale) {
		if (employmentType.getDescription() == null || employmentType.getDescription().equals("")) {
			employmentType.setDescription(messageSource.getMessage(employmentType.getCode(), null, locale));
		}
		return employmentType;
	}
	
	public List<PhoneNumber> processPhoneNumbers(List<PhoneNumber> phoneNumbersList, Locale locale)	{
		String mobilePhoneLabel = messageSource.getMessage("mobile.phone.label", null, locale);
		
		for (PhoneNumber number : phoneNumbersList)	{
			String fullPhoneName = number.getPhoneFullName();
			number.setPhoneFullNameLocalized(fullPhoneName.replace("mobile.phone.label", mobilePhoneLabel));
		}
		
		return phoneNumbersList;
	}
	
	public List<CreditType> processCreditTypes(List<CreditType> creditTypes, Locale locale)	{
		for (CreditType creditType : creditTypes) {
			if (creditType.getDescription() == null || creditType.getDescription().equals("")) {
				creditType.setDescription(messageSource.getMessage(creditType.getCode(), null, locale));
			}
		}
		return creditTypes;
	}
	
	public CreditType processCreditType(CreditType creditType, Locale locale)	{
		if (creditType.getDescription() == null || creditType.getDescription().equals("")) {
			creditType.setDescription(messageSource.getMessage(creditType.getCode(), null, locale));
		}
		return creditType;
	}
	
	public List<CreditObjectiveType> processCreditObjectiveTypes(List<CreditObjectiveType> types, Locale locale)	{
		for (CreditObjectiveType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<EducationType> processEducationTypes(List<EducationType> types, Locale locale)	{
		for (EducationType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<MilitaryServiceType> processMilitaryServiceTypes(List<MilitaryServiceType> types, Locale locale)	{
		for (MilitaryServiceType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<GenderType> processGenderTypes(List<GenderType> types, Locale locale)	{
		for (GenderType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<ConvictionType> processConvictionTypes(List<ConvictionType> types, Locale locale)	{
		for (ConvictionType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<JobType> processJobTypes(List<JobType> types, Locale locale)	{
		for (JobType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<BusinessLineType> processBusinessLineTypes(List<BusinessLineType> types, Locale locale)	{
		for (BusinessLineType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<OrganizationType> processOrganizationTypes(List<OrganizationType> types, Locale locale)	{
		for (OrganizationType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<MaritalStatusType> processMaritalStatusTypes(List<MaritalStatusType> types, Locale locale)	{
		for (MaritalStatusType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<RegionType> processRegionTypes(List<RegionType> types, Locale locale)	{
		for (RegionType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<ContactPersonType> processContactPersonTypes(List<ContactPersonType> types, Locale locale)	{
		for (ContactPersonType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<PositionType> processPositionTypes(List<PositionType> types, Locale locale)	{
		for (PositionType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<CompanySizeType> processCompanySizeTypes(List<CompanySizeType> types, Locale locale)	{
		for (CompanySizeType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}	
	
	public List<IncomeType> processIncomeTypes(List<IncomeType> types, Locale locale)	{
		for (IncomeType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<PropertyType> processPropertyTypes(List<PropertyType> types, Locale locale)	{
		for (PropertyType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<PropertyHistoryType> processPropertyHistoryTypes(List<PropertyHistoryType> types, Locale locale)	{
		for (PropertyHistoryType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<CreditFormType> processCreditFormTypes(List<CreditFormType> types, Locale locale)	{
		for (CreditFormType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<CurrencyType> processCurrencyTypes(List<CurrencyType> types, Locale locale)	{
		for (CurrencyType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<InterestType> processInterestTypes(List<InterestType> types, Locale locale)	{
		for (InterestType type : types) {
			if (type.getDescription() == null || type.getDescription().equals("")) {
				type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
			}
		}
		return types;
	}
	
	public List<Action> processActions(List<Action> actions, Locale locale)	{
		for (Action action : actions) {
			if (action.getName() == null || action.getName().equals("")) {
				action.setName(messageSource.getMessage(action.getCode(), null, locale));
			}
		}
		return actions;
	}
	
	public CreditObjectiveType process(CreditObjectiveType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public GenderType process(GenderType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public EducationType process(EducationType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public MilitaryServiceType process(MilitaryServiceType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public ConvictionType process(ConvictionType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public BusinessLineType process(BusinessLineType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public OrganizationType process(OrganizationType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public MaritalStatusType process(MaritalStatusType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public RegionType process(RegionType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public ContactPersonType process(ContactPersonType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public JobType process(JobType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public PositionType process(PositionType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public CompanySizeType process(CompanySizeType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public IncomeType process(IncomeType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public PropertyType process(PropertyType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public PropertyHistoryType process(PropertyHistoryType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public CreditFormType process(CreditFormType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public CurrencyType process(CurrencyType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public InterestType process(InterestType type, Locale locale)	{
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}

	public CurrencyType processCurrencyType(CurrencyType type, Locale locale) {
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public DealWorkflowSideType processDealWorkflowSideType(DealWorkflowSideType type, Locale locale) {
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public DealWorkflowType processDealWorkflowType(DealWorkflowType type, Locale locale) {
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	public DealStateType processDealStateType(DealStateType type, Locale locale) {
		if (type.getDescription() == null || type.getDescription().equals("")) {
			type.setDescription(messageSource.getMessage(type.getCode(), null, locale));
		}
		
		return type;
	}
	
	
	
}
