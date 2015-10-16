package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IPreviousWorkingPlaceDAO;
import org.ekonopaka.crm.model.PreviousWorkingPlace;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PreviousWorkingPlaceDAOImpl implements IPreviousWorkingPlaceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public PreviousWorkingPlace get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PreviousWorkingPlace.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<PreviousWorkingPlace> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(PreviousWorkingPlace previousWorkingPlace) {
		previousWorkingPlace.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(previousWorkingPlace);
	}

	@Override
	public void add(PreviousWorkingPlace previousWorkingPlace) {
		previousWorkingPlace.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(previousWorkingPlace);

	}

	@Override
	public void delete(PreviousWorkingPlace previousWorkingPlace) {
		previousWorkingPlace.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(previousWorkingPlace);
	}

}
