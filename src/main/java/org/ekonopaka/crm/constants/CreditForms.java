package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.CreditFormType;

public class CreditForms {

	public static final String MORTGAGE = "label.mortgage.credit.form.type"; 
	public static final String CAR = "label.car.credit.form.type";
	public static final String CONSUMER_CREDIT = "label.consumer.credit.form.type";
	public static final String SECURITIES_LOAN = "label.securities.loan.credit.form.type";
	public static final String GOOD_CREDIT = "label.goods.credit.form.type";
	public static final String OTHER = "label.other.credit.form.type";
	
	public static List<CreditFormType> generate()	{
		List<CreditFormType> types = new ArrayList<CreditFormType>();
		types.add(new CreditFormType(1, CreditForms.MORTGAGE, true));
		types.add(new CreditFormType(2, CreditForms.CAR, true));
		types.add(new CreditFormType(3, CreditForms.CONSUMER_CREDIT, true));
		types.add(new CreditFormType(4, CreditForms.SECURITIES_LOAN, true));
		types.add(new CreditFormType(5, CreditForms.GOOD_CREDIT, true));
		types.add(new CreditFormType(6, CreditForms.OTHER, true));
		return types;
	}
	
}
