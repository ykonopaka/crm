package org.ekonopaka.crm.model.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "EMPLOYMENT_TYPES")
public class EmploymentType {

	@Id
	@Column
	@GeneratedValue
	Integer id;

	@Column(name = "CODE")
	String code;

	@Size(min = 3, max = 30)
	@Column(name = "DESCRIPTION")
	String description;

	@Column(name = "IS_ENABLED")
	Boolean isEnabled;

	public Integer getId() {
		return id;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
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

	public void setId(Integer id) {
		this.id = id;
	}
	
	public EmploymentType(int id, String code, Boolean isEnabled)	{
		this.id = id;
		this.code = code;
		this.isEnabled = isEnabled;
	}
	
	public EmploymentType()	{
		
	}
}
