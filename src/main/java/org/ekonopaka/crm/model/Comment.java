package org.ekonopaka.crm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COMMENTS")
public class Comment {

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@Size(min = 2, max = 255)
	@Pattern(regexp = "([\\p{L}\\s\\d,.%$!@#^&*\\(\\)\\{\\}\\[\\]:;?<>])*")
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "IS_ENABLED")
	Boolean isEnabled;
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Deal deal;
	
	@Column(name = "DATE")
	Date date;	

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}
	
}
