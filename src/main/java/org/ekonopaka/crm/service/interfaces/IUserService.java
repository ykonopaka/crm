package org.ekonopaka.crm.service.interfaces;

import java.util.List;
import java.util.Set;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.LoginEntry;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
	
	public User getNewUser();
	
	public void addUser(User user);

	public User getUserByUsername(String username);

	public User getUserByEmail(String email);

	public User getUserById(int id);

	public List<User> getUsersByEmail(String email);

	public Set<User> getUsers();

	public void saveLoginEntry(User user);

	public List<LoginEntry> getUserLoginEntries(User user);

	public void addUserRoles(User user, List<Role> roles);

	public User getCurrentUser();

	public void updateUserPassword(User user);

	public Office getUserOffice(User user);

	public void updateUser(User user);

	public String encodePassword(String password, User user);

	public void deleteUser(User user);

	public String getUserLoginEntries(User user, DataTableHandler dto);
	
}
