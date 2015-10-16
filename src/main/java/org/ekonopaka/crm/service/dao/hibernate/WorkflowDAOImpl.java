package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IWorkflowDAO;
import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WorkflowDAOImpl implements IWorkflowDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public List<DealStateType> getDealStateTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DealStateType.class);

		@SuppressWarnings("unchecked")
		List<DealStateType> list = hibernateTemplate.findByCriteria(criteria);
		return list;
	}

	@Override
	public List<DealWorkflowSideType> getDealWorkflowSideTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DealWorkflowSideType.class);

		@SuppressWarnings("unchecked")
		List<DealWorkflowSideType> list = hibernateTemplate.findByCriteria(criteria);
		return list;
	}

	@Override
	public List<DealWorkflowType> getDealWorkflowTypes() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DealWorkflowType.class);

		@SuppressWarnings("unchecked")
		List<DealWorkflowType> list = hibernateTemplate.findByCriteria(criteria);
		return list;
	}

	@Override
	public DealStateType getDealStateType(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DealStateType.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<DealStateType> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public DealWorkflowSideType getWorkflowSideType(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DealWorkflowSideType.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<DealWorkflowSideType> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public DealWorkflowType getDealWorkflowType(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DealWorkflowType.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<DealWorkflowType> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

}
