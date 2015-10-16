package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.ICustomerDAO;
import org.ekonopaka.crm.model.Customer;
import org.ekonopaka.crm.service.interfaces.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerDAO customerDAO;
	
	@Override
	public Customer getNewCustomer() {
		return new Customer();
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.deleteCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	public void copy(Customer pCustomer, Customer fCustomer) {
		pCustomer.setFirstName(fCustomer.getFirstName());
		pCustomer.setLastName(fCustomer.getLastName());
		pCustomer.setMiddleName(fCustomer.getMiddleName());
		pCustomer.setGenderType(fCustomer.getGenderType());
		pCustomer.setBirthDate(fCustomer.getBirthDate());
		pCustomer.setBirthPlace(fCustomer.getBirthPlace());
		pCustomer.setEducationType(fCustomer.getEducationType());
		pCustomer.setSpeciality(fCustomer.getSpeciality());
		pCustomer.setMilitaryServiceType(fCustomer.getMilitaryServiceType());
		pCustomer.setConvictionType(fCustomer.getConvictionType());
		pCustomer.setMotherLastName(fCustomer.getMotherLastName());
		pCustomer.setWasLastNameChanged(fCustomer.getWasLastNameChanged());
		pCustomer.setLastNameChangeDate(fCustomer.getLastNameChangeDate());
		pCustomer.setPreviousLastName(fCustomer.getPreviousLastName());
		pCustomer.setNumberOfAllChildren(fCustomer.getNumberOfAllChildren());
		pCustomer.setNumberOfYoungChildren(fCustomer.getNumberOfYoungChildren());
	}

}
