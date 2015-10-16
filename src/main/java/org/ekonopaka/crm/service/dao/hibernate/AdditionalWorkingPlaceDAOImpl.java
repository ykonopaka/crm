package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IAdditionalWorkingPlaceDAO;
import org.ekonopaka.crm.model.AdditionalWorkingPlace;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdditionalWorkingPlaceDAOImpl implements IAdditionalWorkingPlaceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public AdditionalWorkingPlace get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdditionalWorkingPlace.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<AdditionalWorkingPlace> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(AdditionalWorkingPlace additionalWorkingPlace) {
		additionalWorkingPlace.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(additionalWorkingPlace);
	}

	@Override
	public void add(AdditionalWorkingPlace additionalWorkingPlace) {
		additionalWorkingPlace.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(additionalWorkingPlace);

	}

	@Override
	public void delete(AdditionalWorkingPlace additionalWorkingPlace) {
		additionalWorkingPlace.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(additionalWorkingPlace);
	}

}
