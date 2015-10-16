package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.types.InfoSourceType;

public interface IInfoSourceService {
	
	public InfoSource getNewInfoSource();

	public void addSourceType(InfoSourceType infoSourceType);

	public void deleteSourceType(InfoSourceType infoSourceType);

	public void addSource(InfoSource infoSource);

	public void deleteSource(InfoSource infoSource);

	public List<InfoSource> getInfoSources();

	public List<InfoSourceType> getInfoSourceTypes();

	public InfoSource getInfoSourceById(int id);

	public InfoSourceType getInfoSourceTypeById(int id);

	public void updateInfoSource(InfoSource infoSource);

}
