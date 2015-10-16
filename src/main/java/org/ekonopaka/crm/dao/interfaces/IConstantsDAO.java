package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

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

public interface IConstantsDAO {

	public void add(Object object);
	
	public List<CreditObjectiveType> getObjectiveTypes();
	public List<EducationType> getEducationTypes();
	public List<ConvictionType> getConvictionTypes();
	public List<GenderType> getGenderTypes();
	public List<MilitaryServiceType> getMilitaryServiceTypes();
	public List<MaritalStatusType> getMaritalStatusTypes();
	public List<JobType> getJobTypes();
	public List<BusinessLineType> getBusinessLineTypes();
	public List<OrganizationType> getOrganizationTypes();
	public List<RegionType> getRegionTypes();
	public List<ContactPersonType> getContactPersonTypes();
	public List<PositionType> getPositionTypes();
	public List<CompanySizeType> getCompanySizeTypes();
	public List<IncomeType> getIncomeTypes(boolean isGeneral, boolean isAdditional, boolean isSpouse);
	public List<PropertyType> getPropertyTypes(Boolean isGeneral);
	public List<PropertyHistoryType> getPropertyHistoryTypes();
	public List<CreditFormType> getCreditFormTypes();
	public List<InterestType> getInterestTypes();
	public List<CurrencyType> getCurrencyTypes();

}
