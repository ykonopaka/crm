package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.CustomerPhoneSet;

public interface ICustomerPhoneSetDAO {

	public CustomerPhoneSet getCustomerPhoneSet(int id);

	public void updateCustomerPhoneSet(CustomerPhoneSet customerPhoneSet);

	public void addCustomerPhoneSet(CustomerPhoneSet customerPhoneSet);

	public void deleteCustomerPhoneSet(CustomerPhoneSet customerPhoneSet);
	
}
