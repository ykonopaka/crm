package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IPassportDAO;
import org.ekonopaka.crm.model.Passport;
import org.ekonopaka.crm.service.interfaces.IPassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PassportService implements IPassportService {

	@Autowired
	IPassportDAO passportDAO;
	
	@Override
	@Transactional
	public Passport getPassport(int id) {
		return passportDAO.getPassport(id);
	}

	@Override
	@Transactional
	public void updatePassport(Passport passport) {
		passportDAO.updatePassport(passport);
	}

	@Override
	@Transactional
	public void addPassport(Passport passport) {
		passportDAO.addPassport(passport);
	}

	@Override
	@Transactional
	public void deletePassport(Passport passport) {
		passportDAO.deletePassport(passport);
	}

	@Override
	public Passport createNewPassport() {
		return new Passport();
	}

}
