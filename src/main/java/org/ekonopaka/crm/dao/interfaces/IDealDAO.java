package org.ekonopaka.crm.dao.interfaces;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.Deal;
import org.ekonopaka.crm.model.User;
import org.hibernate.criterion.Criterion;

public interface IDealDAO {

	public void addDeal(Deal deal);
	
	public Deal getDeal(int id);
	
	public void deleteDeal(Deal deal);
	
	public void updateDeal(Deal deal);
	
	List<Deal> getDeals(DataTableHandler dataTableHandler, User userToGetDeals) throws UnsupportedEncodingException;

	Integer getNumberOfDeals(Criterion criterion, User userToGetDeals);

	Integer getNumberOfDeals(User userToGetDeals);
	
	List<Deal> getOperatorActiveDeals(User user);
	
	List<Deal> getCoordinatorActiveDeals(User user);
	
}
