package org.ekonopaka.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ROLES")
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3769623561069476882L;

	public static final String ADMIN = "ADMIN";
	public static final String COORDINATOR = "COORDINATOR";
	public static final String OPERATOR = "OPERATOR";

	@Id
	@Column
	@GeneratedValue
	Integer id;

	@NotNull
	@Column(name = "AUTHORITY", unique = true)
	String authority;

	@Column(name = "CODE")
	String code;

	@Column(name = "ISADMIN")
	Boolean isAdmin;

	@Transient
	String description;

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

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String toString() {
		return authority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
