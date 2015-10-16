package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IClientPhoneNumberDAO;
import org.ekonopaka.crm.model.Client;
import org.ekonopaka.crm.model.ClientPhoneNumber;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientPhoneNumberDAOImpl implements IClientPhoneNumberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addClientPhoneNumber(ClientPhoneNumber clientPhoneNumber) {
		sessionFactory.getCurrentSession().save(clientPhoneNumber);
	}

	@Override
	public void deleteClientPhoneNumber(ClientPhoneNumber clientPhoneNumber) {
		hibernateTemplate.delete(clientPhoneNumber);
	}

	@Override
	public void updateClientPhoneNumber(ClientPhoneNumber clientPhoneNumber) {
		hibernateTemplate.update(clientPhoneNumber);
	}

	@Override
	public ClientPhoneNumber getClientPhoneNumber(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientPhoneNumber.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<ClientPhoneNumber> clientPhoneNumbers = hibernateTemplate.findByCriteria(criteria);

		if (clientPhoneNumbers.size() > 0)	{
			return clientPhoneNumbers.get(0);
		}	else {
			return null;
		}
	}
	
	@Override
	public void assignClientPhoneNumber(ClientPhoneNumber clientPhoneNumber, Client client) {
		addClientPhoneNumber(clientPhoneNumber);
		//client.getClientPhoneNumbers().add(clientPhoneNumber);
	}

}
