package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.PreviousWorkingPlace;

public interface IPreviousWorkingPlaceService {

	public PreviousWorkingPlace get(int id);

	public void update(PreviousWorkingPlace previousWorkingPlace);

	public void add(PreviousWorkingPlace previousWorkingPlace);

	public void delete(PreviousWorkingPlace previousWorkingPlace);
	
	public PreviousWorkingPlace create();
	
}
