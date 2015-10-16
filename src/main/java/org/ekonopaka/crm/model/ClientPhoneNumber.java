package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "CLIENT_PHONE_NUMBERS")
public class ClientPhoneNumber {
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Pattern(regexp = "([0-9\\+])*")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "HAS_CLIENT_COME")
	private Boolean hasClientCome;
	
	@Column(name = "IS_HIDDEN")
	private Boolean isHidden;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getHasClientCome() {
		return hasClientCome;
	}

	public void setHasClientCome(Boolean hasClientCome) {
		this.hasClientCome = hasClientCome;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
}
