package org.ekonopaka.crm.service.dao.hibernate;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Pattern;

import org.ekonopaka.crm.constants.DealStates;
import org.ekonopaka.crm.constants.DealWorkflowSideTypes;
import org.ekonopaka.crm.dao.interfaces.IDealDAO;
import org.ekonopaka.crm.dao.interfaces.IWorkflowDAO;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.DataTableRequest;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DealDAOImpl implements IDealDAO {

	@Autowired
	private IWorkflowDAO workflowDAO;
	
	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void addDeal(Deal deal) {
		deal.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(deal);
	}

	@Override
	public void deleteDeal(Deal deal) {
		deal.setIsEnabled(false);
		sessionFactory.getCurrentSession().update(deal);
	}

	@Override
	public void updateDeal(Deal deal) {
		sessionFactory.getCurrentSession().update(deal);
	}

	@Override
	public Deal getDeal(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Deal.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Deal> deals = hibernateTemplate.findByCriteria(criteria);

		if (deals.size() > 0)	{
			return deals.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public List<Deal> getDeals(DataTableHandler dataTableHandler, User userToGetDeals) throws UnsupportedEncodingException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Deal.class);
		criteria = criteria.createAlias("customer", "customer", CriteriaSpecification.LEFT_JOIN).
				createAlias("customer.workingPlace.jobType", "jobType", CriteriaSpecification.LEFT_JOIN).
				createAlias("credit", "credit", CriteriaSpecification.LEFT_JOIN);

		criteria.add(Restrictions.eq("isEnabled", true));

		if (userToGetDeals!=null)	{
			criteria.add(Restrictions.eq("user", userToGetDeals));
		}
		
		DataTableRequest request = dataTableHandler.getDataTableRequest();

		String direction = request.getsSortDirection();
		int index = request.getiSortColumnIndex();
		int start = request.getiDisplayStart();
		int maxResult = request.getiDisplayLength();
		
		if (index == 0) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("id"));
			} else {
				criteria.addOrder(Order.desc("id"));
			}
		}

		if (index == 1) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("customer.lastName"));
			} else {
				criteria.addOrder(Order.desc("customer.lastName"));
			}
		}

		if (index == 2) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("jobType.code"));
			} else {
				criteria.addOrder(Order.desc("jobType.code"));
			}
		}
		
		if (index == 3) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("credit.amount"));
			} else {
				criteria.addOrder(Order.desc("credit.amount"));
			}
		}

		if (index == 4) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("credit.term"));
			} else {
				criteria.addOrder(Order.desc("credit.term"));
			}
		}
		
		if (index == 5) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("creationDate"));
			} else {
				criteria.addOrder(Order.desc("creationDate"));
			}
		}
		
		String query = request.getsSearch();

		int totalRecordsNumber = getNumberOfDeals(userToGetDeals);
		dataTableHandler.setiTotalRecords(totalRecordsNumber);

		if (!query.equals("")) {
			Criterion criterion = Restrictions.disjunction().add(Restrictions.like("customer.lastName", query));
			
			if (Pattern.matches("^\\d*$", query))	{
				Integer iQuery = Integer.parseInt(query);
				criterion = Restrictions.disjunction().add(Restrictions.like("customer.lastName", "%" + query + "%")).add(Restrictions.eq("id", iQuery));
			} else {
				criterion = Restrictions.disjunction().add(Restrictions.like("customer.lastName", "%" + query + "%"));
			}
			
			int totalDisplayRecordsNumber = getNumberOfDeals(criterion, userToGetDeals);
			dataTableHandler.setiTotalDisplayRecords(totalDisplayRecordsNumber);
			criteria.add(criterion);
		} else {
			dataTableHandler.setiTotalDisplayRecords(totalRecordsNumber);
		}
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		@SuppressWarnings("unchecked")
		List<Deal> deals = hibernateTemplate.findByCriteria(criteria, start, maxResult);

		return deals;
	}
	
	@Override
	public Integer getNumberOfDeals(User userToGetDeals) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Deal.class).createAlias("customer", "customer", CriteriaSpecification.LEFT_JOIN);
		
		if (userToGetDeals!=null)	{
			criteria.add(Restrictions.eq("user", userToGetDeals));
		}
		
		criteria.setProjection(Projections.rowCount());
		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public Integer getNumberOfDeals(Criterion criterion, User userToGetDeals) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Deal.class).createAlias("customer", "customer", CriteriaSpecification.LEFT_JOIN);
		
		if (userToGetDeals!=null)	{
			criteria.add(Restrictions.eq("user", userToGetDeals));
		}
		
		criteria.add(criterion);
		criteria.setProjection(Projections.rowCount());
		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public List<Deal> getOperatorActiveDeals(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Deal.class).createAlias("user", "user", CriteriaSpecification.LEFT_JOIN);
		criteria.add(Restrictions.eq("user", user)).add(Restrictions.eq("isEnabled", true));
		
		DealWorkflowSideType operatorWorkflowSideType = workflowDAO.getWorkflowSideType(DealWorkflowSideTypes.OPERATOR_SIDE_ID);
		
		DealStateType dealCloseState = workflowDAO.getDealStateType(DealStates.CLOSED_ID);
		
		criteria.add(Restrictions.eq("dealWorkflowSideType", operatorWorkflowSideType)).add(Restrictions.ne("dealStateType", dealCloseState)).
							add(Restrictions.eq("step", Deal.FINISHED));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		@SuppressWarnings("unchecked")
		List<Deal> deals = hibernateTemplate.findByCriteria(criteria);
		
		return deals;
	}

	@Override
	public List<Deal> getCoordinatorActiveDeals(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Deal.class);
		
		DealStateType dealCloseState = workflowDAO.getDealStateType(DealStates.CLOSED_ID);
		DealStateType dealNewState = workflowDAO.getDealStateType(DealStates.NEW_ID);
		
		criteria.
					add(Restrictions.eq("isEnabled", true)).
					add(Restrictions.ne("dealStateType", dealCloseState)).add(Restrictions.ne("dealStateType", dealNewState)).
					add(Restrictions.eq("step", Deal.FINISHED));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		@SuppressWarnings("unchecked")
		List<Deal> deals = hibernateTemplate.findByCriteria(criteria);
		
		return deals;
	}

}
