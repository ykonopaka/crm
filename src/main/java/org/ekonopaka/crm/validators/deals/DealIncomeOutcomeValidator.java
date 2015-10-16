package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.IncomeOutcome;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealIncomeOutcomeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(IncomeOutcome.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		IncomeOutcome incomeOutcome = (IncomeOutcome) obj;
		
		if (incomeOutcome.getIsMarried()) {
			if (!errors.hasFieldErrors("spouseIncomeSize")
					&& (incomeOutcome.getSpouseIncomeSize() == null)) {
				errors.rejectValue("spouseIncomeSize",
						"NotNull.incomeOutcome.spouseIncomeSize");
			}
		}
		
		if (incomeOutcome.getIsAdditionalIncomePresent()) {
			if (!errors.hasFieldErrors("additionalIncomeSize")
					&& (incomeOutcome.getAdditionalIncomeSize() == null)) {
				errors.rejectValue("additionalIncomeSize",
						"NotNull.incomeOutcome.additionalIncomeSize");
			}
		}


	}

}
