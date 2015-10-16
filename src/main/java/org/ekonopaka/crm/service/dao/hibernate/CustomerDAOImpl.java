package org.ekonopaka.crm.service.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICustomerDAO;
import org.ekonopaka.crm.model.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void addCustomer(Customer customer) {
		customer.setCreationDate(new Date());
		customer.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(customer);
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customer.setIsEnabled(false);
		hibernateTemplate.update(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customer.setIsEnabled(true);
		hibernateTemplate.update(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Customer> customers = hibernateTemplate.findByCriteria(criteria);

		if (customers.size() > 0)	{
			return customers.get(0);
		}	else {
			return null;
		}
	}


}
