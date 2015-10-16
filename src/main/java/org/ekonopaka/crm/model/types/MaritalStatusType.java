package org.ekonopaka.crm.model.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MARITAL_STATUS_TYPE")
public class MaritalStatusType {

	@Id
	@Column
	@GeneratedValue
	Integer id;

	@Column(name = "CODE")
	String code;

	@Transient
	String description;

	@Column(name = "IS_ENABLED")
	Boolean isEnabled;
	
	@Column(name = "HAS_SPOUSE")
	Boolean hasSpouse;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Boolean getHasSpouse() {
		return hasSpouse;
	}

	public void setHasSpouse(Boolean hasSpouse) {
		this.hasSpouse = hasSpouse;
	}
	
	public MaritalStatusType(int id, String code, Boolean isEnabled, Boolean hasSpouse)	{
		this.id = id;
		this.code = code;
		this.isEnabled = isEnabled;
		this.hasSpouse = hasSpouse;
	}
	
	public MaritalStatusType()	{
		
	}
	
}
