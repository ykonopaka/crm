package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.ContactPersons;

public interface IContactPersonService {
	
	public ContactPersons getContactPersons(int id);

	public void updateContactPersons(ContactPersons contactPersons);

	public void addContactPersons(ContactPersons contactPersons);

	public void deleteContactPersons(ContactPersons contactPersons);
	
	public ContactPersons createNewContactPersons();
	
}
