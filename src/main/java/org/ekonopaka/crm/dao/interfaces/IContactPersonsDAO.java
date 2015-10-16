package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.ContactPersons;

public interface IContactPersonsDAO {

	public ContactPersons getContactPersons(int id);

	public void updateContactPersons(ContactPersons contactPersons);

	public void addContactPersons(ContactPersons contactPersons);

	public void deleteContactPersons(ContactPersons contactPersons);
}
