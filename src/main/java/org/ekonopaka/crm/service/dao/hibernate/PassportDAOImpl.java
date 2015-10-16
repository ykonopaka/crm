package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IPassportDAO;
import org.ekonopaka.crm.model.Passport;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PassportDAOImpl implements IPassportDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public Passport getPassport(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Passport.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Passport> passports = hibernateTemplate.findByCriteria(criteria);

		if (passports.size() > 0)	{
			return passports.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updatePassport(Passport passport) {
		sessionFactory.getCurrentSession().update(passport);
	}

	@Override
	public void addPassport(Passport passport) {
		passport.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(passport);
	}

	@Override
	public void deletePassport(Passport passport) {
		passport.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(passport);
	}

}
