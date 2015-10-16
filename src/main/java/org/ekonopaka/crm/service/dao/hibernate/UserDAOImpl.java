package org.ekonopaka.crm.service.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IUserDAO;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.DataTableRequest;
import org.ekonopaka.crm.model.LoginEntry;
import org.ekonopaka.crm.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SaltSource saltSource;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	private HibernateTemplate hibernateTemplate;

	@Override
	public void addUser(User user) {
		encodePassword(user);
		user.setCreationDate(new Date());
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUser(Integer id) {
		User user = hibernateTemplate.get(User.class, id);
		return user;
	}

	@Override
	public void deleteUser(User user) {
		Long date = (new Date()).getTime();
		user.setEmail(user.getUsername() + "_" + date + "@deleted.com");
		user.setUsername("DELETED_" + user.getUsername() + date);
		user.setIsEnabled(false);
		hibernateTemplate.update(user);
	}

	@Override
	public void deleteUser(Integer id) {
		User user = getUser(id);
		deleteUser(user);
	}

	@Override
	public List<User> getUsers() {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		@SuppressWarnings("unchecked")
		List<User> users = hibernateTemplate.findByCriteria(criteria);
		return users;
	}

	@Override
	public void restoreUser(User user) {
		user.setIsEnabled(true);
		hibernateTemplate.update(user);
	}

	@Override
	public void restoreUser(Integer id) {
		User user = getUser(id);
		restoreUser(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserByUsername(String username) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<User> users = hibernateTemplate.findByCriteria(criteria);

		User user = null;

		if (users.size() == 1) {
			user = users.get(0);
		} else if (users.size() == 0) {
			throw new UsernameNotFoundException("");
		} else if (users.size() > 1) {
			// TODO DataAccessException should be thrown here
			throw new UsernameNotFoundException("");
		}

		return user;
	}

	@Override
	public void addLoginHistoryEntry(User user) {
		LoginEntry login = new LoginEntry();
		login.setUser(user);
		login.setDate(new Date());

		sessionFactory.getCurrentSession().save(login);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUserByEmail(String email) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("email", email)).setResultTransformer(
				DetachedCriteria.DISTINCT_ROOT_ENTITY);
		List<User> users = hibernateTemplate.findByCriteria(criteria);

		if (users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByEmail(String email) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("email", email)).setResultTransformer(
				DetachedCriteria.DISTINCT_ROOT_ENTITY);
		List<User> users = hibernateTemplate.findByCriteria(criteria);

		return users;
	}

	@Override
	public void updateUserPassword(User user) {
		encodePassword(user);
		updateUser(user);
	}

	private void encodePassword(User user) {
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encodePassword(password,
				saltSource.getSalt(user));
		user.setPassword(encodedPassword);
	}

	@Override
	public String encodePassword(String password, User user) {
		String encodedPassword = passwordEncoder.encodePassword(password,
				saltSource.getSalt(user));
		return encodedPassword;
	}

	@Override
	public List<LoginEntry> getUserLoginEntries(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginEntry.class);
		criteria.add(Restrictions.eq("user", user));

		@SuppressWarnings("unchecked")
		List<LoginEntry> loginEntries = hibernateTemplate
				.findByCriteria(criteria);
		return loginEntries;
	}

	@Override
	public List<LoginEntry> getUserLoginEntries(User user, DataTableHandler dto) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginEntry.class);
		criteria.add(Restrictions.eq("user", user));

		DataTableRequest request = dto.getDataTableRequest();

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
				criteria.addOrder(Order.asc("date"));
			} else {
				criteria.addOrder(Order.desc("date"));
			}
		}

		@SuppressWarnings("unchecked")
		List<LoginEntry> loginEntries = hibernateTemplate.findByCriteria(
				criteria, start, maxResult);

		int result = getNumberOfLoginEntries(user);

		dto.setiTotalDisplayRecords(result);
		dto.setiTotalRecords(result);

		return loginEntries;
	}

	@Override
	public Integer getNumberOfLoginEntries(User user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LoginEntry.class);
		criteria.add(Restrictions.eq("user", user));

		criteria.setProjection(Projections.rowCount());

		return (Integer) hibernateTemplate.findByCriteria(criteria).get(0);
	}

}
