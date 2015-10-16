package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.Marriage;

public interface IMarriageDAO {

	public Marriage getMarriage(int id);

	public void updateMarriage(Marriage marriage);

	public void addMarriage(Marriage marriage);

	public void deleteMarriage(Marriage marriage);
	
}
