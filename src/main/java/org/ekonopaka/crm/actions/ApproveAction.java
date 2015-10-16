package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class ApproveAction extends Action {

	public ApproveAction(Deal deal) {
		super(deal);
		this.code = Action.APPROVE;
		this.link = "workflow/action/approve/deal/" + deal.getId();
	}

}
