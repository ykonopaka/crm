package org.ekonopaka.crm.service.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICallDAO;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.DataTableRequest;
import org.ekonopaka.crm.model.AdditionalCallInfo;
import org.ekonopaka.crm.model.Call;
import org.ekonopaka.crm.model.User;
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
public class CallDAOImpl implements ICallDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}
	
	@Override
	public void add(Call call) {
		call.setDate(new Date());
		call.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(call);
	}

	@Override
	public List<Call> getCalls(DataTableHandler dataTableHandler, User userToGetCalls) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Call.class).createAlias("client", "client", CriteriaSpecification.INNER_JOIN).createAlias("clientPhoneNumber", "clientPhoneNumber", CriteriaSpecification.INNER_JOIN);
		criteria.add(Restrictions.eq("isEnabled", true));
		
		if (userToGetCalls!=null)	{
			criteria.add(Restrictions.eq("user", userToGetCalls));
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
				criteria.addOrder(Order.asc("client.lastName"));
			} else {
				criteria.addOrder(Order.desc("client.lastName"));
			}
		}

		if (index == 2) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("client.firstName"));
			} else {
				criteria.addOrder(Order.desc("client.firstName"));
			}
		}
		
		if (index == 3) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("client.middleName"));
			} else {
				criteria.addOrder(Order.desc("client.middleName"));
			}
		}

		if (index == 4) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("clientPhoneNumber.phoneNumber"));
			} else {
				criteria.addOrder(Order.desc("clientPhoneNumber.phoneNumber"));
			}
		}
		
		if (index == 5) {
			if (direction.equals("asc")) {
				criteria.addOrder(Order.asc("date"));
			} else {
				criteria.addOrder(Order.desc("date"));
			}
		}
		
		String query = request.getsSearch();

		int totalRecordsNumber = getNumberOfCalls(userToGetCalls);
		dataTableHandler.setiTotalRecords(totalRecordsNumber);

		if (!query.equals("")) {
			query = "%" + query + "%";
			Criterion criterion = Restrictions.disjunction()
					.add(Restrictions.like("client.firstName", query))
					.add(Restrictions.like("client.lastName", query))
					.add(Restrictions.like("client.middleName", query))
					.add(Restrictions.like("clientPhoneNumber.phoneNumber", query));
			int totalDisplayRecordsNumber = getNumberOfCalls(userToGetCalls);
			dataTableHandler.setiTotalDisplayRecords(totalDisplayRecordsNumber);
			criteria.add(criterion);
		} else {
			dataTableHandler.setiTotalDisplayRecords(totalRecordsNumber);
		}
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		@SuppressWarnings("unchecked")
		List<Call> calls = hibernateTemplate.findByCriteria(criteria,
				start, maxResult);

		return calls;
	}
	
	@Override
	public Integer getNumberOfCalls(User userToGetCalls) {
		DetachedCriteria criteria = null;
		if (userToGetCalls==null)	{
			criteria = DetachedCriteria.forClass(Call.class).add(Restrictions.eq("isEnabled", true));
		}	else {
			criteria = DetachedCriteria.forClass(Call.class).add(Restrictions.eq("isEnabled", true)).add(Restrictions.eq("user", userToGetCalls));
		}
		
		criteria.setProjection(Projections.rowCount());
		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public Integer getNumberOfCalls(Criterion criterion, User userToGetCalls) {
		DetachedCriteria criteria = null;
		if (userToGetCalls==null)	{
			criteria = DetachedCriteria.forClass(Call.class).add(Restrictions.eq("isEnabled", true)).createAlias("client", "client", CriteriaSpecification.INNER_JOIN).createAlias("clientPhoneNumber", "clientPhoneNumber", CriteriaSpecification.INNER_JOIN);
		} else {
			criteria = DetachedCriteria.forClass(Call.class).add(Restrictions.eq("isEnabled", true)).add(Restrictions.eq("user", userToGetCalls)).createAlias("client", "client", CriteriaSpecification.INNER_JOIN).createAlias("clientPhoneNumber", "clientPhoneNumber", CriteriaSpecification.INNER_JOIN);
		}
		criteria.add(criterion);
		criteria.setProjection(Projections.rowCount());
		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

	@Override
	public Call get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Call.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Call> calls = hibernateTemplate.findByCriteria(criteria);

		if (calls.size() > 0)	{
			return calls.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void delete(Call call) {
		call.setIsEnabled(false);
		hibernateTemplate.update(call);
	}

	@Override
	public void update(Call call) {
		call.setIsEnabled(true);
		hibernateTemplate.update(call);
	}

	@Override
	public void addAdditionalInfo(AdditionalCallInfo info) {
		info.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(info);
	}

	@Override
	public AdditionalCallInfo getAdditionalInfo(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(AdditionalCallInfo.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<AdditionalCallInfo> infos = hibernateTemplate.findByCriteria(criteria);

		if (infos.size() > 0)	{
			return infos.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateAdditionalInfo(AdditionalCallInfo info) {
		hibernateTemplate.update(info);
	}

}
