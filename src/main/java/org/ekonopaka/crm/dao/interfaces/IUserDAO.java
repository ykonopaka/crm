package org.ekonopaka.crm.dao.interfaces;

import java.util.List;

import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.LoginEntry;
import org.ekonopaka.crm.model.User;

public interface IUserDAO {
	public void addUser(User user);

	public User getUserByUsername(String username);

	public User getUserByEmail(String email);

	public User getUser(Integer id);

	public List<User> getUsers();

	public void deleteUser(User user);

	public void deleteUser(Integer id);

	public void restoreUser(User user);

	public void restoreUser(Integer id);

	public void addLoginHistoryEntry(User user);

	public void updateUser(User user);

	public void updateUserPassword(User user);

	public String encodePassword(String password, User user);

	public List<User> getUsersByEmail(String email);

	public List<LoginEntry> getUserLoginEntries(User user);

	public List<LoginEntry> getUserLoginEntries(User user, DataTableHandler dto);

	public Integer getNumberOfLoginEntries(User user);
}
