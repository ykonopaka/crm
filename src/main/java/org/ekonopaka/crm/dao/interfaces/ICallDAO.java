package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.AdditionalCallInfo;
import org.ekonopaka.crm.model.Call;
import org.ekonopaka.crm.model.User;
import org.hibernate.criterion.Criterion;

public interface ICallDAO {

	public void add(Call call);
	
	List<Call> getCalls(DataTableHandler dataTableHandler, User userToGetCalls);
	
	 Integer getNumberOfCalls(User userToGetCalls);
	 
	 Integer getNumberOfCalls(Criterion criterion, User userToGetCalls);
	 
	 public Call get(int id);
	 
	 public void delete(Call call);
	 
	 public void update(Call call);
	
	 public void addAdditionalInfo(AdditionalCallInfo info);
	 
	 public void updateAdditionalInfo(AdditionalCallInfo info);
	 
	 public AdditionalCallInfo getAdditionalInfo(int id);
}
