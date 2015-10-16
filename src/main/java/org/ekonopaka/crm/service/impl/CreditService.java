package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICreditDAO;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.types.CreditType;
import org.ekonopaka.crm.service.interfaces.ICreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditService implements ICreditService {

	@Autowired
	private ICreditDAO creditDAO;

	@Override
	@Transactional
	public void addCreditType(CreditType creditType) {
		creditDAO.addCreditType(creditType);
	}

	@Override
	@Transactional
	public void deleteCreditType(CreditType creditType) {
		creditDAO.deleteCreditType(creditType);
	}

	@Override
	@Transactional
	public void addCredit(Credit credit) {
		creditDAO.addCredit(credit);
	}

	@Override
	@Transactional
	public void deleteCredit(Credit credit) {
		creditDAO.deleteCredit(credit);
	}

	@Override
	public List<CreditType> getCreditTypes() {
		return creditDAO.getCreditTypes();
	}

	@Override
	@Transactional
	public Credit getCredit(int id) {
		return creditDAO.getCredit(id);
	}

	@Override
	@Transactional
	public void updateCredit(Credit credit) {
		creditDAO.updateCredit(credit);
	}

}
