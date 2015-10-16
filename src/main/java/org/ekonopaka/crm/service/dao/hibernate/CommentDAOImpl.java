package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.ICommentsDAO;
import org.ekonopaka.crm.model.Comment;
import org.ekonopaka.crm.model.Deal;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements ICommentsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void add(Comment comment) {
		comment.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(comment);
	}

	@Override
	public Comment get(int id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Comment.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<Comment> list = hibernateTemplate.findByCriteria(criteria);

		if (list.size() > 0)	{
			return list.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public List<Comment> getDealComments(Deal deal) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Comment.class);
		criteria.add(Restrictions.eq("deal", deal));
		criteria.add(Restrictions.eq("isEnabled", true));
		criteria.addOrder(Order.asc("date"));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		@SuppressWarnings("unchecked")
		List<Comment> list = hibernateTemplate.findByCriteria(criteria);
		
		return list;
	}

	@Override
	public void remove(Comment comment) {
		comment.setIsEnabled(false);
		hibernateTemplate.update(comment);
	}

}
