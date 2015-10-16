package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICreditDAO;
import org.ekonopaka.crm.model.Credit;
import org.ekonopaka.crm.model.types.CreditType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CreditDAOImpl implements ICreditDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addCreditType(CreditType creditType) {
		sessionFactory.getCurrentSession().save(creditType);

	}

	@Override
	public void deleteCreditType(CreditType creditType) {
		creditType.setIsEnabled(false);
		hibernateTemplate.update(creditType);
	}

	@Override
	public void addCredit(Credit credit) {
		credit.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(credit);
	}

	@Override
	public void deleteCredit(Credit credit) {
		credit.setIsEnabled(false);
		hibernateTemplate.update(credit);
	}

	@Override
	public List<CreditType> getCreditTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(CreditType.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		@SuppressWarnings("unchecked")
		List<CreditType> creditTypes = hibernateTemplate.findByCriteria(criteria);
		return creditTypes;
	}

	@Override
	public Credit getCredit(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Credit.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Credit> credits = hibernateTemplate.findByCriteria(criteria);

		if (credits.size() > 0)	{
			return credits.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateCredit(Credit credit) {
		credit.setIsEnabled(true);
		hibernateTemplate.update(credit);
	}
}
