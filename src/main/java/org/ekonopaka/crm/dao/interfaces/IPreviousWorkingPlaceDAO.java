package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.PreviousWorkingPlace;

public interface IPreviousWorkingPlaceDAO {

	public PreviousWorkingPlace get(int id);

	public void update(PreviousWorkingPlace previousWorkingPlace);

	public void add(PreviousWorkingPlace previousWorkingPlace);

	public void delete(PreviousWorkingPlace previousWorkingPlace);
	
}
