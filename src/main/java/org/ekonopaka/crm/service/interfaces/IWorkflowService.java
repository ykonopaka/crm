package org.ekonopaka.crm.service.interfaces;

import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.actions.Action;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.User;

public interface IWorkflowService {
	
	List<Action> getAvailableActions(Deal deal, User user, Locale locale);
	
	public void review(Deal deal);
	
	public void reject(Deal deal);
	
	public void approve(Deal deal);
	
	public void sign(Deal deal);
	
	public void unsign(Deal deal);
	
	public void reopen(Deal deal);
	
	public void close(Deal deal);

	public void rework(Deal deal);

}
