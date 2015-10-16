package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IContactPersonsDAO;
import org.ekonopaka.crm.model.ContactPersons;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactPersonsDAOImpl implements IContactPersonsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public ContactPersons getContactPersons(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ContactPersons.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<ContactPersons> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateContactPersons(ContactPersons contactPersons) {
		contactPersons.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(contactPersons);

	}

	@Override
	public void addContactPersons(ContactPersons contactPersons) {
		contactPersons.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(contactPersons);

	}

	@Override
	public void deleteContactPersons(ContactPersons contactPersons) {
		contactPersons.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(contactPersons);
	}

}
