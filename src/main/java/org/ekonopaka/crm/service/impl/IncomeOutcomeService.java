package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IIncomeOutcomeDAO;
import org.ekonopaka.crm.model.IncomeOutcome;
import org.ekonopaka.crm.service.interfaces.IIncomeOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomeOutcomeService implements IIncomeOutcomeService {

	@Autowired
	IIncomeOutcomeDAO dao;
	
	@Override
	@Transactional
	public IncomeOutcome get(int id) {
		return dao.get(id);
	}

	@Override
	@Transactional
	public void update(IncomeOutcome incomeOutcome) {
		dao.update(incomeOutcome);

	}

	@Override
	@Transactional
	public void add(IncomeOutcome incomeOutcome) {
		dao.add(incomeOutcome);

	}

	@Override
	@Transactional
	public void delete(IncomeOutcome incomeOutcome) {
		dao.delete(incomeOutcome);

	}

	@Override
	public IncomeOutcome create() {
		IncomeOutcome incomeOutcome = new IncomeOutcome();
		incomeOutcome.setIsMarried(true);
		incomeOutcome.setIsAdditionalIncomePresent(true);
		
		return incomeOutcome;
	}

}
