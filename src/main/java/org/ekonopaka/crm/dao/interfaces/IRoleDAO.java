package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Role;

public interface IRoleDAO {
	public void addRole(Role role);

	public Role getRoleByAuthority(String authority);

	public List<Role> getRoles();
}
