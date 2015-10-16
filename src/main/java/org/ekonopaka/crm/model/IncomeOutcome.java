package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.ekonopaka.crm.model.types.IncomeType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "INCOMES_OUTCOMES")
public class IncomeOutcome {
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;
	
	@NotNull
	@Range(min = 0, max = 1000000000)
	@Column(name = "MAIN_INCOME_SIZE")
	private Integer mainIncomeSize;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private IncomeType mainIncomeType;
	
	@Column(name = "DOCUMENTS_PRESENT")
	private Boolean areDocumentsPresent;
	
	@Column(name = "ADDITIONAL_INCOME")
	private Boolean isAdditionalIncomePresent;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "ADDITIONAL_INCOME_SIZE")
	private Integer additionalIncomeSize;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private IncomeType additionalIncomeType;
	
	@Column(name = "IS_MARRIED")
	private Boolean isMarried;
	
	@Range(min = 0, max = 1000000000)
	@Column(name = "SPOUSE_INCOME_SIZE")
	private Integer spouseIncomeSize;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private IncomeType spouseIncomeType;
	
	@NotNull
	@Range(min = 0, max = 1000000000)
	@Column(name = "TOTAL_OUTCOME")
	private Integer totalOutcome;

	@NotNull
	@Range(min = 0, max = 20)
	@Column(name = "FAMILY_PEOPLE_NUMBER")
	private Integer familyPeopleNumber;


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

	public Integer getMainIncomeSize() {
		return mainIncomeSize;
	}

	public void setMainIncomeSize(Integer mainIncomeSize) {
		this.mainIncomeSize = mainIncomeSize;
	}

	public IncomeType getMainIncomeType() {
		return mainIncomeType;
	}

	public void setMainIncomeType(IncomeType mainIncomeType) {
		this.mainIncomeType = mainIncomeType;
	}

	public Boolean getAreDocumentsPresent() {
		return areDocumentsPresent;
	}

	public void setAreDocumentsPresent(Boolean areDocumentsPresent) {
		this.areDocumentsPresent = areDocumentsPresent;
	}

	public Boolean getIsAdditionalIncomePresent() {
		return isAdditionalIncomePresent;
	}

	public void setIsAdditionalIncomePresent(Boolean isAdditionalIncomePresent) {
		this.isAdditionalIncomePresent = isAdditionalIncomePresent;
	}

	public Integer getAdditionalIncomeSize() {
		return additionalIncomeSize;
	}

	public void setAdditionalIncomeSize(Integer additionalIncomeSize) {
		this.additionalIncomeSize = additionalIncomeSize;
	}

	public IncomeType getAdditionalIncomeType() {
		return additionalIncomeType;
	}

	public void setAdditionalIncomeType(IncomeType additionalIncomeType) {
		this.additionalIncomeType = additionalIncomeType;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}

	public Integer getSpouseIncomeSize() {
		return spouseIncomeSize;
	}

	public void setSpouseIncomeSize(Integer spouseIncomeSize) {
		this.spouseIncomeSize = spouseIncomeSize;
	}

	public IncomeType getSpouseIncomeType() {
		return spouseIncomeType;
	}

	public void setSpouseIncomeType(IncomeType spouseIncomeType) {
		this.spouseIncomeType = spouseIncomeType;
	}

	public Integer getTotalOutcome() {
		return totalOutcome;
	}

	public void setTotalOutcome(Integer totalOutcome) {
		this.totalOutcome = totalOutcome;
	}

	public Integer getFamilyPeopleNumber() {
		return familyPeopleNumber;
	}

	public void setFamilyPeopleNumber(Integer familyPeopleNumber) {
		this.familyPeopleNumber = familyPeopleNumber;
	}

}
