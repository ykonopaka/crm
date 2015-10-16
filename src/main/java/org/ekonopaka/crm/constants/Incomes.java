package org.ekonopaka.crm.constants;

import java.util.ArrayList;
import java.util.List;

import org.ekonopaka.crm.model.types.IncomeType;

public class Incomes {

	public static final String OUNP = "label.ounp.income.type"; 
	public static final String NOUNP = "label.nounp.income.type";
	public static final String NP = "label.np.income.type";
	public static final String LEASING = "label.leasing.income.type";
	public static final String OFFICIAL_INCOME = "label.official.income.income.type";
	public static final String OFFICIAL_SALARY = "label.official.salary.income.type";
	
	public static List<IncomeType> generate()	{
		List<IncomeType> incomeTypes = new ArrayList<IncomeType>();
		incomeTypes.add(new IncomeType(1, Incomes.OUNP, true, true, true, true));
		incomeTypes.add(new IncomeType(2, Incomes.NOUNP, true, true, true, true));
		incomeTypes.add(new IncomeType(3, Incomes.NP, true, true, true, true));
		incomeTypes.add(new IncomeType(4, Incomes.LEASING, true, true, true, true));
		incomeTypes.add(new IncomeType(5, Incomes.OFFICIAL_INCOME, true, false, true, false));
		incomeTypes.add(new IncomeType(6, Incomes.OFFICIAL_SALARY, true, true, false, false));
		
		return incomeTypes;
	}
}
