package org.ekonopaka.crm.validators.deals;

import java.util.regex.Pattern;

import org.ekonopaka.crm.model.Marriage;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealMarriageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Marriage.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Marriage marriage = (Marriage) obj;
		
		if (!(marriage.getIdTaxNumber() == null || marriage.getIdTaxNumber().equals("")))	{
			if (!Pattern.matches("([0-9]){10,11}", marriage.getIdTaxNumber()))	{
				errors.rejectValue("idTaxNumber", "Pattern.marriage.idTaxNumber");
			} 
		}

	}

}
