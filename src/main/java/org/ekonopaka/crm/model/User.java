package org.ekonopaka.crm.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "USERS")
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8153823936465241426L;

	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_DEFAULT_PASSWORD = "admin";

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Size(min = 5, max = 30)
	@Pattern(regexp = "([a-zA-Z0-9])*")
	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;

	@Size(min = 5, max = 30)
	@Column(name = "PASSWORD")
	private String password;

	@Transient
	@Size(min = 5, max = 30)
	private String newPassword;

	@Transient
	@Size(min = 5, max = 30)
	private String confirmNewPassword;

	@Size(min = 3, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(min = 3, max = 30)
	@Pattern(regexp = "(\\p{L})*")
	@Column(name = "LAST_NAME")
	private String lastName;

	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@Column(name = "ENABLED")
	private Boolean isEnabled;

	@Column(name = "DATE")
	private Date creationDate;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Office office;

	@ManyToMany(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn(name = "ROLE_ID")
	private List<Role> roles;
	
	@Transient
	private Boolean isAdmin;
	
	@Transient
	private Boolean isOperator;
	
	@Transient
	private Boolean isCoordinator;

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.addAll(roles);
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isEnabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public Boolean getIsAdmin() {
		
		Boolean isAdmin = false;
		
		for (Role role : roles)	{
			if (role.getAuthority().equals(Role.ADMIN))	{
				isAdmin = true;
			}
		}
		
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsOperator() {
		Boolean isOperator = false;
		
		for (Role role : roles)	{
			if (role.getAuthority().equals(Role.OPERATOR))	{
				isOperator = true;
			}
		}
		
		return isOperator;
	}

	public void setIsOperator(Boolean isOperator) {
		this.isOperator = isOperator;
	}

	public Boolean getIsCoordinator() {
		Boolean isCoordinator = false;
		
		for (Role role : roles)	{
			if (role.getAuthority().equals(Role.COORDINATOR))	{
				isCoordinator = true;
			}
		}
		
		return isCoordinator;
	}

	public void setIsCoordinator(Boolean isCoordinator) {
		this.isCoordinator = isCoordinator;
	}
	
	
}
