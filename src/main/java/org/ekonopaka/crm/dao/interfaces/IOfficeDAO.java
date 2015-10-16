package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.User;

public interface IOfficeDAO {

	public List<Office> getOffices();

	public Office getOffice(int id);

	public void updateOffice(Office office);

	public Office getUserOffice(User user);

	public void addOffice(Office office);

	public void deleteOffice(Office office);

}
