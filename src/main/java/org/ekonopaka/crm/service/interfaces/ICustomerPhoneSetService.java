package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.CustomerPhoneSet;

public interface ICustomerPhoneSetService {

	public CustomerPhoneSet getCustomerPhoneSet(int id);

	public void updateCustomerPhoneSet(CustomerPhoneSet customerPhoneSet);

	public void addCustomerPhoneSet(CustomerPhoneSet customerPhoneSet);

	public void deleteCustomerPhoneSet(CustomerPhoneSet customerPhoneSet);
	
	public CustomerPhoneSet createNewCustomerPhoneSet();
}
