package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.ICreditCardDAO;
import org.ekonopaka.crm.model.CreditCard;
import org.ekonopaka.crm.service.interfaces.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditCardService implements ICreditCardService {

	@Autowired
	ICreditCardDAO creditCardDAO;
	
	@Override
	@Transactional
	public CreditCard get(int id) {
		return creditCardDAO.get(id);
	}

	@Override
	@Transactional
	public void update(CreditCard creditCard) {
		creditCardDAO.update(creditCard);
	}

	@Override
	@Transactional
	public void add(CreditCard creditCard) {
		creditCardDAO.add(creditCard);
	}

	@Override
	@Transactional
	public void delete(CreditCard creditCard) {
		creditCardDAO.delete(creditCard);
	}

	@Override
	public CreditCard create() {
		CreditCard result = new CreditCard();
		result.setFccIsExisted(false);
		result.setSccIsExisted(false);
		result.setTccIsExisted(false);
		result.setFcIsExisted(true);
		result.setScIsExisted(false);
		result.setTcIsExisted(false);

		return result;
	}

}
