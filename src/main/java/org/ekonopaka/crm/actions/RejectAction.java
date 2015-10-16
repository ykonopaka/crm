package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class RejectAction extends Action {

	public RejectAction(Deal deal) {
		super(deal);
		this.code = Action.REJECT;
		this.link = "workflow/action/reject/deal/" + deal.getId();
	}

}
