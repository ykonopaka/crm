package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICreditCardDAO;
import org.ekonopaka.crm.model.CreditCard;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreditCardDAOImpl implements ICreditCardDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public CreditCard get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditCard.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<CreditCard> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(CreditCard creditCard) {
		creditCard.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(creditCard);
	}

	@Override
	public void add(CreditCard creditCard) {
		creditCard.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(creditCard);

	}

	@Override
	public void delete(CreditCard creditCard) {
		creditCard.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(creditCard);
	}

}
