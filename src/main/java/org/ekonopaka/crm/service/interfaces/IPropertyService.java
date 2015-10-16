package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.Property;

public interface IPropertyService {

	public Property get(int id);

	public void update(Property property);

	public void add(Property property);

	public void delete(Property property);
	
	public Property create();
	
}
