package org.ekonopaka.crm.service.dao.hibernate;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IPhoneNumberDAO;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneNumberDAOImpl implements IPhoneNumberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumber.setIsEnabled(true);
		sessionFactory.getCurrentSession().save(phoneNumber);
	}

	@Override
	public void deletePhoneNumber(PhoneNumber phoneNumber) {
		phoneNumber.setIsEnabled(false);
		hibernateTemplate.update(phoneNumber);
	}

	@Override
	public List<PhoneNumber> getPhoneNumbers() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PhoneNumber.class);

		criteria.add(Restrictions.eq("isEnabled", true));

		@SuppressWarnings("unchecked")
		List<PhoneNumber> phoneNumbers = hibernateTemplate
				.findByCriteria(criteria);
		return phoneNumbers;
	}

	@Override
	public PhoneNumber getPhoneNumber(int id) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PhoneNumber.class);
		criteria.add(Restrictions.eq("id", id));
		@SuppressWarnings("unchecked")
		List<PhoneNumber> phoneNumbers = hibernateTemplate
				.findByCriteria(criteria);

		if (phoneNumbers.size() > 0)	{
			return phoneNumbers.get(0);
		}	else {
			return null;
		}
	}

	@Override
	public void updatePhoneNumber(PhoneNumber phoneNumber) {
		phoneNumber.setIsEnabled(true);
		sessionFactory.getCurrentSession().update(phoneNumber);
	}

	@Override
	public List<PhoneNumber> getPhoneNumbers(Office office) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PhoneNumber.class);

		criteria.add(Restrictions.eq("isEnabled", true)).add(Restrictions.eq("office", office));

		@SuppressWarnings("unchecked")
		List<PhoneNumber> phoneNumbers = hibernateTemplate
				.findByCriteria(criteria);
		return phoneNumbers;
	}
}
