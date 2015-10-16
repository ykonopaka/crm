package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.PropertyHistoryType;

public class PropertyHistories {

	public static final String WAS_BOUGHT = "label.bought.history.type";
	public static final String PRIVATIZATION = "label.privatization.history.type";
	public static final String INHERITED = "label.inherited.history.type";
	public static final String SPOUSE_IS_OWNER = "label.spouse.history.type";
	public static final String PARENTS_ARE_OWNERS = "label.parents.history.type";
	public static final String RELATIVES_ARE_OWNERS = "label.relatives.history.type";
	
	public static List<PropertyHistoryType> generate()	{
		List<PropertyHistoryType> propertyHistoryTypes = new ArrayList<PropertyHistoryType>();
		propertyHistoryTypes.add(new PropertyHistoryType(1, PropertyHistories.WAS_BOUGHT, true));
		propertyHistoryTypes.add(new PropertyHistoryType(2, PropertyHistories.PRIVATIZATION, true));
		propertyHistoryTypes.add(new PropertyHistoryType(3, PropertyHistories.INHERITED, true));
		propertyHistoryTypes.add(new PropertyHistoryType(4, PropertyHistories.SPOUSE_IS_OWNER, true));
		propertyHistoryTypes.add(new PropertyHistoryType(5, PropertyHistories.PARENTS_ARE_OWNERS, true));
		propertyHistoryTypes.add(new PropertyHistoryType(6, PropertyHistories.RELATIVES_ARE_OWNERS, true));
		return propertyHistoryTypes;
	}
	
}
