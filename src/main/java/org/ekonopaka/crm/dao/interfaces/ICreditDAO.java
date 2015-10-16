package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.types.CreditType;

public interface ICreditDAO {

	public void addCreditType(CreditType creditType);

	public void deleteCreditType(CreditType creditType);

	public void addCredit(Credit credit);

	public void deleteCredit(Credit credit);
	
	public void updateCredit(Credit credit);
	
	public List<CreditType> getCreditTypes();
	
	public Credit getCredit(int id);
}
