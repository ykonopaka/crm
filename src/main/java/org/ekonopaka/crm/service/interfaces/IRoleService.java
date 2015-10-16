package org.ekonopaka.crm.service.interfaces;

import java.util.List;

import org.ekonopaka.crm.model.Role;

public interface IRoleService {

	public void addRole(Role role);

	public Role getRoleByAuthority(String authority);

	public List<Role> getRoles();

}
