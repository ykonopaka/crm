package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.types.EmploymentType;

public interface IEmploymentTypeDAO {

	public void addEmploymentType(EmploymentType employmentType);

	public void deleteEmploymentType(EmploymentType employmentType);

	public List<EmploymentType> getEmploymentTypes();

	public EmploymentType getEmploymentType(int id);

	public void updateEmploymentType(EmploymentType employmentType);

}
