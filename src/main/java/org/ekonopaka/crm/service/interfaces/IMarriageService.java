package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.Marriage;

public interface IMarriageService {

	public Marriage getMarriage(int id);

	public void updateMarriage(Marriage marriage);

	public void addMarriage(Marriage marriage);

	public void deleteMarriage(Marriage marriage);
	
	public Marriage createNewMarriage();
	
}
