package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CALLS")
public class Call {

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private User user;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private ClientPhoneNumber clientPhoneNumber;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Client client;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private InfoSource infoSource;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Credit credit;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private PhoneNumber officePhoneNumber;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private AdditionalCallInfo additionalCallInfo;
	
	@Column(name = "ENABLED")
	private Boolean isEnabled;

	@Size(max=300)
	private String comments;
	
	@Column(name = "DATE")
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InfoSource getInfoSource() {
		return infoSource;
	}

	public void setInfoSource(InfoSource infoSource) {
		this.infoSource = infoSource;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PhoneNumber getOfficePhoneNumber() {
		return officePhoneNumber;
	}

	public void setOfficePhoneNumber(PhoneNumber officePhoneNumber) {
		this.officePhoneNumber = officePhoneNumber;
	}

	public ClientPhoneNumber getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(ClientPhoneNumber clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AdditionalCallInfo getAdditionalCallInfo() {
		return additionalCallInfo;
	}

	public void setAdditionalCallInfo(AdditionalCallInfo additionalCallInfo) {
		this.additionalCallInfo = additionalCallInfo;
	}
	
}
