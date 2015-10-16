package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IOfficeDAO;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OfficeService implements IOfficeService {

	@Autowired
	private IOfficeDAO officeDAO;

	@Override
	@Transactional
	public List<Office> getOffices() {
		return officeDAO.getOffices();
	}

	@Override
	@Transactional
	public Office getUserOffice(User user) {
		return officeDAO.getUserOffice(user);
	}

	@Override
	@Transactional
	public void addOffice(Office office) {
		officeDAO.addOffice(office);
	}

	@Override
	@Transactional
	public void deleteOffice(Office office) {
		officeDAO.deleteOffice(office);
	}

	@Override
	@Transactional
	public Office getOfficeById(int id) {
		return officeDAO.getOffice(id);
	}

	@Override
	@Transactional
	public void updateOffice(Office office) {
		officeDAO.updateOffice(office);
	}

	@Override
	public Office getNewOffice() {
		return new Office();
	}
}
