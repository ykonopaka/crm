package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IRoleDAO;
import org.ekonopaka.crm.model.Role;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAOImpl implements IRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addRole(Role role) {
		sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public Role getRoleByAuthority(String authority) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);

		criteria.add(Restrictions.eq("authority", authority));

		@SuppressWarnings("unchecked")
		List<Role> roles = hibernateTemplate.findByCriteria(criteria);
		
		if (roles.size() > 0)	{
			return roles.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public List<Role> getRoles() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Role.class);

		@SuppressWarnings("unchecked")
		List<Role> roles = hibernateTemplate.findByCriteria(criteria);
		return roles;
	}
}
