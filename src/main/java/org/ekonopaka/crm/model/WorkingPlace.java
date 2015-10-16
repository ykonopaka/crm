package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.BusinessLineType;
import org.ekonopaka.crm.model.types.CompanySizeType;
import org.ekonopaka.crm.model.types.JobType;
import org.ekonopaka.crm.model.types.OrganizationType;
import org.ekonopaka.crm.model.types.PositionType;
import org.ekonopaka.crm.model.types.RegionType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "WORKING_PLACES")
public class WorkingPlace {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@NotNull
	@Column(name = "STARTING_DATE")
	private Date startingDate;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	private String organizationName;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private JobType jobType;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	private String EDRPOUcode;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private PositionType positionType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private BusinessLineType businessLineType;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "NUMBER_OF_WORKERS")
	private Integer numberOfWorkers;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CompanySizeType companySizeType;

	@Range(min = 0, max = 1000000000)
	@Column(name = "LENGTH_OF_SERVICE_LAST_PLACE")
	private Integer lengthOfServiceLastPlace;

	@Range(min = 0, max = 1000000000)
	@Column(name = "LENGTH_OF_SERVICE_TOTAL")
	private Integer lengthOfServiceTotal;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	private String positionName;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private OrganizationType organizationType;
	
	@Range(min=1934, max=2099)
	@Column(name = "COMPANY_EXISTING_TERM")
	private Integer companyExistingTerm;
	
	@ManyToOne
	@PrimaryKeyJoinColumn	
	private RegionType regionType;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "TOWN")
	private String town;
	
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "DISTRICT")
	private String district;

	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-])*")
	@Column(name = "STREET")
	private String street;

	@Size(min=1, max=30)
	@Pattern(regexp = "([\\p{L}\\s\\d-\\/])*")
	@Column(name = "HOUSE")
	private String house;

	@Pattern(regexp = "([\\p{L}\\s\\d-\\/])*")
	@Column(name = "BUILDING")
	private String building;

	@Pattern(regexp = "([\\p{L}\\s\\d-\\/])*")
	@Column(name = "OFFICE")
	private String office;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([0-9\\+\\-])*")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Pattern(regexp = "([\\p{L}\\d\\s-]){5,6}")
	@Column(name = "POSTCODE")
	private String postcode;

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public String getEDRPOUcode() {
		return EDRPOUcode;
	}

	public void setEDRPOUcode(String eDRPOUcode) {
		EDRPOUcode = eDRPOUcode;
	}

	public PositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(PositionType positionType) {
		this.positionType = positionType;
	}

	public BusinessLineType getBusinessLineType() {
		return businessLineType;
	}

	public void setBusinessLineType(BusinessLineType businessLineType) {
		this.businessLineType = businessLineType;
	}

	public Integer getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(Integer numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	public CompanySizeType getCompanySizeType() {
		return companySizeType;
	}

	public void setCompanySizeType(CompanySizeType companySizeType) {
		this.companySizeType = companySizeType;
	}

	public Integer getLengthOfServiceLastPlace() {
		return lengthOfServiceLastPlace;
	}

	public void setLengthOfServiceLastPlace(Integer lengthOfServiceLastPlace) {
		this.lengthOfServiceLastPlace = lengthOfServiceLastPlace;
	}

	public Integer getLengthOfServiceTotal() {
		return lengthOfServiceTotal;
	}

	public void setLengthOfServiceTotal(Integer lengthOfServiceTotal) {
		this.lengthOfServiceTotal = lengthOfServiceTotal;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}

	public Integer getCompanyExistingTerm() {
		return companyExistingTerm;
	}

	public void setCompanyExistingTerm(Integer companyExistingTerm) {
		this.companyExistingTerm = companyExistingTerm;
	}

	public RegionType getRegionType() {
		return regionType;
	}

	public void setRegionType(RegionType regionType) {
		this.regionType = regionType;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
