package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.Credit;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealCreditValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Credit.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Credit credit = (Credit) obj;
		
		if (!errors.hasFieldErrors("amountOfMoney") && credit.getAmountOfMoney() == null)	{
			errors.rejectValue("amountOfMoney", "NotNull.credit.amountOfMoney");
		}
		
		if (!errors.hasFieldErrors("term") && credit.getTerm() == null)	{
			errors.rejectValue("term", "NotNull.credit.term");
		}
		
	}

}
