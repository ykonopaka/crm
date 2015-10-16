package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.PositionType;

public class Positions {

	public static final String SPECIALIST = "label.specialist.position.type";
	public static final String MANAGER = "label.manager.position.type";
	public static final String TOP_MANAGER = "label.top.manager.position.type";
	
	public static final int SPECIALIST_ID = 1;
	public static final int MANAGER_ID = 2;
	public static final int TOP_MANAGER_ID = 3;
	
	public static List<PositionType> generate()	{
		List<PositionType> positionTypes = new ArrayList<PositionType>();
		positionTypes.add(new PositionType(SPECIALIST_ID, Positions.SPECIALIST, true));
		positionTypes.add(new PositionType(MANAGER_ID, Positions.MANAGER, true));
		positionTypes.add(new PositionType(TOP_MANAGER_ID, Positions.TOP_MANAGER, true));
		return positionTypes;
	}
}
