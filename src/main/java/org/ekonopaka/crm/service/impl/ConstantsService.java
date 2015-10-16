package org.ekonopaka.crm.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.dao.interfaces.IConstantsDAO;
import org.ekonopaka.crm.handlers.LocatizationTool;
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
import org.ekonopaka.crm.service.interfaces.IConstansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConstantsService implements IConstansService {

	@Autowired
	IConstantsDAO constantsDAO;
	
	@Autowired
	LocatizationTool locatizationTool;
	
	@Override
	@Transactional
	public void add(Object object) {
		constantsDAO.add(object);

	}

	@Override
	@Transactional
	public List<CreditObjectiveType> getObjectiveTypes(Locale locale) {
		List<CreditObjectiveType> types = constantsDAO.getObjectiveTypes();
		return locatizationTool.processCreditObjectiveTypes(types, locale);
	}

	@Override
	public List<EducationType> getEducationTypes(Locale locale) {
		List<EducationType> types = constantsDAO.getEducationTypes();
		return locatizationTool.processEducationTypes(types, locale);
	}

	@Override
	public List<ConvictionType> getConvictionTypes(Locale locale) {
		List<ConvictionType> types = constantsDAO.getConvictionTypes();
		return locatizationTool.processConvictionTypes(types, locale);
	}

	@Override
	public List<GenderType> getGenderTypes(Locale locale) {
		List<GenderType> types = constantsDAO.getGenderTypes();
		return locatizationTool.processGenderTypes(types, locale);
	}

	@Override
	public List<MilitaryServiceType> getMilitaryServiceTypes(Locale locale) {
		List<MilitaryServiceType> types = constantsDAO.getMilitaryServiceTypes();
		return locatizationTool.processMilitaryServiceTypes(types, locale);
	}

	@Override
	public List<MaritalStatusType> getMaritalStatusTypes(Locale locale) {
		List<MaritalStatusType> types = constantsDAO.getMaritalStatusTypes();
		return locatizationTool.processMaritalStatusTypes(types, locale);
	}

	@Override
	public List<JobType> getJobTypes(Locale locale) {
		List<JobType> types = constantsDAO.getJobTypes();
		return locatizationTool.processJobTypes(types, locale);
	}

	@Override
	public List<BusinessLineType> getBusinessLineTypes(Locale locale) {
		List<BusinessLineType> types = constantsDAO.getBusinessLineTypes();
		return locatizationTool.processBusinessLineTypes(types, locale);
	}

	@Override
	public List<OrganizationType> getOrganizationTypes(Locale locale) {
		List<OrganizationType> types = constantsDAO.getOrganizationTypes();
		return locatizationTool.processOrganizationTypes(types, locale);
	}

	@Override
	public List<RegionType> getRegionTypes(Locale locale) {
		List<RegionType> types = constantsDAO.getRegionTypes();
		return locatizationTool.processRegionTypes(types, locale);
	}
	
	@Override
	public List<String> getYears() {
		List<String> years = new ArrayList<String>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int beginYear = currentYear - 100;
		
		for (int i = beginYear; i <= currentYear; i++)	{
			years.add(String.valueOf(i));
		}
		
		Collections.reverse(years);
		
		return years;
	}

	@Override
	public List<ContactPersonType> getContactPersonTypes(Locale locale) {
		List<ContactPersonType> types = constantsDAO.getContactPersonTypes();
		return locatizationTool.processContactPersonTypes(types, locale);
	}

	@Override
	public List<PositionType> getPositionTypes(Locale locale) {
		List<PositionType> types = constantsDAO.getPositionTypes();
		return locatizationTool.processPositionTypes(types, locale);
	}

	@Override
	public List<CompanySizeType> getCompanySizeTypes(Locale locale) {
		List<CompanySizeType> types = constantsDAO.getCompanySizeTypes();
		return locatizationTool.processCompanySizeTypes(types, locale);
	}

	@Override
	public List<IncomeType> getIncomeTypes(boolean isGeneral, boolean isAdditional, boolean isSpouse, Locale locale) {
		List<IncomeType> types = constantsDAO.getIncomeTypes(isGeneral, isAdditional, isSpouse);
		return locatizationTool.processIncomeTypes(types, locale);
	}

	@Override
	public List<PropertyType> getPropertyTypes(Boolean isGeneral, Locale locale) {
		List<PropertyType> types = constantsDAO.getPropertyTypes(isGeneral);
		return locatizationTool.processPropertyTypes(types, locale);
	}

	@Override
	public List<PropertyHistoryType> getPropertyHistoryTypes(Locale locale) {
		List<PropertyHistoryType> types = constantsDAO.getPropertyHistoryTypes();
		return locatizationTool.processPropertyHistoryTypes(types, locale);
	}

	@Override
	public List<CreditFormType> getCreditFormTypes(Locale locale) {
		List<CreditFormType> types = constantsDAO.getCreditFormTypes();
		return locatizationTool.processCreditFormTypes(types, locale);
	}

	@Override
	public List<CurrencyType> getCurrencyTypes(Locale locale) {
		List<CurrencyType> types = constantsDAO.getCurrencyTypes();
		return locatizationTool.processCurrencyTypes(types, locale);
	}

	@Override
	public List<InterestType> getInterestTypes(Locale locale) {
		List<InterestType> types = constantsDAO.getInterestTypes();
		return locatizationTool.processInterestTypes(types, locale);
	}

}
