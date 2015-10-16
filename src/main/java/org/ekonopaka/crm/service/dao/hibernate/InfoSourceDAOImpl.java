package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IInfoSourceDAO;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.types.InfoSourceType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InfoSourceDAOImpl implements IInfoSourceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addSourceType(InfoSourceType infoSourceType) {
		sessionFactory.getCurrentSession().save(infoSourceType);
	}

	@Override
	public void deleteSourceType(InfoSourceType infoSourceType) {
		infoSourceType.setIsEnabled(false);
		hibernateTemplate.update(infoSourceType);
	}

	@Override
	public void addSource(InfoSource infoSource) {
		sessionFactory.getCurrentSession().save(infoSource);
	}

	@Override
	public void deleteSource(InfoSource infoSource) {
		infoSource.setIsEnabled(false);
		hibernateTemplate.update(infoSource);
	}

	@Override
	public List<InfoSource> getInfoSources() {
		DetachedCriteria criteria = DetachedCriteria.forClass(InfoSource.class);

		criteria.add(Restrictions.eq("isEnabled", true)).addOrder(Order.asc("infoSourceType"));

		@SuppressWarnings("unchecked")
		List<InfoSource> infoSources = hibernateTemplate.findByCriteria(criteria);
		return infoSources;
	}

	@Override
	public List<InfoSourceType> getInfoSourceTypes() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(InfoSourceType.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		@SuppressWarnings("unchecked")
		List<InfoSourceType> infoSourceTypes = hibernateTemplate
				.findByCriteria(criteria);
		return infoSourceTypes;
	}

	@Override
	public InfoSource getInfoSource(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(InfoSource.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<InfoSource> infoSources = hibernateTemplate
				.findByCriteria(criteria);

		if (infoSources.size() > 0)	{
			return infoSources.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public InfoSourceType getInfoSourceType(int id) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(InfoSourceType.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<InfoSourceType> infoSourceTypes = hibernateTemplate
				.findByCriteria(criteria);

		if (infoSourceTypes.size() > 0)	{
			return infoSourceTypes.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateInfoSource(InfoSource infoSource) {
		infoSource.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(infoSource);
	}

}
