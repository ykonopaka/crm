package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IClientPhoneNumberDAO;
import org.ekonopaka.crm.model.ClientPhoneNumber;
import org.ekonopaka.crm.service.interfaces.IClientPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientPhoneService implements IClientPhoneService {

	@Autowired
	private IClientPhoneNumberDAO clientPhoneNumberDAO;

	@Override
	@Transactional
	public void addClientPhoneNumber(ClientPhoneNumber number) {
		clientPhoneNumberDAO.addClientPhoneNumber(number);
	}

	@Override
	@Transactional
	public void deletePhoneNumberFromClient(ClientPhoneNumber number) {
		clientPhoneNumberDAO.deleteClientPhoneNumber(number);
	}

	@Override
	@Transactional
	public void updateClientPhoneNumber(ClientPhoneNumber number) {
		clientPhoneNumberDAO.updateClientPhoneNumber(number);
	}

	@Override
	@Transactional
	public ClientPhoneNumber getClientPhoneNumber(int id) {
		return clientPhoneNumberDAO.getClientPhoneNumber(id);
	}

	
}
