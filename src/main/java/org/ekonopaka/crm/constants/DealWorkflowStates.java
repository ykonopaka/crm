package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.DealWorkflowType;

public class DealWorkflowStates {

	public static final String OPERATOR_CREATE = "operator.create.deal.workflow.state.type";
	public static final String COORDINATOR_REVIEW = "coordinator.review.deal.workflow.state.type";
	public static final String COORDINATOR_REJECTED = "coordinator.rejected.deal.workflow.state.type";
	public static final String COORDINATOR_APPROVED = "coordinator.approved.deal.workflow.state.type";
	public static final String OPERATOR_DOCUMENTS_SIGNED = "operator.documents.signed.deal.workflow.state.type";
	public static final String OPERATOR_DOCUMENTS_UNSIGNED = "operator.documents.unsigned.deal.workflow.state.type";
	public static final String COORDINATOR_REWORK = "coordinator.rework.deal.workflow.state.type";
	public static final String OPERATOR_FINISHED = "operator.finished.deal.workflow.state.type";
	
	public static final int OPERATOR_CREATE_ID = 1;
	public static final int COORDINATOR_REVIEW_ID = 2;
	public static final int COORDINATOR_REJECTED_ID = 3;
	public static final int COORDINATOR_APPROVED_ID = 4;
	public static final int OPERATOR_DOCUMENTS_SIGNED_ID = 5;
	public static final int OPERATOR_DOCUMENTS_UNSIGNED_ID = 6;
	public static final int COORDINATOR_REWORK_ID = 7;
	public static final int OPERATOR_FINISHED_ID = 8;
	
	public static List<DealWorkflowType> generate()	{
		List<DealWorkflowType> dealWorkflowTypes = new ArrayList<DealWorkflowType>();
		dealWorkflowTypes.add(new DealWorkflowType(OPERATOR_CREATE_ID, DealWorkflowStates.OPERATOR_CREATE, true));
		dealWorkflowTypes.add(new DealWorkflowType(COORDINATOR_REVIEW_ID, DealWorkflowStates.COORDINATOR_REVIEW, true));
		dealWorkflowTypes.add(new DealWorkflowType(COORDINATOR_REJECTED_ID, DealWorkflowStates.COORDINATOR_REJECTED, true));
		dealWorkflowTypes.add(new DealWorkflowType(COORDINATOR_APPROVED_ID, DealWorkflowStates.COORDINATOR_APPROVED, true));
		dealWorkflowTypes.add(new DealWorkflowType(OPERATOR_DOCUMENTS_SIGNED_ID, DealWorkflowStates.OPERATOR_DOCUMENTS_SIGNED, true));
		dealWorkflowTypes.add(new DealWorkflowType(OPERATOR_DOCUMENTS_UNSIGNED_ID, DealWorkflowStates.OPERATOR_DOCUMENTS_UNSIGNED, true));
		dealWorkflowTypes.add(new DealWorkflowType(COORDINATOR_REWORK_ID, DealWorkflowStates.COORDINATOR_REWORK, true));
		dealWorkflowTypes.add(new DealWorkflowType(OPERATOR_FINISHED_ID, DealWorkflowStates.OPERATOR_FINISHED, true));
		
		return dealWorkflowTypes;
	}

}
