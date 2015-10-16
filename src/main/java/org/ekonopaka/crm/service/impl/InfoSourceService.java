package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IInfoSourceDAO;
import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.types.InfoSourceType;
import org.ekonopaka.crm.service.interfaces.IInfoSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoSourceService implements IInfoSourceService {

	@Autowired
	private IInfoSourceDAO infoSourceDAO;

	@Autowired
	MessageSource messageSource;

	@Override
	@Transactional
	public void addSourceType(InfoSourceType infoSourceType) {
		infoSourceType.setIsEnabled(true);
		infoSourceDAO.addSourceType(infoSourceType);
	}

	@Override
	@Transactional
	public void deleteSourceType(InfoSourceType infoSourceType) {
		infoSourceDAO.deleteSourceType(infoSourceType);
	}

	@Override
	@Transactional
	public void addSource(InfoSource infoSource) {
		infoSource.setIsEnabled(true);
		infoSourceDAO.addSource(infoSource);

	}

	@Override
	@Transactional
	public void deleteSource(InfoSource infoSource) {
		infoSourceDAO.deleteSource(infoSource);
	}

	@Override
	@Transactional
	public List<InfoSource> getInfoSources() {
		return infoSourceDAO.getInfoSources();
	}

	@Override
	@Transactional
	public List<InfoSourceType> getInfoSourceTypes() {
		return infoSourceDAO.getInfoSourceTypes();
	}

	@Override
	@Transactional
	public InfoSource getInfoSourceById(int id) {
		return infoSourceDAO.getInfoSource(id);
	}

	@Override
	@Transactional
	public InfoSourceType getInfoSourceTypeById(int id) {
		return infoSourceDAO.getInfoSourceType(id);
	}

	@Override
	@Transactional
	public void updateInfoSource(InfoSource infoSource) {
		infoSourceDAO.updateInfoSource(infoSource);
	}

	@Override
	public InfoSource getNewInfoSource() {
		return new InfoSource();
	}

}
