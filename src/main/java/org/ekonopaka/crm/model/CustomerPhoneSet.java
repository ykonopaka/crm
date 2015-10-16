package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CUSTOMER_PHONE_SET")
public class CustomerPhoneSet {

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@NotEmpty
	@Pattern(regexp = "([0-9\\+])*")
	@Column(name = "PHONE_NUMBER_MOBILE_1")
	private String phoneNumberMobile1;
	
	@Pattern(regexp = "([0-9\\+])*")
	@Column(name = "PHONE_NUMBER_MOBILE_2")
	private String phoneNumberMobile2;
	
	@Pattern(regexp = "([0-9\\+])*")
	@Column(name = "PHONE_NUMBER_REGISTRATION")
	private String phoneNumberRegistration;
	
	@Pattern(regexp = "([0-9\\+])*")
	@Column(name = "PHONE_NUMBER_ACTUAL")
	private String phoneNumberActual;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoneNumberMobile1() {
		return phoneNumberMobile1;
	}

	public void setPhoneNumberMobile1(String phoneNumberMobile1) {
		this.phoneNumberMobile1 = phoneNumberMobile1;
	}

	public String getPhoneNumberMobile2() {
		return phoneNumberMobile2;
	}

	public void setPhoneNumberMobile2(String phoneNumberMobile2) {
		this.phoneNumberMobile2 = phoneNumberMobile2;
	}

	public String getPhoneNumberRegistration() {
		return phoneNumberRegistration;
	}

	public void setPhoneNumberRegistration(String phoneNumberRegistration) {
		this.phoneNumberRegistration = phoneNumberRegistration;
	}

	public String getPhoneNumberActual() {
		return phoneNumberActual;
	}

	public void setPhoneNumberActual(String phoneNumberActual) {
		this.phoneNumberActual = phoneNumberActual;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	
}
