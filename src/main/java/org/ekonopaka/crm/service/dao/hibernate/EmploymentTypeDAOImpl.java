package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IEmploymentTypeDAO;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmploymentTypeDAOImpl implements IEmploymentTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addEmploymentType(EmploymentType employmentType) {
		employmentType.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(employmentType);
	}

	@Override
	public void deleteEmploymentType(EmploymentType employmentType) {
		employmentType.setIsEnabled(false);
		hibernateTemplate.update(employmentType);
	}

	@Override
	public List<EmploymentType> getEmploymentTypes() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(EmploymentType.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		@SuppressWarnings("unchecked")
		List<EmploymentType> employmentTypes = hibernateTemplate
				.findByCriteria(criteria);
		return employmentTypes;
	}

	@Override
	public EmploymentType getEmploymentType(int id) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(EmploymentType.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<EmploymentType> employmentTypes = hibernateTemplate
				.findByCriteria(criteria);

		if (employmentTypes.size() > 0)	{
			return employmentTypes.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updateEmploymentType(EmploymentType employmentType) {
		employmentType.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(employmentType);
	}

}
