package org.ekonopaka.crm.service.impl;

import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.dao.interfaces.ICallDAO;
import org.ekonopaka.crm.handlers.DateFormatter;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.handlers.json.OptionsColumnHandler;
import org.ekonopaka.crm.model.AdditionalCallInfo;
import org.ekonopaka.crm.model.Call;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.ICallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CallService implements ICallService {

	@Autowired
	ICallDAO callDAO;
	
	@Autowired
	OptionsColumnHandler optionsColumnHandler;
	
	@Autowired
	DateFormatter dateFormatter;
	
	@Override
	@Transactional
	public void addCall(Call call) {
		callDAO.add(call);
	}

	@Override
	public String getCalls(DataTableHandler dataTableHandler, User loggedInUser, User userToGetCalls, Locale locale) {
		
		List<Call> calls;
		
		if (loggedInUser.getIsAdmin())	{
			calls = callDAO.getCalls(dataTableHandler, null);
		} else {
			calls = callDAO.getCalls(dataTableHandler, loggedInUser);
		}
		
		String[][] aaData = new String[calls.size()][7];
		
		for (int i = 0; i < calls.size(); i++) {
			aaData[i][0] = String.valueOf(calls.get(i).getId());
			aaData[i][1] = String.valueOf(calls.get(i).getClient().getFullName());
			aaData[i][2] = String.valueOf(calls.get(i).getClientPhoneNumber().getPhoneNumber());
			aaData[i][3] = String.valueOf(calls.get(i).getUser().getLastName() + " " + calls.get(i).getUser().getFirstName());
			aaData[i][4] = String.valueOf(calls.get(i).getUser().getOffice().getName());
			aaData[i][5] = dateFormatter.format(calls.get(i).getDate());
			
			if (loggedInUser.getIsAdmin() == true || calls.get(i).getUser().getUsername().equals(loggedInUser.getUsername()))	{
				aaData[i][6] = optionsColumnHandler.getCallsOptionsBlockOwner(
					calls.get(i), 
					"popup.calls.table.options.view", 
					"popup.calls.table.options.edit", 
					"popup.calls.table.options.delete", 
					locale);
			} else {
				aaData[i][6] = optionsColumnHandler.getCallsOptionsBlockNotOwner(calls.get(i), "popup.calls.table.options.view", locale);
			}
		}

		dataTableHandler.setData(aaData);
		
		return dataTableHandler.getResponse();
	}

	@Override
	@Transactional
	public Call getCall(int id) {
		return callDAO.get(id);
	}

	@Override
	@Transactional
	public void deleteCall(Call call) {
		callDAO.delete(call);
	}

	@Override
	@Transactional
	public void updateCall(Call call) {
		callDAO.update(call);
	}

	@Override
	@Transactional
	public void addAdditionalInfo(AdditionalCallInfo info) {
		callDAO.addAdditionalInfo(info);
		
	}

	@Override
	@Transactional
	public AdditionalCallInfo getAdditionalInfo(int id) {
		return callDAO.getAdditionalInfo(id);
	}

	@Override
	@Transactional
	public void updateAdditionalInfo(AdditionalCallInfo info) {
		callDAO.updateAdditionalInfo(info);
	}

}
