package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.Address;

public interface IAddressDAO {
	
	public Address get(int id);

	public void update(Address address);

	public void add(Address address);

	public void delete(Address address);


}
