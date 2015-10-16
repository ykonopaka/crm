package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class CloseAction extends Action {

	public CloseAction(Deal deal) {
		super(deal);
		this.code = Action.CLOSE;
		this.link = "workflow/action/close/deal/" + deal.getId();
	}

}
