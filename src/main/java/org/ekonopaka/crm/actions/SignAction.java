package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class SignAction extends Action {

	public SignAction(Deal deal) {
		super(deal);
		this.code = Action.SIGN;	
		this.link = "workflow/action/sign/deal/" + deal.getId();
	}

}
