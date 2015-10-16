package org.ekonopaka.crm.validators;

import org.ekonopaka.crm.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClientValidatorSpecificEmploymentType implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Client.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Client client = (Client) target;

		if (client.getSpecificEmploymentType() != null
				&& !client.getSpecificEmploymentType().equals("")) {
			if (client.getSpecificEmploymentType().length() <= 5 || client.getSpecificEmploymentType().length() >= 30)
				errors.rejectValue("specificEmploymentType", "Size.client.specificEmploymentType");
		}

	}

}
