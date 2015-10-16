package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IContactPersonsDAO;
import org.ekonopaka.crm.model.ContactPersons;
import org.ekonopaka.crm.service.interfaces.IContactPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactPersonsService implements IContactPersonService {

	@Autowired
	IContactPersonsDAO contactPersonsDAO;
	
	@Override
	@Transactional
	public ContactPersons getContactPersons(int id) {
		return contactPersonsDAO.getContactPersons(id);
	}

	@Override
	@Transactional
	public void updateContactPersons(ContactPersons contactPersons) {
		contactPersonsDAO.updateContactPersons(contactPersons);
	}

	@Override
	@Transactional
	public void addContactPersons(ContactPersons contactPersons) {
		contactPersonsDAO.addContactPersons(contactPersons);
	}

	@Override
	@Transactional
	public void deleteContactPersons(ContactPersons contactPersons) {
		contactPersonsDAO.deleteContactPersons(contactPersons);
	}

	@Override
	public ContactPersons createNewContactPersons() {
		return new ContactPersons();
	}

}
