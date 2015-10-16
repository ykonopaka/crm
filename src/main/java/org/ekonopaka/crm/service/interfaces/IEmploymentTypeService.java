package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.types.EmploymentType;

public interface IEmploymentTypeService {

	public EmploymentType getNewEmploymentType();
	
	public void addEmploymentType(EmploymentType employmentType);

	public void deleteEmploymentType(EmploymentType employmentType);

	public List<EmploymentType> getEmploymentTypes();

	public EmploymentType getEmploymentTypeById(int id);

	public void updateEmploymentType(EmploymentType employmentType);

}
