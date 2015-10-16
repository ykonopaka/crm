package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IPreviousWorkingPlaceDAO;
import org.ekonopaka.crm.model.PreviousWorkingPlace;
import org.ekonopaka.crm.service.interfaces.IPreviousWorkingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PreviousWorkingPlaceService implements IPreviousWorkingPlaceService {

	@Autowired
	IPreviousWorkingPlaceDAO previousWorkingPlaceDAO;
	
	@Override
	@Transactional
	public PreviousWorkingPlace get(int id) {
		return previousWorkingPlaceDAO.get(id);
	}

	@Override
	@Transactional
	public void update(PreviousWorkingPlace workingPlace) {
		previousWorkingPlaceDAO.update(workingPlace);
	}

	@Override
	@Transactional
	public void add(PreviousWorkingPlace workingPlace) {
		previousWorkingPlaceDAO.add(workingPlace);
	}

	@Override
	@Transactional
	public void delete(PreviousWorkingPlace workingPlace) {
		previousWorkingPlaceDAO.delete(workingPlace);
	}

	@Override
	public PreviousWorkingPlace create() {
		PreviousWorkingPlace place = new PreviousWorkingPlace();
		place.setIsExisted(true);
		return place;
	}

}
