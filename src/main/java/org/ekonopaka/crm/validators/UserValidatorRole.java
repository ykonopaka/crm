package org.ekonopaka.crm.validators;

import java.util.List;

import org.ekonopaka.crm.model.Role;
import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorRole implements Validator {

	@Autowired
	IUserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object auth, Errors errors) {
		User user = (User) auth;
		List<Role> roles = user.getRoles();
		if (roles == null || roles.size() == 0) {
			errors.rejectValue("roles", "user.role.noRole");
		} else if (user.getUsername().equals(User.ADMIN_USERNAME)) {

			Boolean isAdminRolePresent = false;
			for (Role role : roles) {
				if (role.getAuthority().equals(Role.ADMIN)) {
					isAdminRolePresent = true;
				}
			}
			if (!isAdminRolePresent)
				errors.rejectValue("roles", "user.role.adminUserHasNoAdminRole");
		}
	}
}
