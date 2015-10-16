package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IEmploymentTypeDAO;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.service.interfaces.IEmploymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmploymentTypeService implements IEmploymentTypeService {

	@Autowired
	private IEmploymentTypeDAO employmentTypeDAO;

	@Override
	@Transactional
	public void addEmploymentType(EmploymentType employmentType) {
		employmentTypeDAO.addEmploymentType(employmentType);
	}

	@Override
	@Transactional
	public void deleteEmploymentType(EmploymentType employmentType) {
		employmentTypeDAO.deleteEmploymentType(employmentType);
	}

	@Override
	@Transactional
	public List<EmploymentType> getEmploymentTypes() {
		return employmentTypeDAO.getEmploymentTypes();
	}

	@Override
	@Transactional
	public EmploymentType getEmploymentTypeById(int id) {
		return employmentTypeDAO.getEmploymentType(id);
	}

	@Override
	@Transactional
	public void updateEmploymentType(EmploymentType employmentType) {
		employmentTypeDAO.updateEmploymentType(employmentType);
	}

	@Override
	public EmploymentType getNewEmploymentType() {
		return new EmploymentType();
	}
}
