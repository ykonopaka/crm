package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.DealWorkflowSideType;

public class DealWorkflowSideTypes {

	public static final String OPERATOR_SIDE = "operator.workflow.side.type";
	public static final String COORDINATOR_SIDE = "coordinator.workflow.side.type";
	
	public static final int OPERATOR_SIDE_ID = 1;
	public static final int COORDINATOR_SIDE_ID = 2;
	
	public static List<DealWorkflowSideType> generate()	{
		List<DealWorkflowSideType> dealWorkflowSideTypes = new ArrayList<DealWorkflowSideType>();
		dealWorkflowSideTypes.add(new DealWorkflowSideType(OPERATOR_SIDE_ID, DealWorkflowSideTypes.OPERATOR_SIDE, true));
		dealWorkflowSideTypes.add(new DealWorkflowSideType(COORDINATOR_SIDE_ID, DealWorkflowSideTypes.COORDINATOR_SIDE, true));
		
		return dealWorkflowSideTypes;
	}
	
}
