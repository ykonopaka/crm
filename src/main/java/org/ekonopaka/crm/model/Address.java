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

import org.ekonopaka.crm.model.types.RegionType;

@Entity
@Table(name = "ADDRESSES")
public class Address {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private RegionType rRegionType;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "R_TOWN")
	private String rTown;
	
	@Size(max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "R_DISTRICT")
	private String rDistrict;

	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "R_STREET")
	private String rStreet;

	@Size(min=1, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-\\/])*")
	@Column(name = "R_HOUSE")
	private String rHouse;

	@Size(max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-\\/])*")
	@Column(name = "R_BUILDING")
	private String rBuilding;

	@Size(max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-\\/])*")
	@Column(name = "R_APARTMENT")
	private String rApartment;

	@Pattern(regexp = "([\\p{L}\\d\\s-]){5,6}")
	@Column(name = "R_POSTCODE")
	private String rPostcode;
	
	@NotNull
	@Column(name = "R_REGISTRATION_DATE")
	private Date rRegistrationDate;

	@Column(name = "R_TERM_OF_LIVING")
	private Integer rTermOfLiving;
	
	@Column(name = "REGISTRATION_IS_ACTUAL")
	private Boolean registrationIsActual;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private RegionType aRegionType;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "A_TOWN")
	private String aTown;

	@Size(max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "A_DISTRICT")
	private String aDistrict;

	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "A_STREET")
	private String aStreet;

	@Size(min=1, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-\\/])*")
	@Column(name = "A_HOUSE")
	private String aHouse;

	@Size(max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-\\/])*")
	@Column(name = "A_BUILDING")
	private String aBuilding;

	@Size(max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-\\/])*")
	@Column(name = "A_APARTMENT")
	private String aApartment;

	@Pattern(regexp = "([\\p{L}\\s\\d]){5,6}")
	@Column(name = "A_POSTCODE")
	private String aPostcode;

	@Column(name = "A_TERM_OF_LIVING")
	private Integer aTermOfLiving;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegionType getrRegionType() {
		return rRegionType;
	}

	public void setrRegionType(RegionType rRegionType) {
		this.rRegionType = rRegionType;
	}

	public String getrDistrict() {
		return rDistrict;
	}

	public void setrDistrict(String rDistrict) {
		this.rDistrict = rDistrict;
	}

	public String getrStreet() {
		return rStreet;
	}

	public void setrStreet(String rStreet) {
		this.rStreet = rStreet;
	}

	public String getrHouse() {
		return rHouse;
	}

	public void setrHouse(String rHouse) {
		this.rHouse = rHouse;
	}

	public String getrBuilding() {
		return rBuilding;
	}

	public void setrBuilding(String rBuilding) {
		this.rBuilding = rBuilding;
	}

	public String getrApartment() {
		return rApartment;
	}

	public void setrApartment(String rApartment) {
		this.rApartment = rApartment;
	}

	public String getrPostcode() {
		return rPostcode;
	}

	public void setrPostcode(String rPostcode) {
		this.rPostcode = rPostcode;
	}

	public Date getrRegistrationDate() {
		return rRegistrationDate;
	}

	public void setrRegistrationDate(Date rRegistrationDate) {
		this.rRegistrationDate = rRegistrationDate;
	}

	public Boolean getRegistrationIsActual() {
		return registrationIsActual;
	}

	public void setRegistrationIsActual(Boolean registrationIsActual) {
		this.registrationIsActual = registrationIsActual;
	}

	public RegionType getaRegionType() {
		return aRegionType;
	}

	public void setaRegionType(RegionType aRegionType) {
		this.aRegionType = aRegionType;
	}

	public String getaDistrict() {
		return aDistrict;
	}

	public void setaDistrict(String aDistrict) {
		this.aDistrict = aDistrict;
	}

	public String getaStreet() {
		return aStreet;
	}

	public void setaStreet(String aStreet) {
		this.aStreet = aStreet;
	}

	public String getaHouse() {
		return aHouse;
	}

	public void setaHouse(String aHouse) {
		this.aHouse = aHouse;
	}

	public String getaBuilding() {
		return aBuilding;
	}

	public void setaBuilding(String aBuilding) {
		this.aBuilding = aBuilding;
	}

	public String getaApartment() {
		return aApartment;
	}

	public void setaApartment(String aApartment) {
		this.aApartment = aApartment;
	}

	public String getaPostcode() {
		return aPostcode;
	}

	public void setaPostcode(String aPostcode) {
		this.aPostcode = aPostcode;
	}

	public String getrTown() {
		return rTown;
	}

	public void setrTown(String rTown) {
		this.rTown = rTown;
	}

	public String getaTown() {
		return aTown;
	}

	public void setaTown(String aTown) {
		this.aTown = aTown;
	}

	public Integer getrTermOfLiving() {
		return rTermOfLiving;
	}

	public void setrTermOfLiving(Integer rTermOfLiving) {
		this.rTermOfLiving = rTermOfLiving;
	}

	public Integer getaTermOfLiving() {
		return aTermOfLiving;
	}

	public void setaTermOfLiving(Integer aTermOfLiving) {
		this.aTermOfLiving = aTermOfLiving;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}
