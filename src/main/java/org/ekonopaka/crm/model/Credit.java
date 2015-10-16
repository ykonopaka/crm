package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.ekonopaka.crm.model.types.CreditObjectiveType;
import org.ekonopaka.crm.model.types.CreditType;
import org.ekonopaka.crm.model.types.CurrencyType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "CREDITS")
public class Credit {

	@Id
	@Column
	@GeneratedValue
	Integer id;

	@ManyToOne
	@PrimaryKeyJoinColumn
	CreditType creditType;

	@Column(name = "IS_ENABLED")
	Boolean isEnabled;
	
	@Column(name = "IS_DEAL_CREDIT")
	Boolean isDealCredit;

	@Range(min = 1, max = 1000000000)
	@Column(name = "AMOUNT_OF_MONEY")
	Integer amountOfMoney;

	@Range(min = 1, max = 1000000000)
	@Column(name = "TERM")
	Integer term;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	CreditObjectiveType creditObjectiveType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	CurrencyType currencyType;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CreditType getCreditType() {
		return creditType;
	}

	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getIsDealCredit() {
		return isDealCredit;
	}

	public void setIsDealCredit(Boolean isDealCredit) {
		this.isDealCredit = isDealCredit;
	}

	public Integer getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(Integer amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public CreditObjectiveType getCreditObjectiveType() {
		return creditObjectiveType;
	}

	public void setCreditObjectiveType(CreditObjectiveType creditObjectiveType) {
		this.creditObjectiveType = creditObjectiveType;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}
	
}
