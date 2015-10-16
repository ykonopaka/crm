package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.CreditObjectiveType;

public class CreditObjectives {

	public static final String HOUSE_RENOVATION = "label.house.renovation.credit.objective.type"; 
	public static final String FURNITURE = "label.buying.furniture.credit.objective.type";
	public static final String TECHNIQUE = "label.buying.technique.credit.objective.type";
	public static final String REST = "label.rest.credit.objective.type";
	
	public static List<CreditObjectiveType> generate()	{
		List<CreditObjectiveType> creditObjectiveTypes = new ArrayList<CreditObjectiveType>();
		creditObjectiveTypes.add(new CreditObjectiveType(1, CreditObjectives.HOUSE_RENOVATION, true));
		creditObjectiveTypes.add(new CreditObjectiveType(2, CreditObjectives.FURNITURE, true));
		creditObjectiveTypes.add(new CreditObjectiveType(3, CreditObjectives.TECHNIQUE, true));
		creditObjectiveTypes.add(new CreditObjectiveType(4, CreditObjectives.REST, true));
		return creditObjectiveTypes;
	}
}
