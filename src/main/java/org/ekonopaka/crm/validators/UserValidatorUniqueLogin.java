package org.ekonopaka.crm.validators;

import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorUniqueLogin implements Validator {

	@Autowired
	IUserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object auth, Errors errors) {
		User fUser = (User) auth;
		User pUser;

		try {
			pUser = userService.getUserByUsername(fUser.getUsername());
		} catch (UsernameNotFoundException notFoundException) {
			pUser = null;
		}

		if (pUser != null) {
			errors.rejectValue("username", "user.username.suchLoginAlreadyExists");
		}
	}
}
