package org.ekonopaka.crm.validators;

import java.util.ArrayList;

import org.ekonopaka.crm.model.ClientPhoneNumber;
import org.ekonopaka.crm.service.interfaces.IClientPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ClientValidatorPhoneNumbersValidator implements Validator {

	@Autowired
	IClientPhoneService clientPhoneService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ArrayList.class);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		@SuppressWarnings("unchecked")
		ArrayList<ClientPhoneNumber> clientPhoneNumbers = (ArrayList<ClientPhoneNumber>) arg0;

		for (int i = 0; i < clientPhoneNumbers.size(); i++) {
			String phoneNumber = clientPhoneNumbers.get(i).getPhoneNumber();
			if (!phoneNumber.matches("([0-9\\+\\-])*")) {
				errors.rejectValue("clientPhoneNumbers[" + i + "].phoneNumber", "Pattern.phoneNumber.phoneNumber");
			}

			for (int j = i + 1; j < clientPhoneNumbers.size(); j++) {
				String phoneNumberToCompare = clientPhoneNumbers.get(j)
						.getPhoneNumber();
				if (!phoneNumberToCompare.equals("")) {
					if (phoneNumberToCompare.equals(phoneNumber)) {
						errors.rejectValue("clientPhoneNumbers[" + i
								+ "].phoneNumber", "PhoneNumbers.are.equal");
					}
				}
			}
		}
	}
}
