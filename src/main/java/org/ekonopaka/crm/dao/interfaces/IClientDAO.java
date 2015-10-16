package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.Client;
import org.hibernate.criterion.Criterion;

public interface IClientDAO {

	public void addClient(Client client);

	public void deleteClient(Client client);
	
	public void updateClient(Client client);

	public List<Client> getClients(DataTableHandler tableHandler);

	public Integer getNumberOfClients();

	public Integer getNumberOfClients(Criterion criterion);

	public Client getClient(int id);
	
	public List<Client> getClientsByNameAttrs(String[] nameAttrs);
	
}
