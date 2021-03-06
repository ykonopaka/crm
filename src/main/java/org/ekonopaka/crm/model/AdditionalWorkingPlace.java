package org.ekonopaka.crm.model;

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
import org.ekonopaka.crm.model.types.CompanySizeType;
import org.ekonopaka.crm.model.types.OrganizationType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "ADDITIONAL_WORKING_PLACES")
public class AdditionalWorkingPlace {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@Column(name = "EXISTED")
	private Boolean isExisted;
	
	@Range(min=1934, max=2099)
	@Column(name = "WORKING_TERM_FROM")
	private Integer workingTermFrom;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s\\d])*")
	private String organizationName;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	private String positionName;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private BusinessLineType businessLineType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private OrganizationType organizationType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CompanySizeType companySizeType;
	
	@Size(min = 2, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d-\\/\\.,])*")
	private String address;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Range(min=1934, max=2099)
	@Column(name = "COMPANY_EXISTING_TERM")
	private Integer companyExistingTerm;

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

	public Boolean getIsExisted() {
		return isExisted;
	}

	public void setIsExisted(Boolean isExisted) {
		this.isExisted = isExisted;
	}

	public Integer getWorkingTermFrom() {
		return workingTermFrom;
	}

	public void setWorkingTermFrom(Integer workingTermFrom) {
		this.workingTermFrom = workingTermFrom;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public BusinessLineType getBusinessLineType() {
		return businessLineType;
	}

	public void setBusinessLineType(BusinessLineType businessLineType) {
		this.businessLineType = businessLineType;
	}

	public CompanySizeType getCompanySizeType() {
		return companySizeType;
	}

	public void setCompanySizeType(CompanySizeType companySizeType) {
		this.companySizeType = companySizeType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCompanyExistingTerm() {
		return companyExistingTerm;
	}

	public void setCompanyExistingTerm(Integer companyExistingTerm) {
		this.companyExistingTerm = companyExistingTerm;
	}

	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}
	
}
