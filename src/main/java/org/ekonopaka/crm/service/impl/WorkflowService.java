package org.ekonopaka.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.actions.Action;
import org.ekonopaka.crm.actions.ApproveAction;
import org.ekonopaka.crm.actions.CloseAction;
import org.ekonopaka.crm.actions.RejectAction;
import org.ekonopaka.crm.actions.ReviewAction;
import org.ekonopaka.crm.actions.ReworkAction;
import org.ekonopaka.crm.actions.SignAction;
import org.ekonopaka.crm.actions.UnsignAction;
import org.ekonopaka.crm.constants.DealStates;
import org.ekonopaka.crm.constants.DealWorkflowSideTypes;
import org.ekonopaka.crm.constants.DealWorkflowStates;
import org.ekonopaka.crm.dao.interfaces.IWorkflowDAO;
import org.ekonopaka.crm.handlers.LocatizationTool;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;
import org.ekonopaka.crm.service.interfaces.IDealService;
import org.ekonopaka.crm.service.interfaces.IWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowService implements IWorkflowService {

	@Autowired
	IWorkflowDAO workflowDAO;
	
	@Autowired
	IDealService dealService;
	
	@Autowired
	LocatizationTool locatizationTool;
	
	@Override
	public List<Action> getAvailableActions(Deal deal, User user, Locale locale) {
		
		List<Action> actions = new ArrayList<Action>();
		
		boolean isOwner = false;
		
		boolean isCoordinator = false;
		
		if (deal.getUser().getId().equals(user.getId()))	{
			isOwner = true;
		}
		
		if (user.getIsCoordinator())	{
			isCoordinator = true;
		}

		
		if ((deal.getDealWorkflowType().getId()==DealWorkflowStates.OPERATOR_CREATE_ID) && isOwner )	{
			Action review = new ReviewAction(deal); 
			actions.add(review);
		}
		
		if (deal.getDealWorkflowType().getId()==DealWorkflowStates.COORDINATOR_REVIEW_ID && isCoordinator)	{
			Action approve = new ApproveAction(deal);
			Action reject = new RejectAction(deal); 
			Action rework = new ReworkAction(deal); 
			actions.add(approve);
			actions.add(reject);
			actions.add(rework);
		}

		if (deal.getDealWorkflowType().getId()==DealWorkflowStates.COORDINATOR_REJECTED_ID && deal.getDealStateType().getId() == DealStates.IN_PROGRESS_ID && isOwner)	{
			Action close = new CloseAction(deal); 
			actions.add(close);
		}
		
		if (deal.getDealWorkflowType().getId()==DealWorkflowStates.COORDINATOR_APPROVED_ID && isOwner)	{
			Action sign = new SignAction(deal); 
			Action unsign = new UnsignAction(deal); 
			actions.add(sign);
			actions.add(unsign);
		}
		
		if (deal.getDealWorkflowType().getId()==DealWorkflowStates.OPERATOR_DOCUMENTS_SIGNED_ID && deal.getDealStateType().getId() == DealStates.IN_PROGRESS_ID && isOwner)	{
			Action close = new CloseAction(deal); 
			actions.add(close);
		}
		
		if (deal.getDealWorkflowType().getId()==DealWorkflowStates.OPERATOR_DOCUMENTS_UNSIGNED_ID && deal.getDealStateType().getId() == DealStates.IN_PROGRESS_ID && isOwner)	{
			Action close = new CloseAction(deal); 
			actions.add(close);
		}
		
		if (deal.getDealWorkflowType().getId()==DealWorkflowStates.COORDINATOR_REWORK_ID && isOwner)	{
			Action review = new ReviewAction(deal); 
			actions.add(review);
		}
		
		actions = locatizationTool.processActions(actions, locale);
		
		return actions;
	}

	@Override
	public void review(Deal deal) {
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.IN_PROGRESS_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.COORDINATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.COORDINATOR_REVIEW_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
	}

	@Override
	public void reject(Deal deal) {
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.IN_PROGRESS_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.COORDINATOR_REJECTED_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
	}

	@Override
	public void approve(Deal deal) {
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.IN_PROGRESS_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.COORDINATOR_APPROVED_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
	}

	@Override
	public void sign(Deal deal) {
		//DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.CLOSED_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.OPERATOR_DOCUMENTS_SIGNED_ID);
		
		//deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
		
	}

	@Override
	public void unsign(Deal deal) {
		//DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.CLOSED_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.OPERATOR_DOCUMENTS_UNSIGNED_ID);
		
		//deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
		
	}

	@Override
	public void reopen(Deal deal) {
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.IN_PROGRESS_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.COORDINATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.COORDINATOR_REVIEW_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
	}

	@Override
	public void close(Deal deal) {
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.CLOSED_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		//DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.OPERATOR_FINISHED_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		//deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
	}

	@Override
	public void rework(Deal deal) {
		DealStateType dealStateType = workflowDAO.getDealStateType(DealStates.IN_PROGRESS_ID);
		DealWorkflowSideType dealWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		DealWorkflowType dealWorkflowType = workflowDAO.getDealWorkflowType(DealWorkflowStates.COORDINATOR_REWORK_ID);
		
		deal.setDealStateType(dealStateType);
		deal.setDealWorkflowSideType(dealWorkflowSideType);
		deal.setDealWorkflowType(dealWorkflowType);
		
		dealService.updateDeal(deal);
		
	}

}
