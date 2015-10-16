package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.Customer;

public interface ICustomerService {
	
	public Customer getNewCustomer();

	public void addCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public void copy(Customer pCustomer, Customer fCustomer);
	
}
