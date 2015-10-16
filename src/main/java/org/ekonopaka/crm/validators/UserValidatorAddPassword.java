package org.ekonopaka.crm.validators;

import org.ekonopaka.crm.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorAddPassword implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		User fUser = (User) arg0;

		if (!fUser.getNewPassword().equals(fUser.getConfirmNewPassword())) {
			errors.rejectValue("newPassword", "user.password.newPasswordsNotMatch");
		}

	}
}
