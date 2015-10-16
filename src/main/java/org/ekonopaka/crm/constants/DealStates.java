package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.DealStateType;

public class DealStates {

	public static final String NEW = "new.deal.state.type";
	public static final String CLOSED = "closed.deal.state.type";
	public static final String IN_PROGRESS = "in.progress.deal.state.type";
	
	public static final int NEW_ID = 1;
	public static final int IN_PROGRESS_ID = 2;	
	public static final int CLOSED_ID = 3;
	
	public static List<DealStateType> generate()	{
		List<DealStateType> dealStateTypes = new ArrayList<DealStateType>();
		dealStateTypes.add(new DealStateType(NEW_ID, DealStates.NEW, true));
		dealStateTypes.add(new DealStateType(IN_PROGRESS_ID, DealStates.IN_PROGRESS, true));
		dealStateTypes.add(new DealStateType(CLOSED_ID, DealStates.CLOSED, true));
		return dealStateTypes;
	}
}
