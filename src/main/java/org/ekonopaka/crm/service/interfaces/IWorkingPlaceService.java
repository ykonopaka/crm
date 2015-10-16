package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.WorkingPlace;

public interface IWorkingPlaceService {

	public WorkingPlace get(int id);

	public void update(WorkingPlace workingPlace);

	public void add(WorkingPlace workingPlace);

	public void delete(WorkingPlace workingPlace);
	
	public WorkingPlace create();
	
}
