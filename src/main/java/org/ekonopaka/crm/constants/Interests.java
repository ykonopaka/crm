package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.InterestType;

public class Interests {
	public static final String INTERESTED = "label.interested.interest.type";
	public static final String BETWEEN_INT_NOTINT = "label.between.interest.type";
	public static final String NOT_INTERESTED = "label.not.interested.interest.type";
	
	public static List<InterestType> generate()	{
		List<InterestType> interestTypes = new ArrayList<InterestType>();
		interestTypes.add(new InterestType(1, Interests.INTERESTED, true));
		interestTypes.add(new InterestType(2, Interests.BETWEEN_INT_NOTINT, true));
		interestTypes.add(new InterestType(3, Interests.NOT_INTERESTED, true));
		return interestTypes;
	}
}
