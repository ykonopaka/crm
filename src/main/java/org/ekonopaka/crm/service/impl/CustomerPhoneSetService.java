package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.ICustomerPhoneSetDAO;
import org.ekonopaka.crm.model.CustomerPhoneSet;
import org.ekonopaka.crm.service.interfaces.ICustomerPhoneSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerPhoneSetService implements ICustomerPhoneSetService {

	@Autowired
	ICustomerPhoneSetDAO customerPhoneSetDAO;
	
	@Override
	@Transactional
	public CustomerPhoneSet getCustomerPhoneSet(int id) {
		return customerPhoneSetDAO.getCustomerPhoneSet(id);
	}

	@Override
	@Transactional
	public void updateCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		customerPhoneSetDAO.updateCustomerPhoneSet(customerPhoneSet);
		
	}

	@Override
	@Transactional
	public void addCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		customerPhoneSetDAO.addCustomerPhoneSet(customerPhoneSet);
		
	}

	@Override
	@Transactional
	public void deleteCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		customerPhoneSetDAO.deleteCustomerPhoneSet(customerPhoneSet);
		
	}

	@Override
	public CustomerPhoneSet createNewCustomerPhoneSet() {
		return new CustomerPhoneSet();
	}

	

}
