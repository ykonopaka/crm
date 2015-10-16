package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.AdditionalWorkingPlace;

public interface IAdditionalWorkingPlaceDAO {

	public AdditionalWorkingPlace get(int id);

	public void update(AdditionalWorkingPlace additionalWorkingPlace);

	public void add(AdditionalWorkingPlace additionalWorkingPlace);

	public void delete(AdditionalWorkingPlace additionalWorkingPlace);
	
}
