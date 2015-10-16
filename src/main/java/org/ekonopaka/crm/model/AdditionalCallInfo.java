package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.InterestType;

@Entity
@Table(name = "ADDITIONAL_CALL_INFOS")
public class AdditionalCallInfo {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@Column(name = "WERE_CREDITS_EARLIER")
	private Boolean wereCreditsEarlier;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private InterestType interestType;
	
	@Size(min = 0, max = 255)
	private String banksClientContactedWith;
	
	@Size(min = 0, max = 255)
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Boolean getWereCreditsEarlier() {
		return wereCreditsEarlier;
	}

	public void setWereCreditsEarlier(Boolean wereCreditsEarlier) {
		this.wereCreditsEarlier = wereCreditsEarlier;
	}

	public InterestType getInterestType() {
		return interestType;
	}

	public void setInterestType(InterestType interestType) {
		this.interestType = interestType;
	}

	public String getBanksClientContactedWith() {
		return banksClientContactedWith;
	}

	public void setBanksClientContactedWith(String banksClientContactedWith) {
		this.banksClientContactedWith = banksClientContactedWith;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
