package org.ekonopaka.crm.validators;

import org.ekonopaka.crm.model.User;
import org.ekonopaka.crm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidatorChangePassword implements Validator {

	@Autowired
	IUserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SaltSource saltSource;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		User fUser = (User) arg0;

		User pUser = userService.getCurrentUser();

		String currentPwd = pUser.getPassword();
		String currentPwdFromForm = userService.encodePassword(fUser.getPassword(), pUser);
		String newPwd = userService.encodePassword(fUser.getNewPassword(), pUser);
		String newPwdConfirm = userService.encodePassword(fUser.getConfirmNewPassword(), pUser);

		if (!currentPwd.equals(currentPwdFromForm)) {
			errors.rejectValue("password", "user.password.notMatchCurrentPassword");
		} else if (!newPwd.equals(newPwdConfirm)) {
			errors.rejectValue("newPassword", "user.password.newPasswordsNotMatch");
		}

	}

}
