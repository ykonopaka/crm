package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.InfoSource;
import org.ekonopaka.crm.model.types.InfoSourceType;

public interface IInfoSourceDAO {

	public void addSourceType(InfoSourceType infoSourceType);

	public void deleteSourceType(InfoSourceType infoSourceType);

	public void addSource(InfoSource infoSource);

	public void deleteSource(InfoSource infoSource);

	public List<InfoSource> getInfoSources();

	public List<InfoSourceType> getInfoSourceTypes();

	public InfoSource getInfoSource(int id);

	public InfoSourceType getInfoSourceType(int id);

	public void updateInfoSource(InfoSource infoSource);

}
