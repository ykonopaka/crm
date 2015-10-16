package org.ekonopaka.crm.service.impl;

import java.util.List;

import org.ekonopaka.crm.dao.interfaces.IRoleDAO;
import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService implements IRoleService {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private IRoleDAO roleDao;

	@Override
	@Transactional
	public void addRole(Role role) {
		roleDao.addRole(role);

	}

	@Override
	@Transactional
	public Role getRoleByAuthority(String authority) {
		return roleDao.getRoleByAuthority(authority);
	}

	@Override
	public List<Role> getRoles() {
		return roleDao.getRoles();
	}
}
