package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.ConvictionType;

public class Convictions {

	public static final String PRESENT = "label.presense.conviction.type";
	public static final String ABSENT = "label.absense.conviction.type";
	
	public static List<ConvictionType> generate()	{
		List<ConvictionType> convictionTypes = new ArrayList<ConvictionType>();
		convictionTypes.add(new ConvictionType(1, Convictions.PRESENT, true));
		convictionTypes.add(new ConvictionType(2, Convictions.ABSENT, true));
		return convictionTypes;
	}
}
