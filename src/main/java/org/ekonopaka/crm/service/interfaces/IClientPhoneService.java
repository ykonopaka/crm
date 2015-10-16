package org.ekonopaka.crm.service.interfaces;

import org.ekonopaka.crm.model.ClientPhoneNumber;

public interface IClientPhoneService {

	public void addClientPhoneNumber(ClientPhoneNumber number);

	public void deletePhoneNumberFromClient(ClientPhoneNumber number);
	
	public void updateClientPhoneNumber(ClientPhoneNumber number);

	public ClientPhoneNumber getClientPhoneNumber(int id);
}
