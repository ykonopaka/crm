package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;

public interface IWorkflowDAO {

	List<DealStateType> getDealStateTypes();
	List<DealWorkflowSideType> getDealWorkflowSideTypes();
	List<DealWorkflowType> getDealWorkflowTypes();
	
	DealStateType getDealStateType(int id);
	DealWorkflowSideType getWorkflowSideType(int id);
	DealWorkflowType getDealWorkflowType(int id);
	
}
