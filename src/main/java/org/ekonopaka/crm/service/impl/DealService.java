package org.ekonopaka.crm.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.constants.DealStates;
import org.ekonopaka.crm.constants.DealWorkflowSideTypes;
import org.ekonopaka.crm.constants.DealWorkflowStates;
import org.ekonopaka.crm.dao.interfaces.IDealDAO;
import org.ekonopaka.crm.dao.interfaces.IWorkflowDAO;
import org.ekonopaka.crm.handlers.DateFormatter;
import org.ekonopaka.crm.handlers.LocatizationTool;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.OptionsColumnHandler;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.Customer;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.WorkingPlace;
import org.ekonopaka.crm.model.types.BusinessLineType;
import org.ekonopaka.crm.model.types.CompanySizeType;
import org.ekonopaka.crm.model.types.ContactPersonType;
import org.ekonopaka.crm.model.types.ConvictionType;
import org.ekonopaka.crm.model.types.CreditFormType;
import org.ekonopaka.crm.model.types.CreditObjectiveType;
import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;
import org.ekonopaka.crm.model.types.EducationType;
import org.ekonopaka.crm.model.types.GenderType;
import org.ekonopaka.crm.model.types.IncomeType;
import org.ekonopaka.crm.model.types.JobType;
import org.ekonopaka.crm.model.types.MaritalStatusType;
import org.ekonopaka.crm.model.types.MilitaryServiceType;
import org.ekonopaka.crm.model.types.OrganizationType;
import org.ekonopaka.crm.model.types.PositionType;
import org.ekonopaka.crm.model.types.PropertyHistoryType;
import org.ekonopaka.crm.model.types.PropertyType;
import org.ekonopaka.crm.model.types.RegionType;
import org.ekonopaka.crm.service.interfaces.IDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DealService implements IDealService {

	@Autowired
	DateFormatter dateFormatter;
	
	@Autowired
	OptionsColumnHandler optionsColumnHandler;
	
	@Autowired
	IDealDAO dealDAO;
	
	@Autowired
	IWorkflowDAO workflowDAO;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	LocatizationTool locatizationTool;
	
	@Override
	@Transactional
	public void addDeal(Deal deal) {
		deal.setCreationDate(new Date());
		deal.setModificationDate(new Date());
		
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.NEW_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.OPERATOR_CREATE_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealDAO.addDeal(deal);
	}

	@Override
	@Transactional
	public void deleteDeal(Deal deal) {
		dealDAO.deleteDeal(deal);
	}

	@Override
	@Transactional
	public void updateDeal(Deal deal) {
		deal.setModificationDate(new Date());
		dealDAO.updateDeal(deal);
	}

	@Override
	@Transactional
	public Deal createDeal() {
		Deal deal = new Deal();
		deal.setStep(Deal.CREDIT_INFO_STEP);
		return deal;
	}

	@Override
	@Transactional
	public void updateDeal(Deal deal, int step, String continueLink) {
		deal.setStep(step);
		deal.setModificationDate(new Date());
		deal.setContinueLink(continueLink);
		dealDAO.updateDeal(deal);
	}

	@Override
	@Transactional
	public Deal getDeal(int id, Locale locale) {
		Deal deal = dealDAO.getDeal(id); 
		
		CreditObjectiveType creditObjectiveType = deal.getCredit().getCreditObjectiveType();
		deal.getCredit().setCreditObjectiveType(locatizationTool.process(creditObjectiveType, locale));
		
		if (deal.getCustomer() != null)	{
			GenderType genderType = deal.getCustomer().getGenderType();
			EducationType educationType = deal.getCustomer().getEducationType();
			ConvictionType convictionType = deal.getCustomer().getConvictionType();
			MilitaryServiceType militaryServiceType = deal.getCustomer().getMilitaryServiceType();
			
			if (genderType != null) {deal.getCustomer().setGenderType(locatizationTool.process(genderType, locale));
			if (educationType != null) deal.getCustomer().setEducationType(locatizationTool.process(educationType, locale));
			if (convictionType != null) deal.getCustomer().setConvictionType(locatizationTool.process(convictionType, locale));
			if (militaryServiceType != null) deal.getCustomer().setMilitaryServiceType(locatizationTool.process(militaryServiceType, locale));
			
			if (deal.getCustomer().getMarriage() != null)	{
				BusinessLineType businessLineType = deal.getCustomer().getMarriage().getBusinessLineType();
				OrganizationType organizationType = deal.getCustomer().getMarriage().getOrganizationType();
				MaritalStatusType maritalStatusType = deal.getCustomer().getMarriage().getMaritalStatusType();
				
				if (businessLineType != null) deal.getCustomer().getMarriage().setBusinessLineType(locatizationTool.process(businessLineType, locale));
				if (organizationType != null) deal.getCustomer().getMarriage().setOrganizationType(locatizationTool.process(organizationType, locale));
				if (maritalStatusType != null) deal.getCustomer().getMarriage().setMaritalStatusType(locatizationTool.process(maritalStatusType, locale));
				}
			}
			
			if (deal.getCustomer().getAddress() != null)	{
				RegionType rRegionType = deal.getCustomer().getAddress().getrRegionType();
				RegionType aRegionType = deal.getCustomer().getAddress().getaRegionType();
				
				
				if (rRegionType != null) deal.getCustomer().getAddress().setrRegionType(locatizationTool.process(rRegionType, locale));
				if (aRegionType != null)deal.getCustomer().getAddress().setaRegionType(locatizationTool.process(aRegionType, locale));
			}
			
			if (deal.getCustomer().getContactPersons() != null)	{
				ContactPersonType fContactPersonType = deal.getCustomer().getContactPersons().getFpContactPersonType();
				ContactPersonType sContactPersonType = deal.getCustomer().getContactPersons().getSpContactPersonType();

				if (fContactPersonType != null) deal.getCustomer().getContactPersons().setFpContactPersonType(locatizationTool.process(fContactPersonType, locale));
				if (sContactPersonType != null)deal.getCustomer().getContactPersons().setSpContactPersonType(locatizationTool.process(sContactPersonType, locale));
			}
			
			if (deal.getCustomer().getWorkingPlace() != null)	{
				BusinessLineType businessLineType = deal.getCustomer().getWorkingPlace().getBusinessLineType();
				JobType jobType = deal.getCustomer().getWorkingPlace().getJobType();
				PositionType positionType = deal.getCustomer().getWorkingPlace().getPositionType();
				OrganizationType organizationType = deal.getCustomer().getWorkingPlace().getOrganizationType();
				CompanySizeType companySizeType = deal.getCustomer().getWorkingPlace().getCompanySizeType();
				RegionType regionType = deal.getCustomer().getWorkingPlace().getRegionType();
				
				if (businessLineType != null) deal.getCustomer().getWorkingPlace().setBusinessLineType(locatizationTool.process(businessLineType, locale));
				if (jobType != null) deal.getCustomer().getWorkingPlace().setJobType(locatizationTool.process(jobType, locale));
				if (positionType != null) deal.getCustomer().getWorkingPlace().setPositionType(locatizationTool.process(positionType, locale));
				if (organizationType != null) deal.getCustomer().getWorkingPlace().setOrganizationType(locatizationTool.process(organizationType, locale));
				if (companySizeType != null) deal.getCustomer().getWorkingPlace().setCompanySizeType(locatizationTool.process(companySizeType, locale));
				if (regionType != null) deal.getCustomer().getWorkingPlace().setRegionType(locatizationTool.process(regionType, locale));
			}
			
			if (deal.getCustomer().getAdditionalWorkingPlace() != null)	{
				BusinessLineType businessLineType = deal.getCustomer().getAdditionalWorkingPlace().getBusinessLineType();
				CompanySizeType companySizeType = deal.getCustomer().getAdditionalWorkingPlace().getCompanySizeType();
				OrganizationType organizationType = deal.getCustomer().getAdditionalWorkingPlace().getOrganizationType();
				
				if (businessLineType != null) deal.getCustomer().getAdditionalWorkingPlace().setBusinessLineType(locatizationTool.process(businessLineType, locale));
				if (organizationType != null) deal.getCustomer().getAdditionalWorkingPlace().setOrganizationType(locatizationTool.process(organizationType, locale));
				if (companySizeType != null) deal.getCustomer().getAdditionalWorkingPlace().setCompanySizeType(locatizationTool.process(companySizeType, locale));
			}
			
			if (deal.getCustomer().getPreviousWorkingPlace() != null)	{
				BusinessLineType businessLineType = deal.getCustomer().getPreviousWorkingPlace().getBusinessLineType();
				OrganizationType organizationType = deal.getCustomer().getPreviousWorkingPlace().getOrganizationType();
				
				if (businessLineType != null) deal.getCustomer().getPreviousWorkingPlace().setBusinessLineType(locatizationTool.process(businessLineType, locale));
				if (organizationType != null) deal.getCustomer().getPreviousWorkingPlace().setOrganizationType(locatizationTool.process(organizationType, locale));
			}			
			
			if (deal.getCustomer().getIncomeOutcome() != null)	{
				IncomeType mainIncomeType = deal.getCustomer().getIncomeOutcome().getMainIncomeType();
				IncomeType additionalIncomeType = deal.getCustomer().getIncomeOutcome().getAdditionalIncomeType();
				IncomeType spouseIncomeType = deal.getCustomer().getIncomeOutcome().getSpouseIncomeType();

				if (mainIncomeType != null) deal.getCustomer().getIncomeOutcome().setMainIncomeType(locatizationTool.process(mainIncomeType, locale));
				if (additionalIncomeType != null) deal.getCustomer().getIncomeOutcome().setAdditionalIncomeType(locatizationTool.process(additionalIncomeType, locale));
				if (spouseIncomeType != null) deal.getCustomer().getIncomeOutcome().setSpouseIncomeType(locatizationTool.process(spouseIncomeType, locale));
			}
			
			if (deal.getCustomer().getProperty() != null)	{
				PropertyHistoryType epPropertyHistoryType = deal.getCustomer().getProperty().getEpPropertyHistoryType();
				PropertyType epPropertyType = deal.getCustomer().getProperty().getEpPropertyType();
				PropertyType gaPropertyType = deal.getCustomer().getProperty().getGaPropertyType();

				if (epPropertyHistoryType != null) deal.getCustomer().getProperty().setEpPropertyHistoryType(locatizationTool.process(epPropertyHistoryType, locale));
				if (epPropertyType != null) deal.getCustomer().getProperty().setEpPropertyType(locatizationTool.process(epPropertyType, locale));
				if (gaPropertyType != null) deal.getCustomer().getProperty().setGaPropertyType(locatizationTool.process(gaPropertyType, locale));
			}
			
			if (deal.getCustomer().getCreditCard() != null)	{
				CreditFormType fCreditFormType = deal.getCustomer().getCreditCard().getFcCreditFormType();
				CreditFormType sCreditFormType = deal.getCustomer().getCreditCard().getScCreditFormType();
				CreditFormType tCreditFormType = deal.getCustomer().getCreditCard().getTcCreditFormType();
				
				if (fCreditFormType != null) deal.getCustomer().getCreditCard().setFcCreditFormType(locatizationTool.process(fCreditFormType, locale));
				if (sCreditFormType != null) deal.getCustomer().getCreditCard().setScCreditFormType(locatizationTool.process(sCreditFormType, locale));
				if (tCreditFormType != null) deal.getCustomer().getCreditCard().setTcCreditFormType(locatizationTool.process(tCreditFormType, locale));
			}
		}
		
		deal.setDealStateType(locatizationTool.processDealStateType(deal.getDealStateType(), locale));
		deal.setDealWorkflowSideType(locatizationTool.processDealWorkflowSideType(deal.getDealWorkflowSideType(), locale));
		deal.setDealWorkflowType(locatizationTool.processDealWorkflowType(deal.getDealWorkflowType(), locale));
		
		return deal;
	}

	@Override
	public String getDeals(DataTableHandler dataTableHandler, User currentUser, User userToGetDeals,
			Locale locale) throws UnsupportedEncodingException {

		List<Deal> deals = null;
		
		if (currentUser.getIsAdmin())	{
			deals = dealDAO.getDeals(dataTableHandler, null);
		} else {
			deals = dealDAO.getDeals(dataTableHandler, userToGetDeals);
		}
		
		String[][] aaData = new String[deals.size()][9];
		
		for (int i = 0; i < deals.size(); i++) {
			
			Deal deal = deals.get(i);
			Customer customer = deals.get(i).getCustomer();
			WorkingPlace workingPlace = null;
			
			if (customer!=null)	{
				workingPlace =  deals.get(i).getCustomer().getWorkingPlace();
			}
			
			Credit credit = deals.get(i).getCredit();
			
			aaData[i][0] = String.valueOf(deals.get(i).getId());
			
			if (customer != null)	{
				aaData[i][1] = String.valueOf(customer.getFullName());
			} else {
				aaData[i][1] = messageSource.getMessage("label.general.value.not.set", null, locale);
			}
			
			if (workingPlace != null)	{
				aaData[i][2] = String.valueOf(messageSource.getMessage(workingPlace.getJobType().getCode(), null, locale));
			} else {
				aaData[i][2] = messageSource.getMessage("label.general.value.not.set", null, locale);
			}
			
			if (credit != null)	{
				aaData[i][3] = String.valueOf(credit.getAmountOfMoney());
				aaData[i][4] = String.valueOf(credit.getTerm());
			}	else {
				aaData[i][3] = messageSource.getMessage("label.general.value.not.set", null, locale);
				aaData[i][4] = messageSource.getMessage("label.general.value.not.set", null, locale);
			}
			aaData[i][5] = String.valueOf(deal.getUser().getLastName() + " " + deal.getUser().getFirstName());
			aaData[i][6] = dateFormatter.format(deals.get(i).getCreationDate());
			aaData[i][7] = String.valueOf((locatizationTool.processDealWorkflowType(deal.getDealWorkflowType(), locale)).getDescription());
			if (currentUser.getIsAdmin() == true || deals.get(i).getUser().getUsername().equals(currentUser.getUsername()))	{
				aaData[i][8] = optionsColumnHandler.getDealsOptionsBlockOwner(
					deals.get(i), 
					"popup.deals.table.options.edit",
					"popup.deals.table.options.delete", 
					locale);
			} else {
				aaData[i][8] = optionsColumnHandler.getDealsOptionsBlockNotOwner(deals.get(i), "popup.deals.table.options.view", locale);
			}
		}

		dataTableHandler.setData(aaData);
		
		return dataTableHandler.getResponse();
	
	}

	@Override
	@Transactional
	public Deal getDeal(int id) {
		Deal deal = dealDAO.getDeal(id); 
		
		return deal;
	}

	@Override
	@Transactional
	public List<Deal> getMyActiveDeals(User user, Locale locale) {
		
		List<Deal> result = new ArrayList<Deal>(); 
		
		if (user.getIsCoordinator())	{
			List<Deal> coordinatorDeals = dealDAO.getCoordinatorActiveDeals(user);
			result.addAll(coordinatorDeals);
		}

		if (user.getIsOperator())	{
			List<Deal> operatorDeals = dealDAO.getOperatorActiveDeals(user);
			result.addAll(operatorDeals);
		}
		
		for (Deal d : result)	{
			d.getCustomer().getWorkingPlace().setJobType(locatizationTool.process(d.getCustomer().getWorkingPlace().getJobType(), locale));
			d.setDealWorkflowType(locatizationTool.processDealWorkflowType(d.getDealWorkflowType(), locale));
		}

		return result;
	}

}
