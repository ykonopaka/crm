package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IIncomeOutcomeDAO;
import org.ekonopaka.crm.model.IncomeOutcome;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IncomeOutcomeDAOImpl implements IIncomeOutcomeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public IncomeOutcome get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(IncomeOutcome.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<IncomeOutcome> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void update(IncomeOutcome incomeOutcome) {
		incomeOutcome.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(incomeOutcome);
		
	}

	@Override
	public void add(IncomeOutcome incomeOutcome) {
		incomeOutcome.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(incomeOutcome);
		
	}

	@Override
	public void delete(IncomeOutcome incomeOutcome) {
		incomeOutcome.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(incomeOutcome);
		
	}

}
