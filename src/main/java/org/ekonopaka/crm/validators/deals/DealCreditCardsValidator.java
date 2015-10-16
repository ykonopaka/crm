package org.ekonopaka.crm.validators.deals;

import org.ekonopaka.crm.model.CreditCard;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DealCreditCardsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(CreditCard.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		CreditCard creditCard = (CreditCard) obj;
		
		if (creditCard.getFcIsExisted()) {
			if (!errors.hasFieldErrors("fcAmount") && (creditCard.getFcAmount() == null)) {
				errors.rejectValue("fcAmount", "NotNull.creditCard.fcAmount");
			}
			if (!errors.hasFieldErrors("fcMoneyLeft") && (creditCard.getFcMoneyLeft() == null)) {
				errors.rejectValue("fcMoneyLeft", "NotNull.creditCard.fcMoneyLeft");
			}
			if (!errors.hasFieldErrors("fcTimeLeft") && (creditCard.getFcTimeLeft() == null)) {
				errors.rejectValue("fcTimeLeft", "NotNull.creditCard.fcTimeLeft");
			}
			if (!errors.hasFieldErrors("fcStartingDate") && (creditCard.getFcStartingDate() == null)) {
				errors.rejectValue("fcStartingDate", "NotNull.creditCard.fcStartingDate");
			}
			if (!errors.hasFieldErrors("fcEndingDate") && (creditCard.getFcEndingDate() == null)) {
				errors.rejectValue("fcEndingDate", "NotNull.creditCard.fcEndingDate");
			}
		}
		
		if (creditCard.getScIsExisted()) {
			if (!errors.hasFieldErrors("scAmount") && (creditCard.getScAmount() == null)) {
				errors.rejectValue("scAmount", "NotNull.creditCard.scAmount");
			}
			if (!errors.hasFieldErrors("scMoneyLeft") && (creditCard.getScMoneyLeft() == null)) {
				errors.rejectValue("scMoneyLeft", "NotNull.creditCard.scMoneyLeft");
			}
			if (!errors.hasFieldErrors("scTimeLeft") && (creditCard.getScTimeLeft() == null)) {
				errors.rejectValue("scTimeLeft", "NotNull.creditCard.scTimeLeft");
			}
			if (!errors.hasFieldErrors("scStartingDate") && (creditCard.getScStartingDate() == null)) {
				errors.rejectValue("scStartingDate", "NotNull.creditCard.scStartingDate");
			}
			if (!errors.hasFieldErrors("scEndingDate") && (creditCard.getScEndingDate() == null)) {
				errors.rejectValue("scEndingDate", "NotNull.creditCard.scEndingDate");
			}
		}
		
		if (creditCard.getTcIsExisted()) {
			if (!errors.hasFieldErrors("tcAmount") && (creditCard.getTcAmount() == null)) {
				errors.rejectValue("tcAmount", "NotNull.creditCard.tcAmount");
			}
			if (!errors.hasFieldErrors("tcMoneyLeft") && (creditCard.getTcMoneyLeft() == null)) {
				errors.rejectValue("tcMoneyLeft", "NotNull.creditCard.tcMoneyLeft");
			}
			if (!errors.hasFieldErrors("tcTimeLeft") && (creditCard.getTcTimeLeft() == null)) {
				errors.rejectValue("tcTimeLeft", "NotNull.creditCard.tcTimeLeft");
			}
			if (!errors.hasFieldErrors("tcStartingDate") && (creditCard.getTcStartingDate() == null)) {
				errors.rejectValue("tcStartingDate", "NotNull.creditCard.tcStartingDate");
			}
			if (!errors.hasFieldErrors("tcEndingDate") && (creditCard.getTcEndingDate() == null)) {
				errors.rejectValue("tcEndingDate", "NotNull.creditCard.tcEndingDate");
			}
		}
		
		if (creditCard.getFccIsExisted()) {
			if (!errors.hasFieldErrors("fccMonthPayment") && (creditCard.getFccMonthPayment() == null)) {
				errors.rejectValue("fccMonthPayment", "NotNull.creditCard.fccMonthPayment");
			}
			if (!errors.hasFieldErrors("fccCreditLimit") && (creditCard.getFccCreditLimit() == null)) {
				errors.rejectValue("fccCreditLimit", "NotNull.creditCard.fccCreditLimit");
			}
			if (!errors.hasFieldErrors("fccMoneyLeft") && (creditCard.getFccMoneyLeft() == null)) {
				errors.rejectValue("fccMoneyLeft", "NotNull.creditCard.fccMoneyLeft");
			}
			if (!errors.hasFieldErrors("fccStartingDate") && (creditCard.getFccStartingDate() == null)) {
				errors.rejectValue("fccStartingDate", "NotNull.creditCard.fccStartingDate");
			}
			if (!errors.hasFieldErrors("fccEndingDate") && (creditCard.getFccEndingDate() == null)) {
				errors.rejectValue("fccEndingDate", "NotNull.creditCard.fccEndingDate");
			}
			if (!errors.hasFieldErrors("fccLastTransactionDate") && (creditCard.getFccEndingDate() == null)) {
				errors.rejectValue("fccLastTransactionDate", "NotNull.creditCard.fccLastTransactionDate");
			}
		}
		
		if (creditCard.getSccIsExisted()) {
			if (!errors.hasFieldErrors("sccMonthPayment") && (creditCard.getSccMonthPayment() == null)) {
				errors.rejectValue("sccMonthPayment", "NotNull.creditCard.sccMonthPayment");
			}
			if (!errors.hasFieldErrors("sccCreditLimit") && (creditCard.getSccCreditLimit() == null)) {
				errors.rejectValue("sccCreditLimit", "NotNull.creditCard.sccCreditLimit");
			}
			if (!errors.hasFieldErrors("sccMoneyLeft") && (creditCard.getSccMoneyLeft() == null)) {
				errors.rejectValue("sccMoneyLeft", "NotNull.creditCard.sccMoneyLeft");
			}
			if (!errors.hasFieldErrors("sccStartingDate") && (creditCard.getSccStartingDate() == null)) {
				errors.rejectValue("sccStartingDate", "NotNull.creditCard.sccStartingDate");
			}
			if (!errors.hasFieldErrors("sccEndingDate") && (creditCard.getSccEndingDate() == null)) {
				errors.rejectValue("sccEndingDate", "NotNull.creditCard.sccEndingDate");
			}
			if (!errors.hasFieldErrors("sccLastTransactionDate") && (creditCard.getFccEndingDate() == null)) {
				errors.rejectValue("sccLastTransactionDate", "NotNull.creditCard.sccLastTransactionDate");
			}
		}
		
		if (creditCard.getTccIsExisted()) {
			if (!errors.hasFieldErrors("tccMonthPayment") && (creditCard.getTccMonthPayment() == null)) {
				errors.rejectValue("tccMonthPayment", "NotNull.creditCard.tccMonthPayment");
			}
			if (!errors.hasFieldErrors("tccCreditLimit") && (creditCard.getTccCreditLimit() == null)) {
				errors.rejectValue("tccCreditLimit", "NotNull.creditCard.tccCreditLimit");
			}
			if (!errors.hasFieldErrors("tccMoneyLeft") && (creditCard.getTccMoneyLeft() == null)) {
				errors.rejectValue("tccMoneyLeft", "NotNull.creditCard.tccMoneyLeft");
			}
			if (!errors.hasFieldErrors("tccStartingDate") && (creditCard.getTccStartingDate() == null)) {
				errors.rejectValue("tccStartingDate", "NotNull.creditCard.tccStartingDate");
			}
			if (!errors.hasFieldErrors("tccEndingDate") && (creditCard.getTccEndingDate() == null)) {
				errors.rejectValue("tccEndingDate", "NotNull.creditCard.tccEndingDate");
			}
			if (!errors.hasFieldErrors("tccLastTransactionDate") && (creditCard.getFccEndingDate() == null)) {
				errors.rejectValue("tccLastTransactionDate", "NotNull.creditCard.tccLastTransactionDate");
			}
		}

	}

}
