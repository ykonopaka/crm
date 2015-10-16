package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IPhoneNumberDAO;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.PhoneNumber;
import org.ekonopaka.crm.service.interfaces.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneService implements IPhoneService {

	@Autowired
	private IPhoneNumberDAO phoneNumberDAO;

	@Override
	@Transactional
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumberDAO.addPhoneNumber(phoneNumber);
	}

	@Override
	@Transactional
	public void deletePhoneNumber(PhoneNumber phoneNumber) {
		phoneNumberDAO.deletePhoneNumber(phoneNumber);
	}

	@Override
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumberDAO.getPhoneNumbers();
	}

	@Override
	public PhoneNumber getPhoneNumberById(int id) {
		return phoneNumberDAO.getPhoneNumber(id);
	}

	@Override
	@Transactional
	public void updatePhoneNumber(PhoneNumber phoneNumber) {
		phoneNumberDAO.updatePhoneNumber(phoneNumber);
	}

	@Override
	public PhoneNumber getNewPhoneNumber() {
		return new PhoneNumber();
	}

	@Override
	public List<PhoneNumber> getPhoneNumbers(Office office) {
		return phoneNumberDAO.getPhoneNumbers(office);
	}
}
