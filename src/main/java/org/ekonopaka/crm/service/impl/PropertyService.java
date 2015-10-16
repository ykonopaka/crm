package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IPropertyDAO;
import org.ekonopaka.crm.model.Property;
import org.ekonopaka.crm.service.interfaces.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropertyService implements IPropertyService {

	@Autowired
	IPropertyDAO dao;
	
	@Override
	@Transactional
	public Property get(int id) {
		return dao.get(id);
	}

	@Override
	@Transactional
	public void update(Property property) {
		dao.update(property);
	}

	@Override
	@Transactional
	public void add(Property property) {
		dao.add(property);
	}

	@Override
	@Transactional
	public void delete(Property property) {
		dao.delete(property);
	}

	@Override
	public Property create() {
		Property property = new Property();
		property.setIsCarPresent(true);
		property.setIsEPPresent(true);
		property.setIsGAPresent(true);
		return property;
	}

}
