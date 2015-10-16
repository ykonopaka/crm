package org.ekonopaka.crm.model.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CREDIT_FORM_TYPES")
public class CreditFormType {

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

	public CreditFormType(int id, String code, Boolean isEnabled)	{
		this.id = id;
		this.code = code;
		this.isEnabled = isEnabled;
	}
	
	public CreditFormType()	{
		
	}

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
	
}
