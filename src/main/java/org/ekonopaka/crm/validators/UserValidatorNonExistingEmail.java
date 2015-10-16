package org.ekonopaka.crm.validators;

import java.util.List;

import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorNonExistingEmail implements Validator {

	@Autowired
	IUserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object auth, Errors errors) {
		User user = (User) auth;

		List<User> users = userService.getUsersByEmail(user.getEmail());

		if (users.size() > 0) {
			errors.rejectValue("email", "user.email.suchEmailAlreadyExists");
		}
	}
}
