package org.ekonopaka.crm.service.interfaces;

import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.model.types.BusinessLineType;
import org.ekonopaka.crm.model.types.CompanySizeType;
import org.ekonopaka.crm.model.types.ContactPersonType;
import org.ekonopaka.crm.model.types.ConvictionType;
import org.ekonopaka.crm.model.types.CreditFormType;
import org.ekonopaka.crm.model.types.CreditObjectiveType;
import org.ekonopaka.crm.model.types.CurrencyType;
import org.ekonopaka.crm.model.types.EducationType;
import org.ekonopaka.crm.model.types.GenderType;
import org.ekonopaka.crm.model.types.IncomeType;
import org.ekonopaka.crm.model.types.InterestType;
import org.ekonopaka.crm.model.types.JobType;
import org.ekonopaka.crm.model.types.MaritalStatusType;
import org.ekonopaka.crm.model.types.MilitaryServiceType;
import org.ekonopaka.crm.model.types.OrganizationType;
import org.ekonopaka.crm.model.types.PositionType;
import org.ekonopaka.crm.model.types.PropertyHistoryType;
import org.ekonopaka.crm.model.types.PropertyType;
import org.ekonopaka.crm.model.types.RegionType;

public interface IConstansService {

	public void add(Object object);
	
	public List<String> getYears();
	
	public List<CreditObjectiveType> getObjectiveTypes(Locale locale);
	public List<EducationType> getEducationTypes(Locale locale);
	public List<ConvictionType> getConvictionTypes(Locale locale);
	public List<GenderType> getGenderTypes(Locale locale);
	public List<MilitaryServiceType> getMilitaryServiceTypes(Locale locale);
	public List<MaritalStatusType> getMaritalStatusTypes(Locale locale);
	public List<JobType> getJobTypes(Locale locale);
	public List<BusinessLineType> getBusinessLineTypes(Locale locale);
	public List<OrganizationType> getOrganizationTypes(Locale locale);
	public List<RegionType> getRegionTypes(Locale locale);
	public List<ContactPersonType> getContactPersonTypes(Locale locale);
	public List<PositionType> getPositionTypes(Locale locale);
	public List<CompanySizeType> getCompanySizeTypes(Locale locale);
	public List<IncomeType> getIncomeTypes(boolean isGeneral, boolean isAdditional, boolean isSpouse, Locale locale);
	public List<PropertyType> getPropertyTypes(Boolean isGeneral, Locale locale);
	public List<PropertyHistoryType> getPropertyHistoryTypes(Locale locale);
	public List<CreditFormType> getCreditFormTypes(Locale locale);
	public List<CurrencyType> getCurrencyTypes(Locale locale);
	public List<InterestType> getInterestTypes(Locale locale);
	
}
