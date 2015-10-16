package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IOfficeDAO;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OfficeDAOImpl implements IOfficeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public List<Office> getOffices() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Office.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		@SuppressWarnings("unchecked")
		List<Office> offices = hibernateTemplate.findByCriteria(criteria);
		return offices;
	}

	@Override
	public Office getUserOffice(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Office.class);
		criteria.add(Restrictions.eq("user", user));
		@SuppressWarnings("unchecked")
		List<Office> offices = hibernateTemplate.findByCriteria(criteria);
		return offices.get(0);
	}

	@Override
	public void addOffice(Office office) {
		office.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(office);
	}

	@Override
	public void deleteOffice(Office office) {
		office.setIsEnabled(false);
		hibernateTemplate.update(office);
	}

	@Override
	public Office getOffice(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Office.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Office> offices = hibernateTemplate.findByCriteria(criteria);

		if (offices.size() > 0)	{
			return offices.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateOffice(Office office) {
		office.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(office);
	}
}
