package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.AdditionalWorkingPlace;

public interface IAdditionalWorkingPlaceService {

	public AdditionalWorkingPlace get(int id);

	public void update(AdditionalWorkingPlace additionalWorkingPlace);

	public void add(AdditionalWorkingPlace additionalWorkingPlace);

	public void delete(AdditionalWorkingPlace additionalWorkingPlace);
	
	public AdditionalWorkingPlace create();
	
}
