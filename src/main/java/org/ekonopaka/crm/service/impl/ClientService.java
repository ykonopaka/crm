package org.ekonopaka.crm.service.impl;

import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.dao.interfaces.IClientDAO;
import org.ekonopaka.crm.dao.interfaces.IClientPhoneNumberDAO;
import org.ekonopaka.crm.handlers.DateFormatter;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.OptionsColumnHandler;
import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.service.interfaces.IClientPhoneService;
import org.ekonopaka.crm.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService implements IClientService {

	@Autowired
	private IClientDAO clientDAO;

	@Autowired
	private IClientPhoneNumberDAO clientPhoneNumberDAO;

	@Autowired
	OptionsColumnHandler optionsColumnHandler;
	
	@Autowired
	IClientPhoneService clientPhoneService;
	
	@Autowired
	DateFormatter dateFormatter;
	
	@Override
	@Transactional
	public void addClient(Client client) {
		
		// Save base entity
		clientDAO.addClient(client);
		
	}

	@Override
	@Transactional
	public void deleteClient(Client client) {
		clientDAO.deleteClient(client);
	}

	@Override
	public String getClients(DataTableHandler dataTableHandler, Locale locale, boolean isAdmin) {
		List<Client> clients = clientDAO.getClients(dataTableHandler);
		String[][] aaData = new String[clients.size()][6];

		for (int i = 0; i < clients.size(); i++) {
			aaData[i][0] = String.valueOf(clients.get(i).getId());
			aaData[i][1] = String.valueOf(clients.get(i).getLastName());
			aaData[i][2] = String.valueOf(clients.get(i).getFirstName());
			aaData[i][3] = String.valueOf(clients.get(i).getMiddleName());
			aaData[i][4] = dateFormatter.format(clients.get(i).getCreationDate());
			
			if (isAdmin)	{
				aaData[i][5] = optionsColumnHandler.getClientsOptionsBlockAdmin(clients.get(i),
						"popup.clients.table.options.view",
						"popup.clients.table.options.edit",
						"popup.clients.table.options.delete",
						"popup.clients.table.options.create.call",
						locale);
			} else {
				aaData[i][5] = optionsColumnHandler.getClientsOptionsBlockOperator(clients.get(i), 
						"popup.clients.table.options.view", 
						"popup.clients.table.options.create.call", 
						locale);
			}
		}

		dataTableHandler.setData(aaData);

		return dataTableHandler.getResponse();
	}

	@Override
	@Transactional
	public Client getClientById(int id) {
		return clientDAO.getClient(id);
	}

	@Override
	public List<Client> searchClientsByName(String search) {
		search = search.trim();
		String[] nameAttrs = search.split("\\s");
		
		return clientDAO.getClientsByNameAttrs(nameAttrs);
	}

	@Override
	public void updateClient(Client client) {
		clientDAO.updateClient(client);
}

	@Override
	public Client getNewClient(boolean hasPhoneNumbers) {
		Client client = new Client();
		
		return client;
	}

}
