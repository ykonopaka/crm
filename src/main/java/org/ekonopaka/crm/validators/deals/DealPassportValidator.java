package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.Passport;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealPassportValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Passport.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Passport passport = (Passport) obj;
		
		if (passport.getHasOtherDocument()) {
			if (!errors.hasFieldErrors("nameOfOtherDocument")
					&& (passport.getNameOfOtherDocument() == null || passport
							.getNameOfOtherDocument().equals(""))) {
				errors.rejectValue("nameOfOtherDocument",
						"NotNull.passport.nameOfOtherDocument");
			}
		}
	}

}
