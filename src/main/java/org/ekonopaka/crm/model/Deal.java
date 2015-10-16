package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.ekonopaka.crm.model.types.DealStateType;
import org.ekonopaka.crm.model.types.DealWorkflowSideType;
import org.ekonopaka.crm.model.types.DealWorkflowType;

@Entity
@Table(name = "DEALS")
public class Deal {
	
	public static int CREDIT_INFO_STEP = 1;
	public static int PERSONAL_DATA_STEP = 2;
	public static int PASSPORT_DATA_STEP = 3;
	public static int MARRIAGE_DATA_STEP = 4;
	public static int ADDRESS_DATA_STEP = 5;
	public static int PHONE_DATA_STEP = 6;
	public static int CONTACT_PEOPLE_DATA_STEP = 7;
	public static int WORKING_PLACE_DATA_STEP = 8;
	public static int ADDITIONAL_WORKING_PLACE_DATA_STEP = 9;
	public static int PREVIOUS_WORKING_PLACE_DATA_STEP = 10;
	public static int INCOME_OUTCOME_DATA_STEP = 11;
	public static int PROPERTY_DATA_STEP = 12;
	public static int FINISHED = 13;
	
	public static int OPERATOR_SIDE = 1;
	public static int COORDINATOR_SIDE = 2;
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private User user;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Credit credit;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Customer customer;
	
	@Column(name = "CREATION_DATE")
	Date creationDate;
	
	@Column(name = "MODIFICATION_DATE")
	Date modificationDate;
	
	@Column(name = "STEP")
	private Integer step;
	
	@Column(name = "CONTINUE_LINK")
	private String continueLink;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private DealStateType dealStateType;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private DealWorkflowSideType dealWorkflowSideType;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private DealWorkflowType dealWorkflowType;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getContinueLink() {
		return continueLink;
	}

	public void setContinueLink(String continueLink) {
		this.continueLink = continueLink;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public DealStateType getDealStateType() {
		return dealStateType;
	}

	public void setDealStateType(DealStateType dealStateType) {
		this.dealStateType = dealStateType;
	}

	public DealWorkflowSideType getDealWorkflowSideType() {
		return dealWorkflowSideType;
	}

	public void setDealWorkflowSideType(DealWorkflowSideType dealWorkflowSideType) {
		this.dealWorkflowSideType = dealWorkflowSideType;
	}

	public DealWorkflowType getDealWorkflowType() {
		return dealWorkflowType;
	}

	public void setDealWorkflowType(DealWorkflowType dealWorkflowType) {
		this.dealWorkflowType = dealWorkflowType;
	}

}
