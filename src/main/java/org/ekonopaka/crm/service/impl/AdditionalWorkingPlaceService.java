package org.ekonopaka.crm.service.impl;

import org.ekonopaka.crm.dao.interfaces.IAdditionalWorkingPlaceDAO;
import org.ekonopaka.crm.model.AdditionalWorkingPlace;
import org.ekonopaka.crm.service.interfaces.IAdditionalWorkingPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdditionalWorkingPlaceService implements IAdditionalWorkingPlaceService {

	@Autowired
	IAdditionalWorkingPlaceDAO additionalWorkingPlaceDAO;
	
	@Override
	@Transactional
	public AdditionalWorkingPlace get(int id) {
		return additionalWorkingPlaceDAO.get(id);
	}

	@Override
	@Transactional
	public void update(AdditionalWorkingPlace workingPlace) {
		additionalWorkingPlaceDAO.update(workingPlace);
	}

	@Override
	@Transactional
	public void add(AdditionalWorkingPlace workingPlace) {
		additionalWorkingPlaceDAO.add(workingPlace);
	}

	@Override
	@Transactional
	public void delete(AdditionalWorkingPlace workingPlace) {
		additionalWorkingPlaceDAO.delete(workingPlace);
	}

	@Override
	public AdditionalWorkingPlace create() {
		AdditionalWorkingPlace result = new AdditionalWorkingPlace();
		result.setIsExisted(true);
		return result;
	}

}
