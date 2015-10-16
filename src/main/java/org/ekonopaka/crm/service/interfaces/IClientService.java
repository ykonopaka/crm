package org.ekonopaka.crm.service.interfaces;

import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.Client;

public interface IClientService {
	
	public Client getNewClient(boolean hasPhoneNumbers);

	public void addClient(Client client);

	public void deleteClient(Client client);

	public Client getClientById(int id);

	public String getClients(DataTableHandler dataTableHandler, Locale locale, boolean isAdmin);
	
	public List<Client> searchClientsByName(String search);
	
	public void updateClient(Client client);
	
}
