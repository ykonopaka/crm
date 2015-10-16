package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICustomerPhoneSetDAO;
import org.ekonopaka.crm.model.CustomerPhoneSet;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerPhoneSetDAOImpl implements ICustomerPhoneSetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public CustomerPhoneSet getCustomerPhoneSet(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerPhoneSet.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<CustomerPhoneSet> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		customerPhoneSet.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(customerPhoneSet);
	}

	@Override
	public void addCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		customerPhoneSet.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(customerPhoneSet);

	}

	@Override
	public void deleteCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		customerPhoneSet.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(customerPhoneSet);
	}

}
