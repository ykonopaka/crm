package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public class ReviewAction extends Action {

	public ReviewAction(Deal deal) {
		super(deal);
		this.code = Action.REVIEW;
		this.link = "workflow/action/review/deal/" + deal.getId();
	}

	@Override
	public String getLink() {
		return link;
	}

}
