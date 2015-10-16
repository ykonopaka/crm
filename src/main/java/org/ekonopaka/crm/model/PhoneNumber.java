package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Size(min = 3, max = 30)
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "IS_ENABLED")
	Boolean isEnabled;

	@ManyToOne
	@PrimaryKeyJoinColumn
	Office office;

	@Column(name = "IS_MOBILE")
	Boolean isMobile;
	
	@Transient
	String phoneFullName;
	
	@Transient
	String phoneFullNameLocalized;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Boolean getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}

	public String getPhoneFullName() {
		if (isMobile)
			return phoneNumber + " - " + "mobile.phone.label";
		else 
			return phoneNumber + " - " + office.getName();
	}

	public void setPhoneFullName(String phoneFullName) {
		this.phoneFullName = phoneFullName;
	}

	public String getPhoneFullNameLocalized() {
		return phoneFullNameLocalized;
	}

	public void setPhoneFullNameLocalized(String phoneFullNameLocalized) {
		this.phoneFullNameLocalized = phoneFullNameLocalized;
	}
	
}
