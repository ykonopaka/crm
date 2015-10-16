package org.ekonopaka.crm.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.ekonopaka.crm.controllers.typeeditors.RolesListTypeEditor;
import org.ekonopaka.crm.handlers.EmailHandler;
import org.ekonopaka.crm.handlers.LocatizationTool;
import org.ekonopaka.crm.handlers.MessageGenerator;
import org.ekonopaka.crm.handlers.PasswordGenerator;
import org.ekonopaka.crm.handlers.StatusMessage;
import org.ekonopaka.crm.handlers.json.DataTableHandler;
import org.ekonopaka.crm.model.Office;
import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IOfficeService;
import org.ekonopaka.crm.service.interfaces.IRoleService;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.ekonopaka.crm.validators.UserValidatorAddPassword;
import org.ekonopaka.crm.validators.UserValidatorChangePassword;
import org.ekonopaka.crm.validators.UserValidatorExistentEmail;
import org.ekonopaka.crm.validators.UserValidatorNonExistingEmail;
import org.ekonopaka.crm.validators.UserValidatorRole;
import org.ekonopaka.crm.validators.UserValidatorUniqueEmail;
import org.ekonopaka.crm.validators.UserValidatorUniqueLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	IUserService userService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IOfficeService officeService;

	@Autowired
	UserValidatorExistentEmail validatorExistentEmail;
	
	@Autowired
	UserValidatorNonExistingEmail validatorNonExistingEmail; 

	@Autowired
	UserValidatorUniqueEmail validatorUniqueEmail;

	@Autowired
	UserValidatorChangePassword validatorChangePassword;

	@Autowired
	UserValidatorRole validatorRole;

	@Autowired
	UserValidatorUniqueLogin validatorUniqueLogin;

	@Autowired
	UserValidatorAddPassword validatorAddPassword;

	@Autowired
	PasswordGenerator passwordGenerator;

	@Autowired
	EmailHandler emailHandler;

	@Autowired
	MessageGenerator messageGenerator;

	@Autowired
	MessageSource messageSource;

	@Autowired
	LocatizationTool locatizationTool;

	@Autowired
	private SessionRegistry sessionRegistry;

	@RequestMapping(value = "/forgotpasswd", method = RequestMethod.GET)
	public String forgotPasswordGet(Model model) {
		model.addAttribute("user", userService.getNewUser());
		return "forgotpasswd";
	}

	@RequestMapping(value = "/forgotpasswd", method = RequestMethod.POST)
	public String forgotPasswordPost(
						Model model,
						@Valid @ModelAttribute("user") User fUser, 
						BindingResult result,
						Locale locale) {

		// Checking if email is well-formatted
		if (result.hasErrors()) {
			return "forgotpasswd";
		}

		validatorExistentEmail.validate(fUser, result);

		// Checking if the user with such email does exist in the database
		if (result.hasErrors()) {
			return "forgotpasswd";
		}

		// Sending message and update the password
		User pUser = userService.getUserByEmail(fUser.getEmail());
		
		pUser.setPassword(passwordGenerator.getRandomPassword());
		
		emailHandler.sendNewPassword(pUser);
		userService.updateUserPassword(pUser);
		
		String msg = messageSource.getMessage("message.password.email.sent", null, locale);
		model.addAttribute("msg", msg);
		return "login";
	}

	@RequestMapping(value = "/myusersettings", method = RequestMethod.GET)
	public String myUserSettingsGet(
						Model model, 
						Locale locale) {
		
		List<Office> officesList = officeService.getOffices();
		List<Role> rolesList = roleService.getRoles();

		model.addAttribute("user", userService.getCurrentUser());
		model.addAttribute("officesList", officesList);
		model.addAttribute("rolesList", locatizationTool.processRoles(rolesList, locale));

		return "myusersettings";
	}

	@RequestMapping(value = "/myusersettings", method = RequestMethod.POST)
	public String myUserSettingsPost(
						Model model, 
						@Valid @ModelAttribute("user") User fUser, 
						BindingResult result, 
						Locale locale) {
		
		validatorUniqueEmail.validate(fUser, result);

		User pUser = userService.getCurrentUser();
		fUser.setRoles(pUser.getRoles());
		
		if (result.hasErrors()) {
			List<Office> officesList = officeService.getOffices();
			List<Role> rolesList = roleService.getRoles();

			model.addAttribute("officesList", officesList);
			model.addAttribute("rolesList",	locatizationTool.processRoles(rolesList, locale));
			model.addAttribute("user", fUser);

			String msg = messageSource.getMessage("your.account.settings.have.not.been.updated", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			return "myusersettings";
		}

		fUser.setCreationDate(pUser.getCreationDate());
		fUser.setIsEnabled(pUser.getIsEnabled());
		fUser.setPassword(pUser.getPassword());

		userService.updateUser(fUser);

		if (fUser.getOffice() == null) {
			String msg = messageSource.getMessage("your.account.settings.have.been.updated.with.no.office", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		} else {
			String msg = messageSource.getMessage("your.account.settings.have.been.updated", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		}
		return "dashboard";
	}

	@RequestMapping(value = "/changepasswd", method = RequestMethod.GET)
	public String changePasswordGet(
						Model model) {
		
		model.addAttribute("user", userService.getNewUser());
		return "changepasswd";
	}

	@RequestMapping(value = "/changepasswd", method = RequestMethod.POST)
	public String changePasswordPost(
						Model model, 
						@Valid @ModelAttribute("user") User fUser, 
						BindingResult result, 
						Locale locale) {

		if (result.hasErrors()) {
			model.addAttribute("user", fUser);
			return "changepasswd";
		}

		validatorChangePassword.validate(fUser, result);

		if (result.hasErrors()) {
			model.addAttribute("user", fUser);
			return "changepasswd";
		}

		User pUser = userService.getCurrentUser();
		pUser.setPassword(fUser.getNewPassword());

		userService.updateUserPassword(pUser);
		String msg = messageSource.getMessage("password.has.been.changed.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));

		return "workflow";
	}

	@RequestMapping(value = "/administration/adduser", method = RequestMethod.GET)
	public String addUserGet(
						Model model, 
						Locale locale) {
		
		List<Office> officesList = officeService.getOffices();
		List<Role> rolesList = roleService.getRoles();

		model.addAttribute("user", userService.getNewUser());
		model.addAttribute("officesList", officesList);
		model.addAttribute("rolesList", locatizationTool.processRoles(rolesList, locale));

		return "adduser";
	}

	@RequestMapping(value = "/administration/adduser", method = RequestMethod.POST)
	public String addUserPost(
						Model model, 
						@Valid @ModelAttribute("user") User fUser, 
						BindingResult result, 
						Locale locale) {
		
		List<Office> officesList = officeService.getOffices();
		List<Role> rolesList = roleService.getRoles();

		validatorRole.validate(fUser, result);

		if (result.hasErrors()) {
			model.addAttribute("user", fUser);
			model.addAttribute("officesList", officesList);
			model.addAttribute("rolesList", locatizationTool.processRoles(rolesList, locale));
			String msg = messageSource.getMessage("user.has.not.been.created.message", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			return "adduser";
		}

		validatorUniqueLogin.validate(fUser, result);
		validatorAddPassword.validate(fUser, result);
		validatorNonExistingEmail.validate(fUser, result);

		if (result.hasErrors()) {
			model.addAttribute("user", fUser);
			model.addAttribute("officesList", officesList);
			model.addAttribute("rolesList", locatizationTool.processRoles(rolesList, locale));
			String msg = messageSource.getMessage("user.has.not.been.created.message", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			return "adduser";
		}

		fUser.setPassword(fUser.getNewPassword());

		userService.addUser(fUser);

		if (fUser.getOffice() == null) {
			String msg = messageSource.getMessage("user.has.been.created.with.no.office", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		} else {
			String msg = messageSource.getMessage("user.has.been.created.message", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		}

		Set<User> usersList = userService.getUsers();
		model.addAttribute("usersList", usersList);
		return "manageusers";
	}

	@RequestMapping(value = "/administration/manageusers", method = RequestMethod.GET)
	public String manageUsers(
						Model model) {
		
		Set<User> usersList = userService.getUsers();
		model.addAttribute("usersList", usersList);
		return "manageusers";
	}

	@RequestMapping(value = "/administration/edit/user/{userId}", method = RequestMethod.GET)
	public String editUserGet(
						Model model, 
						@PathVariable("userId") int userId, 
						Locale locale) {
		
		List<Office> officesList = officeService.getOffices();
		List<Role> rolesList = roleService.getRoles();

		User user = userService.getUserById(userId);

		model.addAttribute("user", user);
		model.addAttribute("officesList", officesList);
		model.addAttribute("rolesList", locatizationTool.processRoles(rolesList, locale));

		return "edituser";
	}

	@RequestMapping(value = "/administration/edit/user/{userId}", method = RequestMethod.POST)
	public String editUserPost(
						Model model, 
						@Valid @ModelAttribute("user") User fUser, 
						BindingResult result, 
						@PathVariable("userId") int userId, 
						Locale locale) {

		validatorUniqueEmail.validate(fUser, result);
		validatorRole.validate(fUser, result);

		List<Office> officesList = officeService.getOffices();
		List<Role> rolesList = roleService.getRoles();

		model.addAttribute("officesList", officesList);
		model.addAttribute("rolesList",	locatizationTool.processRoles(rolesList, locale));
		model.addAttribute("user", fUser);

		if (result.hasErrors()) {
			String msg = messageSource.getMessage("user.has.not.been.updated.message", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			return "edituser";
		}

		User pUser = userService.getUserById(userId);

		fUser.setIsEnabled(pUser.getIsEnabled());
		fUser.setPassword(pUser.getPassword());

		userService.updateUser(fUser);

		if (fUser.getOffice() == null) {
			String msg = messageSource.getMessage("user.has.been.updated.with.no.office", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.WARNING_STATUS, msg));
		} else {
			String msg = messageSource.getMessage("user.has.been.updated.message", null, locale);
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
			Set<User> usersList = userService.getUsers();
			model.addAttribute("usersList", usersList);
		}
		return "manageusers";
	}

	@RequestMapping(value = "/administration/delete/user/{userId}", method = RequestMethod.GET)
	public String deleteUserGet(
						Model model, 
						@PathVariable("userId") int userId, 
						Locale locale) {
		
		List<Office> officesList = officeService.getOffices();
		List<Role> rolesList = roleService.getRoles();

		User user = userService.getUserById(userId);

		model.addAttribute("user", user);
		model.addAttribute("officesList", officesList);
		model.addAttribute("rolesList", locatizationTool.processRoles(rolesList, locale));

		return "deleteuser";
	}

	@RequestMapping(value = "/administration/delete/user/{userId}", method = RequestMethod.POST)
	public String deleteUserPost(
						Model model, 
						@Valid @ModelAttribute("user") User fUser, 
						BindingResult result, 
						@PathVariable("userId") int userId, 
						Locale locale) {

		User user = userService.getUserById(userId);

		if (user.getUsername().equals(User.ADMIN_USERNAME)) {
			String msg = messageSource.getMessage("admin.user.can.not.be.deleted.message", null, locale);
			List<Office> officesList = officeService.getOffices();
			model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.ERROR_STATUS, msg));
			model.addAttribute("user", user);
			model.addAttribute("officesList", officesList);
			return "deleteuser";
		}

		dropUserSessions(user);

		userService.deleteUser(user);

		String msg = messageSource.getMessage("user.has.been.deleted.message", null, locale);
		Set<User> usersList = userService.getUsers();
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		model.addAttribute("usersList", usersList);

		return "manageusers";
	}

	@RequestMapping(value = "/administration/loginhistory/user/{userId}/init", method = RequestMethod.GET)
	public String loginhistory(
						@PathVariable("userId") int userId) {
		User user = userService.getUserById(userId);
		if (user == null)	 return "404";
		
		return "loginhistory";
	}

	@RequestMapping(value = "/administration/loginhistory/user/{userId}/serverprocessing", method = RequestMethod.GET)
	public @ResponseBody String loginhistorySSP(
						Model model, 
						@PathVariable("userId") int userId, 
						HttpServletRequest request, 
						Locale locale) {
		
		DataTableHandler dataTableHandler = new DataTableHandler(request);
		User user = userService.getUserById(userId);
		
		String output = userService.getUserLoginEntries(user, dataTableHandler);
		return output;
	}

	@RequestMapping(value = "/administration/connectedusers", method = RequestMethod.GET)
	public String getConnectedUsers(
						Model model, 
						Locale locale) {
		
		model.addAttribute("usersList", getConnectedUsers());
		return "connectedusers";
	}

	@RequestMapping(value = "/administration/disconnect/user/{userId}", method = RequestMethod.GET)
	public String disconnectUser(
						Model model, 
						@PathVariable("userId") int userId, 
						Locale locale) {
		
		User user = userService.getUserById(userId);
		if (user == null)	 return "404";
		
		dropUserSessions(user);
		String msg = messageSource.getMessage("user.has.been.disconnected.message", null, locale);
		model.addAttribute("message", messageGenerator.generateMessage(StatusMessage.SUCCESS_STATUS, msg));
		model.addAttribute("usersList", getConnectedUsers());
		return "connectedusers";
	}

	@InitBinder
	protected void initBinder(
						HttpServletRequest request, 
						ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(List.class, "roles", new RolesListTypeEditor(List.class, roleService));
	}

	private Collection<User> getConnectedUsers() {
		List<Object> principals = sessionRegistry.getAllPrincipals();
		Map<String, User> usersMap = new HashMap<String, User>();

		for (Object principal : principals) {
			if (principal instanceof User) {
				List<SessionInformation> sessions = sessionRegistry.getAllSessions(principal, false);
				for (SessionInformation session : sessions) {
					if (!session.isExpired()) {
						User user = (User) principal;
						usersMap.put(user.getUsername(), user);
					}
				}
			}
		}
		return usersMap.values();
	}

	private void dropUserSessions(User user) {
		List<Object> principals = sessionRegistry.getAllPrincipals();

		for (Object principal : principals) {
			if (principal instanceof User) {
				if (((User) principal).getUsername().equals(user.getUsername())) {
					List<SessionInformation> sessions = sessionRegistry.getAllSessions(principal, false);
					for (SessionInformation sessionInformation : sessions) {
						sessionInformation.expireNow();
					}
				}
			}
		}
	}

}
