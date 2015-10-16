package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.WorkingPlace;

public interface IWorkingPlaceDAO {

	public WorkingPlace get(int id);

	public void update(WorkingPlace workingPlace);

	public void add(WorkingPlace workingPlace);

	public void delete(WorkingPlace workingPlace);
	
}
