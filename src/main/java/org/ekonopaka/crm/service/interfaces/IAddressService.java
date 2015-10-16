package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.Address;

public interface IAddressService {

	public Address getAddress(int id);

	public void updateAddress(Address address);

	public void addAddress(Address address);

	public void deleteAddress(Address address);
	
	public Address createNewAddress();
	

}
