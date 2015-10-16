package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.ContactPersons;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealContactPersonsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ContactPersons.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ContactPersons contactPersons = (ContactPersons) obj;
		
		if (contactPersons.getSpExist())	{
			if (!errors.hasFieldErrors("spBirthDate") && contactPersons.getSpBirthDate() == null)	{
				errors.rejectValue("spBirthDate", "NotNull.contactPersons.spBirthDate");
			}
		}

	}

}
