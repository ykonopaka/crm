package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.Property;

public interface IPropertyDAO {

	public Property get(int id);

	public void update(Property property);

	public void add(Property property);

	public void delete(Property property);
	
}
