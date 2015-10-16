package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealCustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Customer.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Customer customer = (Customer) obj;

		if (!errors.hasFieldErrors("numberOfAllChildren")
				&& customer.getNumberOfAllChildren() == null) {
			errors.rejectValue("numberOfAllChildren",
					"NotNull.customer.numberOfAllChildren");
		}
		if (!errors.hasFieldErrors("numberOfYoungChildren")
				&& customer.getNumberOfYoungChildren() == null) {
			errors.rejectValue("numberOfYoungChildren",
					"NotNull.customer.numberOfYoungChildren");
		}

		if (customer.getWasLastNameChanged()) {
			if (!errors.hasFieldErrors("lastNameChangeDate")
					&& (customer.getLastNameChangeDate() == null || customer
							.getLastNameChangeDate().equals(""))) {
				errors.rejectValue("lastNameChangeDate",
						"NotNull.customer.lastNameChangeDate");
			}
			if (!errors.hasFieldErrors("previousLastName")
					&& (customer.getPreviousLastName() == null || customer
							.getPreviousLastName().equals(""))) {
				errors.rejectValue("previousLastName",
						"NotNull.customer.previousLastName");
			}
		}
	}

}
