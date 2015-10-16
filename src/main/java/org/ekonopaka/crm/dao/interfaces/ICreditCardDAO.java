package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.CreditCard;

public interface ICreditCardDAO {

	public CreditCard get(int id);

	public void update(CreditCard creditCard);

	public void add(CreditCard creditCard);

	public void delete(CreditCard creditCard);
	
}
