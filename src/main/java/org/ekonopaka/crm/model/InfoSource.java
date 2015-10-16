package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.InfoSourceType;

@Entity
@Table(name = "INFO_SOURCES")
public class InfoSource {

	@Id
	@Column
	@GeneratedValue
	Integer id;

	@ManyToOne
	@PrimaryKeyJoinColumn
	InfoSourceType infoSourceType;

	@Size(min = 3, max = 30)
	@Column(name = "DETAILS")
	String details;

	@Column(name = "IS_ENABLED")
	Boolean isEnabled;
	
	@Transient
	String fullName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public InfoSourceType getInfoSourceType() {
		return infoSourceType;
	}

	public void setInfoSourceType(InfoSourceType infoSourceType) {
		this.infoSourceType = infoSourceType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getFullName() {
		return infoSourceType.getDescription() + " - " + details;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
