package org.ekonopaka.crm.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ekonopaka.crm.dao.interfaces.IRoleDAO;
import org.ekonopaka.crm.dao.interfaces.IUserDAO;
import org.ekonopaka.crm.handlers.DateFormatter;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.LoginEntry;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDao;

	@Autowired
	private IRoleDAO roleDao;
	
	@Autowired
	DateFormatter dateFormatter;

	@Transactional
	public void addUser(User user) {
		user.setIsEnabled(true);
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		User user = userDao.getUserByUsername(username);
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		UserDetails user = loadUserByUsername(username);
		return (User) user;
	}

	@Override
	@Transactional
	public void saveLoginEntry(User user) {
		userDao.addLoginHistoryEntry(user);
	}

	@Override
	@Transactional
	public void addUserRoles(User user, List<Role> roles) {
		user.setRoles(roles);
		userDao.updateUser(user);
	}

	@Override
	public User getCurrentUser() {
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return userDao.getUser(user.getId());
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	@Transactional
	public void updateUserPassword(User user) {
		userDao.updateUserPassword(user);
	}

	@Override
	public Office getUserOffice(User user) {
		return null;
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public String encodePassword(String password, User user) {
		return userDao.encodePassword(password, user);
	}

	@Override
	public Set<User> getUsers() {

		Set<User> users = new HashSet<User>(userDao.getUsers());

		return users;
	}

	@Override
	public List<User> getUsersByEmail(String email) {
		return userDao.getUsersByEmail(email);
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return userDao.getUser(id);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);

	}

	@Override
	public List<LoginEntry> getUserLoginEntries(User user) {
		return userDao.getUserLoginEntries(user);
	}

	@Override
	public String getUserLoginEntries(User user, DataTableHandler dto) {
		List<LoginEntry> entries = userDao.getUserLoginEntries(user, dto);
		String[][] aaData = new String[entries.size()][2];

		for (int i = 0; i < entries.size(); i++) {
			aaData[i][0] = String.valueOf(entries.get(i).getId());
			aaData[i][1] = dateFormatter.format((entries.get(i).getDate()));
		}

		dto.setData(aaData);
		return dto.getResponse();
	}

	@Override
	public User getNewUser() {
		User user = new User();
		user.setCreationDate(new Date());
		user.setIsEnabled(true);
		return user;
	}
}
