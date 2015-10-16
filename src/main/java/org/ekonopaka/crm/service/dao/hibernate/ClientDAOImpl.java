package org.ekonopaka.crm.service.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IClientDAO;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.DataTableRequest;
import org.ekonopaka.crm.model.Client;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAOImpl implements IClientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addClient(Client client) {
		client.setCreationDate(new Date());
		client.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(client);
	}

	@Override
	public void deleteClient(Client client) {
		client.setIsEnabled(false);
		hibernateTemplate.update(client);
	}

	@Override
	public List<Client> getClients(DataTableHandler tableHandler) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		DataTableRequest request = tableHandler.getDataTableRequest();

		String direction = request.getsSortDirection();
		int index = request.getiSortColumnIndex();
		int start = request.getiDisplayStart();
		int maxResult = request.getiDisplayLength();

		if (index == 0) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("id"));
			} else {
				criteria.addOrder(Order.desc("id"));
			}
		}

		if (index == 1) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("lastName"));
			} else {
				criteria.addOrder(Order.desc("lastName"));
			}
		}

		if (index == 2) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("firstName"));
			} else {
				criteria.addOrder(Order.desc("firstName"));
			}
		}

		if (index == 3) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("middleName"));
			} else {
				criteria.addOrder(Order.desc("middleName"));
			}
		}

		String query = request.getsSearch();

		int totalRecordsNumber = getNumberOfClients();
		tableHandler.setiTotalRecords(totalRecordsNumber);

		if (!query.equals("")) {
			query = "%" + query + "%";
			Criterion criterion = Restrictions.disjunction()
					.add(Restrictions.like("firstName", query))
					.add(Restrictions.like("lastName", query))
					.add(Restrictions.like("middleName", query));
			int totalDisplayRecordsNumber = getNumberOfClients(criterion);
			tableHandler.setiTotalDisplayRecords(totalDisplayRecordsNumber);
			criteria.add(criterion);
		} else {
			tableHandler.setiTotalDisplayRecords(totalRecordsNumber);
		}

		@SuppressWarnings("unchecked")
		List<Client> clients = hibernateTemplate.findByCriteria(criteria,
				start, maxResult);

		return clients;
	}

	@Override
	public Integer getNumberOfClients() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.setProjection(Projections.rowCount());
		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public Integer getNumberOfClients(Criterion criterion) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(criterion);
		criteria.setProjection(Projections.rowCount());
		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public Client getClient(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Client> clients = hibernateTemplate.findByCriteria(criteria);

		if (clients.size() > 0)	{
			return clients.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateClient(Client client) {
		client.setIsEnabled(true);
		hibernateTemplate.update(client);
	}

	@Override
	public List<Client> getClientsByNameAttrs(String[] nameAttrs) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		
		Disjunction criterion = Restrictions.disjunction();
		
		for (String attr : nameAttrs)	{
			attr = "%" + attr + "%";
			criterion.add(Restrictions.like("firstName", attr).ignoreCase())
			.add(Restrictions.like("lastName", attr).ignoreCase())
			.add(Restrictions.like("middleName", attr).ignoreCase());
		}
		
		criteria.add(criterion);
		criteria.add(Restrictions.eq("isEnabled", true));
		@SuppressWarnings("unchecked")
		List<Client> clients = hibernateTemplate.findByCriteria(criteria);
		return clients;
	}
	
}
