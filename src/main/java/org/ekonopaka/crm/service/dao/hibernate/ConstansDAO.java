package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IConstantsDAO;
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
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConstansDAO implements IConstantsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void add(Object object) {
		sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public List<CreditObjectiveType> getObjectiveTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditObjectiveType.class);

		@SuppressWarnings("unchecked")
		List<CreditObjectiveType> creditObjectiveTypes = hibernateTemplate.findByCriteria(criteria);
		return creditObjectiveTypes;
	}

	@Override
	public List<EducationType> getEducationTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(EducationType.class);
		
		@SuppressWarnings("unchecked")
		List<EducationType> educationTypes = hibernateTemplate.findByCriteria(criteria);
		return educationTypes;
	}

	@Override
	public List<ConvictionType> getConvictionTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ConvictionType.class);
		
		@SuppressWarnings("unchecked")
		List<ConvictionType> convictionTypes = hibernateTemplate.findByCriteria(criteria);
		return convictionTypes;
	}

	@Override
	public List<GenderType> getGenderTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(GenderType.class);
		
		@SuppressWarnings("unchecked")
		List<GenderType> genderTypes = hibernateTemplate.findByCriteria(criteria);
		return genderTypes;
	}

	@Override
	public List<MilitaryServiceType> getMilitaryServiceTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(MilitaryServiceType.class);
		
		@SuppressWarnings("unchecked")
		List<MilitaryServiceType> militaryServiceTypes = hibernateTemplate.findByCriteria(criteria);
		return militaryServiceTypes;
	}

	@Override
	public List<MaritalStatusType> getMaritalStatusTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(MaritalStatusType.class);
		
		@SuppressWarnings("unchecked")
		List<MaritalStatusType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<JobType> getJobTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(JobType.class);
		
		@SuppressWarnings("unchecked")
		List<JobType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<BusinessLineType> getBusinessLineTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(BusinessLineType.class);
		
		@SuppressWarnings("unchecked")
		List<BusinessLineType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<OrganizationType> getOrganizationTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(OrganizationType.class);
		
		@SuppressWarnings("unchecked")
		List<OrganizationType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<RegionType> getRegionTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(RegionType.class);
		
		@SuppressWarnings("unchecked")
		List<RegionType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<ContactPersonType> getContactPersonTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ContactPersonType.class);
		
		@SuppressWarnings("unchecked")
		List<ContactPersonType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<PositionType> getPositionTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(PositionType.class);
		
		@SuppressWarnings("unchecked")
		List<PositionType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<CompanySizeType> getCompanySizeTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CompanySizeType.class);
		
		@SuppressWarnings("unchecked")
		List<CompanySizeType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}



	@Override
	public List<PropertyType> getPropertyTypes(Boolean isGeneral) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PropertyType.class);
		
		criteria.add(Restrictions.eq("isGeneral", isGeneral));
		
		@SuppressWarnings("unchecked")
		List<PropertyType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<PropertyHistoryType> getPropertyHistoryTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(PropertyHistoryType.class);
		
		@SuppressWarnings("unchecked")
		List<PropertyHistoryType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<CreditFormType> getCreditFormTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditFormType.class);
		
		@SuppressWarnings("unchecked")
		List<CreditFormType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<InterestType> getInterestTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(InterestType.class);
		
		@SuppressWarnings("unchecked")
		List<InterestType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<CurrencyType> getCurrencyTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CurrencyType.class);
		
		@SuppressWarnings("unchecked")
		List<CurrencyType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

	@Override
	public List<IncomeType> getIncomeTypes(boolean isGeneral, boolean isAdditional, boolean isSpouse) {
		DetachedCriteria criteria = DetachedCriteria.forClass(IncomeType.class);
		
		if (isGeneral) criteria.add(Restrictions.eq("isGeneral", isGeneral));
		if (isAdditional) criteria.add(Restrictions.eq("isAdditional", isAdditional));
		if (isSpouse) criteria.add(Restrictions.eq("isSpouse", isSpouse));
		
		@SuppressWarnings("unchecked")
		List<IncomeType> types = hibernateTemplate.findByCriteria(criteria);
		return types;
	}

}
