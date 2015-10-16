package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IAddressDAO;
import org.ekonopaka.crm.model.Address;
import org.ekonopaka.crm.service.interfaces.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService implements IAddressService {

	@Autowired
	IAddressDAO addressDAO;
	
	@Override
	@Transactional
	public Address getAddress(int id) {
		return addressDAO.get(id);
	}

	@Override
	@Transactional
	public void updateAddress(Address address) {
		addressDAO.update(address);
	}

	@Override
	@Transactional
	public void addAddress(Address address) {
		addressDAO.add(address);
	}

	@Override
	@Transactional
	public void deleteAddress(Address address) {
		addressDAO.delete(address);
	}

	@Override
	public Address createNewAddress() {
		return new Address();
	}

}
