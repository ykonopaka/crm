package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.IncomeOutcome;

public interface IIncomeOutcomeService {

	public IncomeOutcome get(int id);

	public void update(IncomeOutcome incomeOutcome);

	public void add(IncomeOutcome incomeOutcome);

	public void delete(IncomeOutcome incomeOutcome);
	
	public IncomeOutcome create();
	
}
