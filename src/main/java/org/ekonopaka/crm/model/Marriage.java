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

import org.ekonopaka.crm.model.types.BusinessLineType;
import org.ekonopaka.crm.model.types.JobType;
import org.ekonopaka.crm.model.types.MaritalStatusType;
import org.ekonopaka.crm.model.types.OrganizationType;

@Entity
@Table(name = "MARRIAGES")
public class Marriage {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private MaritalStatusType maritalStatusType;
	
	@Column(name = "REGISTRATION_DATE")
	private Date marriageRegistrationDate;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "PHONE_NUMBER_HOME_WORK")
	private String phoneNumberHomeWork;
	
	@Pattern(regexp = "([0-9\\+\\-])+")
	@Column(name = "PHONE_NUMBER_MOBILE")
	private String phoneNumberMobile;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private JobType jobType;
	
	@Column(name = "ID_TAX_NUMBER")
	private String idTaxNumber;
	
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
	@Size(min = 0, max = 30)
	@Pattern(regexp = "([\\p{L}\\d\\s])*")
	@Column(name = "WORK_PLACE")
	private String workplace;
	
	@Size(min = 0, max = 30)
	@Pattern(regexp = "([\\p{L}\\d\\s])*")
	@Column(name = "POSITION")
	private String position;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private BusinessLineType businessLineType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private OrganizationType organizationType;

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

	public MaritalStatusType getMaritalStatusType() {
		return maritalStatusType;
	}

	public void setMaritalStatusType(MaritalStatusType maritalStatusType) {
		this.maritalStatusType = maritalStatusType;
	}

	public Date getMarriageRegistrationDate() {
		return marriageRegistrationDate;
	}

	public void setMarriageRegistrationDate(Date marriageRegistrationDate) {
		this.marriageRegistrationDate = marriageRegistrationDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumberHomeWork() {
		return phoneNumberHomeWork;
	}

	public void setPhoneNumberHomeWork(String phoneNumberHomeWork) {
		this.phoneNumberHomeWork = phoneNumberHomeWork;
	}

	public String getPhoneNumberMobile() {
		return phoneNumberMobile;
	}

	public void setPhoneNumberMobile(String phoneNumberMobile) {
		this.phoneNumberMobile = phoneNumberMobile;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public String getIdTaxNumber() {
		return idTaxNumber;
	}

	public void setIdTaxNumber(String idTaxNumber) {
		this.idTaxNumber = idTaxNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getWorkplace() {
		return workplace;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public BusinessLineType getBusinessLineType() {
		return businessLineType;
	}

	public void setBusinessLineType(BusinessLineType businessLineType) {
		this.businessLineType = businessLineType;
	}

	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}
	
}
