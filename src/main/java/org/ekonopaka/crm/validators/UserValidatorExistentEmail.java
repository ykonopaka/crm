package org.ekonopaka.crm.validators;

import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorExistentEmail implements Validator {

	@Autowired
	IUserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		User user = (User) arg0;

		User persistentUser = userService.getUserByEmail(user.getEmail());

		if (persistentUser == null) {
			errors.rejectValue("email", "user.email.notExist");
		}
	}
}
