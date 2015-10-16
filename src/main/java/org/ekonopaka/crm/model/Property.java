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

import org.ekonopaka.crm.model.types.PropertyHistoryType;
import org.ekonopaka.crm.model.types.PropertyType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "PROPERTY")
public class Property {
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	// Car property
	
	@Column(name = "CAR_PRESENT")
	private Boolean isCarPresent;
	
	@Size(min=2, max=30)
	@Pattern(regexp = "([\\p{L}\\d\\s-])*")
	@Column(name = "CAR_BRAND")
	private String carBrand;
	
	@Column(name = "CAR_RELEASE_YEAR")
	private String carReleaseYear;
	
	// Estate Property (EP)
	
	@Column(name = "EP_PRESENT")
	private Boolean isEPPresent;
	
	@Size(min = 2, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d-\\/\\.,])*")
	@Column(name = "EP_ADDRESS")
	private String epAddress;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "EP_AREA")
	private Integer epArea;
	
	@Range(min = 0, max = 20)
	@Column(name = "EP_ROOM_NUMBER")
	private Integer epRoomNumber;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "EP_PRICE")
	private Integer epPrice;
	
	@Column(name = "EP_PURCHASE_YEAR")
	private String epPurchaseYear;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private PropertyType epPropertyType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private PropertyHistoryType epPropertyHistoryType;
	
	// Ground Area Property (EP)
	
	@Column(name = "GA_PRESENT")
	private Boolean isGAPresent;
	
	@Size(min = 2, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d-\\/\\.,])*")
	@Column(name = "GA_ADDRESS")
	private String gaAddress;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "GA_AREA")
	private Integer gaArea;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private PropertyType gaPropertyType;

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

	public Boolean getIsCarPresent() {
		return isCarPresent;
	}

	public void setIsCarPresent(Boolean isCarPresent) {
		this.isCarPresent = isCarPresent;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarReleaseYear() {
		return carReleaseYear;
	}

	public void setCarReleaseYear(String carReleaseYear) {
		this.carReleaseYear = carReleaseYear;
	}

	public Boolean getIsEPPresent() {
		return isEPPresent;
	}

	public void setIsEPPresent(Boolean isEPPresent) {
		this.isEPPresent = isEPPresent;
	}

	public String getEpAddress() {
		return epAddress;
	}

	public void setEpAddress(String epAddress) {
		this.epAddress = epAddress;
	}

	public Integer getEpArea() {
		return epArea;
	}

	public void setEpArea(Integer epArea) {
		this.epArea = epArea;
	}

	public Integer getEpRoomNumber() {
		return epRoomNumber;
	}

	public void setEpRoomNumber(Integer epRoomNumber) {
		this.epRoomNumber = epRoomNumber;
	}

	public Integer getEpPrice() {
		return epPrice;
	}

	public void setEpPrice(Integer epPrice) {
		this.epPrice = epPrice;
	}

	public String getEpPurchaseYear() {
		return epPurchaseYear;
	}

	public void setEpPurchaseYear(String epPurchaseYear) {
		this.epPurchaseYear = epPurchaseYear;
	}

	public PropertyType getEpPropertyType() {
		return epPropertyType;
	}

	public void setEpPropertyType(PropertyType epPropertyType) {
		this.epPropertyType = epPropertyType;
	}

	public PropertyHistoryType getEpPropertyHistoryType() {
		return epPropertyHistoryType;
	}

	public void setEpPropertyHistoryType(PropertyHistoryType epPropertyHistoryType) {
		this.epPropertyHistoryType = epPropertyHistoryType;
	}

	public Boolean getIsGAPresent() {
		return isGAPresent;
	}

	public void setIsGAPresent(Boolean isGAPresent) {
		this.isGAPresent = isGAPresent;
	}

	public String getGaAddress() {
		return gaAddress;
	}

	public void setGaAddress(String gaAddress) {
		this.gaAddress = gaAddress;
	}

	public Integer getGaArea() {
		return gaArea;
	}

	public void setGaArea(Integer gaArea) {
		this.gaArea = gaArea;
	}

	public PropertyType getGaPropertyType() {
		return gaPropertyType;
	}

	public void setGaPropertyType(PropertyType gaPropertyType) {
		this.gaPropertyType = gaPropertyType;
	}
	
}
