package org.ekonopaka.crm.dao.interfaces;

import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.ClientPhoneNumber;

public interface IClientPhoneNumberDAO {

	void addClientPhoneNumber(ClientPhoneNumber clientPhoneNumber);
	
	public void assignClientPhoneNumber(ClientPhoneNumber clientPhoneNumber, Client client);
	
	public void deleteClientPhoneNumber(ClientPhoneNumber clientPhoneNumber);

	public void updateClientPhoneNumber(ClientPhoneNumber clientPhoneNumber);
	
	public ClientPhoneNumber getClientPhoneNumber(int id);

}
