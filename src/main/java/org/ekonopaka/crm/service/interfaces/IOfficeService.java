package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.User;

public interface IOfficeService {
	
	public Office getNewOffice();
	
	public List<Office> getOffices();

	public Office getOfficeById(int id);

	public void updateOffice(Office office);

	public Office getUserOffice(User user);

	public void addOffice(Office office);

	public void deleteOffice(Office office);

}
