package org.ekonopaka.crm.actions;

import org.ekonopaka.crm.model.Deal;

public abstract class Action {

	public static String REVIEW = 	"action.coordinator.review.deal.workflow.state.type";
	public static String REJECT = 	"action.coordinator.rejected.deal.workflow.state.type";
	public static String APPROVE = 	"action.coordinator.approved.deal.workflow.state.type";
	public static String SIGN = 	"action.operator.documents.signed.deal.workflow.state.type";
	public static String UNSIGN = 	"action.operator.documents.unsigned.deal.workflow.state.type";
	public static String REWORK = 	"action.coordinator.rework.deal.workflow.state.type";
	public static String CLOSE = 	"action.operator.close.deal.workflow.state.type";
	
	String name;
	String code;
	String link;
	Deal deal;
	
	public Action(Deal deal) {
		this.deal = deal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
