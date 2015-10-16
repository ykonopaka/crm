package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.constants.Positions;
import org.ekonopaka.crm.model.WorkingPlace;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealWorkingPlaceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(WorkingPlace.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		WorkingPlace workingPlace = (WorkingPlace) obj;

		if (!errors.hasFieldErrors("lengthOfServiceLastPlace")
				&& workingPlace.getLengthOfServiceLastPlace() == null) {
			errors.rejectValue("lengthOfServiceLastPlace",
					"NotNull.workingPlace.lengthOfServiceLastPlace");
		}
		if (!errors.hasFieldErrors("lengthOfServiceTotal")
				&& workingPlace.getLengthOfServiceTotal() == null) {
			errors.rejectValue("lengthOfServiceTotal",
					"NotNull.workingPlace.lengthOfServiceTotal");
		}

		if (workingPlace.getPositionType().getId() != Positions.SPECIALIST_ID) {
			if (!errors.hasFieldErrors("numberOfWorkers")
					&& (workingPlace.getNumberOfWorkers() == null || workingPlace
							.getNumberOfWorkers().equals(""))) {
				errors.rejectValue("numberOfWorkers",
						"NotNull.workingPlace.numberOfWorkers");
			}
		}
	}
}
