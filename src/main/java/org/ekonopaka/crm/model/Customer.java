package org.ekonopaka.crm.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.ekonopaka.crm.model.types.ConvictionType;
import org.ekonopaka.crm.model.types.EducationType;
import org.ekonopaka.crm.model.types.EmploymentType;
import org.ekonopaka.crm.model.types.GenderType;
import org.ekonopaka.crm.model.types.MilitaryServiceType;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Size(min = 2, max = 30)
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

	@OneToMany
	@PrimaryKeyJoinColumn
	private List<ClientPhoneNumber> clientPhoneNumbers;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private MilitaryServiceType militaryServiceType;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private EducationType educationType;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "([\\p{L}\\s])*")
	@Column(name = "SPECIALITY")
	private String speciality;
	
	@Size(min = 2, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "MOTHER_LASTNAME")
	private String motherLastName;
	
	@Column(name = "LASTNAME_CHANGED")
	private Boolean wasLastNameChanged;
	
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "PREVIOUS_LASTNAME")
	private String previousLastName;
	
	@Column(name = "LASTNAME_CHANGE_DATE")
	private Date lastNameChangeDate;

	@Range(min = 0, max = 20)
	@Column(name = "NUMBER_ALL_CHILDREN")
	private Integer numberOfAllChildren;

	@Range(min = 0, max = 20)
	@Column(name = "NUMBER_YOUNG_CHILDREN")
	private Integer numberOfYoungChildren;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private GenderType genderType;
	
	@NotNull
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Size(min = 2, max = 120)
	@Pattern(regexp = "([\\p{L}\\s.!?\\-,])*")
	@Column(name = "BIRTH_PLACE")
	private String birthPlace;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private ConvictionType convictionType;
	
	@Column(name = "CLIENT_CARD_ID")
	private Integer clientCardId;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Passport passport;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Marriage marriage;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Address address;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CustomerPhoneSet customerPhoneSet;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private ContactPersons contactPersons;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private WorkingPlace workingPlace;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private AdditionalWorkingPlace additionalWorkingPlace;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private PreviousWorkingPlace previousWorkingPlace;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private IncomeOutcome incomeOutcome;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Property property;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private CreditCard creditCard;

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return lastName + " " + firstName + " " + middleName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getSpecificEmploymentType() {
		return specificEmploymentType;
	}

	public void setSpecificEmploymentType(String specificEmploymentType) {
		this.specificEmploymentType = specificEmploymentType;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public List<ClientPhoneNumber> getClientPhoneNumbers() {
		return clientPhoneNumbers;
	}

	public void setClientPhoneNumbers(List<ClientPhoneNumber> clientPhoneNumbers) {
		this.clientPhoneNumbers = clientPhoneNumbers;
	}

	public MilitaryServiceType getMilitaryServiceType() {
		return militaryServiceType;
	}

	public void setMilitaryServiceType(MilitaryServiceType militaryServiceType) {
		this.militaryServiceType = militaryServiceType;
	}

	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public Boolean getWasLastNameChanged() {
		return wasLastNameChanged;
	}

	public void setWasLastNameChanged(Boolean wasLastNameChanged) {
		this.wasLastNameChanged = wasLastNameChanged;
	}

	public String getPreviousLastName() {
		return previousLastName;
	}

	public void setPreviousLastName(String previousLastName) {
		this.previousLastName = previousLastName;
	}

	public Date getLastNameChangeDate() {
		return lastNameChangeDate;
	}

	public void setLastNameChangeDate(Date lastNameChangeDate) {
		this.lastNameChangeDate = lastNameChangeDate;
	}

	public Integer getNumberOfAllChildren() {
		return numberOfAllChildren;
	}

	public void setNumberOfAllChildren(Integer numberOfAllChildren) {
		this.numberOfAllChildren = numberOfAllChildren;
	}

	public Integer getNumberOfYoungChildren() {
		return numberOfYoungChildren;
	}

	public void setNumberOfYoungChildren(Integer numberOfYoungChildren) {
		this.numberOfYoungChildren = numberOfYoungChildren;
	}

	public GenderType getGenderType() {
		return genderType;
	}

	public void setGenderType(GenderType genderType) {
		this.genderType = genderType;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public ConvictionType getConvictionType() {
		return convictionType;
	}

	public void setConvictionType(ConvictionType convictionType) {
		this.convictionType = convictionType;
	}

	public Integer getClientCardId() {
		return clientCardId;
	}

	public void setClientCardId(Integer clientCardId) {
		this.clientCardId = clientCardId;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Marriage getMarriage() {
		return marriage;
	}

	public void setMarriage(Marriage marriage) {
		this.marriage = marriage;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CustomerPhoneSet getCustomerPhoneSet() {
		return customerPhoneSet;
	}

	public void setCustomerPhoneSet(CustomerPhoneSet customerPhoneSet) {
		this.customerPhoneSet = customerPhoneSet;
	}

	public ContactPersons getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(ContactPersons contactPersons) {
		this.contactPersons = contactPersons;
	}

	public WorkingPlace getWorkingPlace() {
		return workingPlace;
	}

	public void setWorkingPlace(WorkingPlace workingPlace) {
		this.workingPlace = workingPlace;
	}

	public AdditionalWorkingPlace getAdditionalWorkingPlace() {
		return additionalWorkingPlace;
	}

	public void setAdditionalWorkingPlace(
			AdditionalWorkingPlace additionalWorkingPlace) {
		this.additionalWorkingPlace = additionalWorkingPlace;
	}

	public PreviousWorkingPlace getPreviousWorkingPlace() {
		return previousWorkingPlace;
	}

	public void setPreviousWorkingPlace(PreviousWorkingPlace previousWorkingPlace) {
		this.previousWorkingPlace = previousWorkingPlace;
	}

	public IncomeOutcome getIncomeOutcome() {
		return incomeOutcome;
	}

	public void setIncomeOutcome(IncomeOutcome incomeOutcome) {
		this.incomeOutcome = incomeOutcome;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
}
