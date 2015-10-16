package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IWorkingPlaceDAO;
import org.ekonopaka.crm.model.WorkingPlace;
import org.ekonopaka.crm.service.interfaces.IWorkingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkingPlaceService implements IWorkingPlaceService {

	@Autowired
	IWorkingPlaceDAO workingPlaceDAO;
	
	@Override
	@Transactional
	public WorkingPlace get(int id) {
		return workingPlaceDAO.get(id);
	}

	@Override
	@Transactional
	public void update(WorkingPlace workingPlace) {
		workingPlaceDAO.update(workingPlace);
	}

	@Override
	@Transactional
	public void add(WorkingPlace workingPlace) {
		workingPlaceDAO.add(workingPlace);
	}

	@Override
	@Transactional
	public void delete(WorkingPlace workingPlace) {
		workingPlaceDAO.delete(workingPlace);
	}

	@Override
	public WorkingPlace create() {
		WorkingPlace place = new WorkingPlace();
		return place;
	}

}
