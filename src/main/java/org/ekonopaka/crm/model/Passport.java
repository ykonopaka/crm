package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PASSPORT_DATA")
public class Passport {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Column(name = "PASSPORT_REGISTRATION_DATE")
	private Date passportRegistrationDate;

	@Pattern(regexp = "(\\p{L}){2}")
	@Column(name = "SERIAL")
	private String serial;

	@Pattern(regexp = "([0-9]){6}")
	@Column(name = "NUMBER")
	private String number;
	
	@Size(min = 2, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d])*")
	@Column(name = "WHO_GAVE_PASSPORT")
	private String whoGavePassport;

	@Column(name = "HAS_OTHER_DOCUMENT")
	private Boolean hasOtherDocument;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s])*")
	@Column(name = "NAME_OF_OTHER_DOCUMENT")
	private String nameOfOtherDocument;
	
	@Pattern(regexp = "([0-9]){10,11}")
	@Column(name = "ID_TAX_NUMBER")
	private String idTaxNumber;
	
	@NotNull
	@Column(name = "IDTAX_REGISTRATION_DATE")
	private Date idTaxRegistrationDate;
	
	@Size(min = 2, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d])*")
	@Column(name = "WHO_GAVE_IDTAX")
	private String whoGaveIdtax;
	
	@Column(name = "IS_ENABLED")
	Boolean isEnabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getPassportRegistrationDate() {
		return passportRegistrationDate;
	}

	public void setPassportRegistrationDate(Date passportRegistrationDate) {
		this.passportRegistrationDate = passportRegistrationDate;
	}

	public String getWhoGavePassport() {
		return whoGavePassport;
	}

	public void setWhoGavePassport(String whoGavePassport) {
		this.whoGavePassport = whoGavePassport;
	}

	public Boolean getHasOtherDocument() {
		return hasOtherDocument;
	}

	public void setHasOtherDocument(Boolean hasOtherDocument) {
		this.hasOtherDocument = hasOtherDocument;
	}

	public String getNameOfOtherDocument() {
		return nameOfOtherDocument;
	}

	public void setNameOfOtherDocument(String nameOfOtherDocument) {
		this.nameOfOtherDocument = nameOfOtherDocument;
	}

	public String getIdTaxNumber() {
		return idTaxNumber;
	}

	public void setIdTaxNumber(String idTaxNumber) {
		this.idTaxNumber = idTaxNumber;
	}

	public Date getIdtaxRegistrationDate() {
		return idTaxRegistrationDate;
	}

	public void setIdtaxRegistrationDate(Date idTaxRegistrationDate) {
		this.idTaxRegistrationDate = idTaxRegistrationDate;
	}

	public String getWhoGaveIdtax() {
		return whoGaveIdtax;
	}

	public void setWhoGaveIdtax(String whoGaveIdtax) {
		this.whoGaveIdtax = whoGaveIdtax;
	}

	public Date getIdTaxRegistrationDate() {
		return idTaxRegistrationDate;
	}

	public void setIdTaxRegistrationDate(Date idTaxRegistrationDate) {
		this.idTaxRegistrationDate = idTaxRegistrationDate;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

}
