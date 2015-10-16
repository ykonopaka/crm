package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.Property;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealPropertyValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Property.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Property property = (Property) obj;
		
		if (property.getIsEPPresent()) {
			if (!errors.hasFieldErrors("epArea") && (property.getEpArea() == null)) {
				errors.rejectValue("epArea", "NotNull.property.epArea");
			}
		}
		
		if (property.getIsEPPresent()) {
			if (!errors.hasFieldErrors("epPrice") && (property.getEpPrice() == null)) {
				errors.rejectValue("epPrice", "NotNull.property.epPrice");
			}
		}
		
		if (property.getIsEPPresent()) {
			if (!errors.hasFieldErrors("epRoomNumber") && (property.getEpRoomNumber() == null)) {
				errors.rejectValue("epRoomNumber", "NotNull.property.epRoomNumber");
			}
		}
		
		if (property.getIsGAPresent()) {
			if (!errors.hasFieldErrors("gaArea") && (property.getGaArea() == null)) {
				errors.rejectValue("gaArea", "NotNull.property.gaArea");
			}
		}


	}


}




