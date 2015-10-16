package org.ekonopaka.crm.validators;

import java.util.List;

import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorUniqueEmail implements Validator {

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

		if (users.size() >= 2) {
			errors.rejectValue("email", "user.email.suchEmailAlreadyExists");
		} else if ((users.size() == 1)
				&& (users.get(0).getId().intValue() != user.getId().intValue())) {
			errors.rejectValue("email", "user.email.suchEmailAlreadyExists");
		}
	}
}
