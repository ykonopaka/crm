package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.CreditType;

public class Credits {

	public static final String PLEDGE = "label.plegde.credit.type";
	public static final String NON_PLEDGE_WITH_RR = "label.non.pledge.with.revenue.report";
	public static final String NON_PLEDGE_WITHOUT_RR = "label.non.pledge.without.revenue.report";
	
	public static List<CreditType> generate()	{
		List<CreditType> creditTypes = new ArrayList<CreditType>();
		creditTypes.add(new CreditType(1, Credits.PLEDGE, true));
		creditTypes.add(new CreditType(2, Credits.NON_PLEDGE_WITH_RR, true));
		creditTypes.add(new CreditType(3, Credits.NON_PLEDGE_WITHOUT_RR, true));
		return creditTypes;
	}
}
