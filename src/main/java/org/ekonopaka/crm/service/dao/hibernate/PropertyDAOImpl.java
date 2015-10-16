package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IPropertyDAO;
import org.ekonopaka.crm.model.Property;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyDAOImpl implements IPropertyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	
	@Override
	public Property get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Property.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Property> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(Property property) {
		property.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(property);

	}

	@Override
	public void add(Property property) {
		property.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(property);

	}

	@Override
	public void delete(Property property) {
		property.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(property);
	}
}
