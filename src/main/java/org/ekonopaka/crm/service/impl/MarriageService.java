package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IMarriageDAO;
import org.ekonopaka.crm.model.Marriage;
import org.ekonopaka.crm.service.interfaces.IMarriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarriageService implements IMarriageService {

	@Autowired
	IMarriageDAO marriageDAO;
	
	@Override
	@Transactional
	public Marriage getMarriage(int id) {
		return marriageDAO.getMarriage(id);
	}

	@Override
	@Transactional
	public void updateMarriage(Marriage marriage) {
		marriageDAO.updateMarriage(marriage);
	}

	@Override
	@Transactional
	public void addMarriage(Marriage marriage) {
		marriageDAO.addMarriage(marriage);
	}

	@Override
	@Transactional
	public void deleteMarriage(Marriage marriage) {
		marriageDAO.deleteMarriage(marriage);
	}

	@Override
	public Marriage createNewMarriage() {
		return new Marriage();
	}

}
