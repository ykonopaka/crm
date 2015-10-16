package org.ekonopaka.crm.dao.interfaces;


import org.ekonopaka.crm.model.Customer;

public interface ICustomerDAO {

	public void addCustomer(Customer customer);

	public void deleteCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);

	public Customer getCustomer(int id);
	
}
