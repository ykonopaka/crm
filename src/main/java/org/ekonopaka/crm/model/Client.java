package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.EmploymentType;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "CLIENTS")
public class Client {

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Size(min=2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Size(max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Transient
	private String fullName;

	@Column(name = "ENABLED")
	private Boolean isEnabled;

	@Column(name = "DATE")
	private Date creationDate;

	@Transient
	private String specificEmploymentType;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private EmploymentType employmentType;
	
	@Range(min = 0, max = 100)
	@Column(name = "AGE")
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public String getSpecificEmploymentType() {
		return specificEmploymentType;
	}

	public void setSpecificEmploymentType(String specificEmploymentType) {
		this.specificEmploymentType = specificEmploymentType;
	}

	public String getFullName() {
		return lastName + " " + firstName + " " + middleName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
