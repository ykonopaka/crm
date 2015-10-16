package org.ekonopaka.crm.service.interfaces;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.User;

public interface IDealService {
	
	public void addDeal(Deal deal);
	
	public Deal getDeal(int id);
	
	public void deleteDeal(Deal deal);
	
	public void updateDeal(Deal deal);
	
	public Deal createDeal();
	
	public void updateDeal(Deal deal, int step, String continueLink);
	
	String getDeals(DataTableHandler dataTableHandler, User currentUser, User userToGetDeals, Locale locale) throws UnsupportedEncodingException;

	Deal getDeal(int id, Locale locale);
	
	public List<Deal> getMyActiveDeals(User user, Locale locale); 
	
}
