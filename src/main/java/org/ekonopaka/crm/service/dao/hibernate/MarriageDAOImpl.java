package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IMarriageDAO;
import org.ekonopaka.crm.model.Marriage;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MarriageDAOImpl implements IMarriageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public Marriage getMarriage(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Marriage.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Marriage> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateMarriage(Marriage marriage) {
		sessionFactory.getCurrentSession().update(marriage);
	}

	@Override
	public void addMarriage(Marriage marriage) {
		marriage.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(marriage);
	}

	@Override
	public void deleteMarriage(Marriage marriage) {
		marriage.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(marriage);
	}

}
