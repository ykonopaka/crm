package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IAddressDAO;
import org.ekonopaka.crm.model.Address;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements IAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public Address get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Address.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Address> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(Address address) {
		address.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(address);
	}

	@Override
	public void add(Address address) {
		address.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(address);
	}

	@Override
	public void delete(Address address) {
		address.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(address);
	}

}
