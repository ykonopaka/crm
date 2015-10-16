package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.ContactPersonType;

@Entity
@Table(name = "CONTACT_PERSONS")
public class ContactPersons {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FP_FIRST_NAME")
	private String fpFirstName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FP_MIDDLE_NAME")
	private String fpMiddleName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FP_LAST_NAME")
	private String fpLastName;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private ContactPersonType fpContactPersonType;
	
	@Size(min = 0, max = 30)
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "FP_MOBILE_NUMBER")
	private String fpMobileNumber;
	
	@Size(min = 0, max = 30)
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "FP_HOME_WORK_NUMBER")
	private String fpHomeWorkNumber;
	
	@Column(name = "FP_BIRTH_DATE")
	private Date fpBirthDate;
	
	@Size(min = 0, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d-\\/\\.,])*")
	@Column(name = "FP_ADDRESS")
	private String fpAddress;
	
	@Column(name = "SP_EXIST")
	private Boolean spExist;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "SP_FIRST_NAME")
	private String spFirstName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "SP_MIDDLE_NAME")
	private String spMiddleName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "SP_LAST_NAME")
	private String spLastName;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private ContactPersonType spContactPersonType;
	
	@Size(min = 0, max = 30)
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "SP_MOBILE_NUMBER")
	private String spMobileNumber;
	
	@Size(min = 0, max = 30)
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "SP_HOME_WORK_NUMBER")
	private String spHomeWorkNumber;
	
	@Column(name = "SP_BIRTH_DATE")
	private Date spBirthDate;
	
	@Size(min = 0, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d-\\/\\.,])*")
	@Column(name = "SP_ADDRESS")
	private String spAddress;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFpFirstName() {
		return fpFirstName;
	}

	public void setFpFirstName(String fpFirstName) {
		this.fpFirstName = fpFirstName;
	}

	public String getFpMiddleName() {
		return fpMiddleName;
	}

	public void setFpMiddleName(String fpMiddleName) {
		this.fpMiddleName = fpMiddleName;
	}

	public String getFpLastName() {
		return fpLastName;
	}

	public void setFpLastName(String fpLastName) {
		this.fpLastName = fpLastName;
	}

	public ContactPersonType getFpContactPersonType() {
		return fpContactPersonType;
	}

	public void setFpContactPersonType(ContactPersonType fpContactPersonType) {
		this.fpContactPersonType = fpContactPersonType;
	}

	public String getFpMobileNumber() {
		return fpMobileNumber;
	}

	public void setFpMobileNumber(String fpMobileNumber) {
		this.fpMobileNumber = fpMobileNumber;
	}

	public String getFpHomeWorkNumber() {
		return fpHomeWorkNumber;
	}

	public void setFpHomeWorkNumber(String fpHomeWorkNumber) {
		this.fpHomeWorkNumber = fpHomeWorkNumber;
	}

	public Date getFpBirthDate() {
		return fpBirthDate;
	}

	public void setFpBirthDate(Date fpBirthDate) {
		this.fpBirthDate = fpBirthDate;
	}

	public String getFpAddress() {
		return fpAddress;
	}

	public void setFpAddress(String fpAddress) {
		this.fpAddress = fpAddress;
	}

	public Boolean getSpExist() {
		return spExist;
	}

	public void setSpExist(Boolean spExist) {
		this.spExist = spExist;
	}

	public String getSpFirstName() {
		return spFirstName;
	}

	public void setSpFirstName(String spFirstName) {
		this.spFirstName = spFirstName;
	}

	public String getSpMiddleName() {
		return spMiddleName;
	}

	public void setSpMiddleName(String spMiddleName) {
		this.spMiddleName = spMiddleName;
	}

	public String getSpLastName() {
		return spLastName;
	}

	public void setSpLastName(String spLastName) {
		this.spLastName = spLastName;
	}

	public ContactPersonType getSpContactPersonType() {
		return spContactPersonType;
	}

	public void setSpContactPersonType(ContactPersonType spContactPersonType) {
		this.spContactPersonType = spContactPersonType;
	}

	public String getSpMobileNumber() {
		return spMobileNumber;
	}

	public void setSpMobileNumber(String spMobileNumber) {
		this.spMobileNumber = spMobileNumber;
	}

	public String getSpHomeWorkNumber() {
		return spHomeWorkNumber;
	}

	public void setSpHomeWorkNumber(String spHomeWorkNumber) {
		this.spHomeWorkNumber = spHomeWorkNumber;
	}

	public Date getSpBirthDate() {
		return spBirthDate;
	}

	public void setSpBirthDate(Date spBirthDate) {
		this.spBirthDate = spBirthDate;
	}

	public String getSpAddress() {
		return spAddress;
	}

	public void setSpAddress(String spAddress) {
		this.spAddress = spAddress;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	
}
