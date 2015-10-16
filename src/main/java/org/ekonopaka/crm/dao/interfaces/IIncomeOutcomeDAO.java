package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.IncomeOutcome;

public interface IIncomeOutcomeDAO {
	
	public IncomeOutcome get(int id);

	public void update(IncomeOutcome incomeOutcome);

	public void add(IncomeOutcome incomeOutcome);

	public void delete(IncomeOutcome incomeOutcome);

}
