package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IWorkingPlaceDAO;
import org.ekonopaka.crm.model.WorkingPlace;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkingPlaceDAOImpl implements IWorkingPlaceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public WorkingPlace get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(WorkingPlace.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<WorkingPlace> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(WorkingPlace workingPlace) {
		workingPlace.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(workingPlace);
	}

	@Override
	public void add(WorkingPlace workingPlace) {
		workingPlace.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(workingPlace);

	}

	@Override
	public void delete(WorkingPlace workingPlace) {
		workingPlace.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(workingPlace);
	}

}
