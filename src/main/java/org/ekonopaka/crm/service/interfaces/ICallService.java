package org.ekonopaka.crm.service.interfaces;

import java.util.Locale;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.AdditionalCallInfo;
import org.ekonopaka.crm.model.Call;
import org.ekonopaka.crm.model.User;

public interface ICallService {

	public void addCall(Call call);
	
	String getCalls(DataTableHandler dataTableHandler, User loggedInUser, User userToGetCalls, Locale locale);
	
	public Call getCall(int id);
	
	public void deleteCall(Call call);
	
	public void updateCall(Call call);
	
	public void addAdditionalInfo(AdditionalCallInfo info);
	
	public void updateAdditionalInfo(AdditionalCallInfo info);
	 
	public AdditionalCallInfo getAdditionalInfo(int id);
	
}
