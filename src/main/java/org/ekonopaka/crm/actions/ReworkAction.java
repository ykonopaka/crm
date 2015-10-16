package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class ReworkAction extends Action {

	public ReworkAction(Deal deal) {
		super(deal);
		this.code = Action.REWORK;
		this.link = "workflow/action/rework/deal/" + deal.getId();
	}

	@Override
	public String getLink() {
		return link;
	}

}
