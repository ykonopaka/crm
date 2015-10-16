package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.MaritalStatusType;

public class MaritalStatuses {

	public static final String MARRIED = "label.married.marital.status.type";
	public static final String CIVIL = "label.civil.married.marital.status.type";
	public static final String NON_MARRIED = "label.non.married.marital.status.type";
	public static final String DIVORCED = "label.divorced.marital.status.type";
	public static final String WIDOW = "label.widow.marital.status.type";
	
	public static final int MARRIED_ID = 1;
	public static final int CIVIL_ID = 2;
	public static final int NON_MARRIED_ID = 3;
	public static final int DIVORCED_ID = 4;
	public static final int WIDOW_ID = 5;

	public static List<MaritalStatusType> generate()	{
		List<MaritalStatusType> maritalStatusTypes = new ArrayList<MaritalStatusType>();
		maritalStatusTypes.add(new MaritalStatusType(MARRIED_ID, MaritalStatuses.MARRIED, true, true));
		maritalStatusTypes.add(new MaritalStatusType(CIVIL_ID, MaritalStatuses.CIVIL, true, true));
		maritalStatusTypes.add(new MaritalStatusType(NON_MARRIED_ID, MaritalStatuses.NON_MARRIED, true, false));
		maritalStatusTypes.add(new MaritalStatusType(DIVORCED_ID, MaritalStatuses.DIVORCED, true, false));
		maritalStatusTypes.add(new MaritalStatusType(WIDOW_ID, MaritalStatuses.WIDOW, true, false));
		
		return maritalStatusTypes;
	}
}
