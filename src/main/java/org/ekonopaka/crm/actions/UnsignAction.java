package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class UnsignAction extends Action {

	public UnsignAction(Deal deal) {
		super(deal);
		this.code = Action.UNSIGN;
		this.link = "workflow/action/unsign/deal/" + deal.getId();
	}

}
