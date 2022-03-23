package com.spicesrus.validators;

import com.spicesrus.model.BillingDetails;
import com.spicesrus.repository.BillingDetailsRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BillingValidator implements Validator{
	
	private BillingDetailsRepo repo;
	
	public BillingValidator(BillingDetailsRepo repo) {
	       this.repo = repo;
	  }

	@Override
	public boolean supports(Class<?> clazz) {
		return BillingDetails.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BillingDetails b = (BillingDetails) target;
		
		if (b.getCardNumber().length() != 16) {
			errors.rejectValue("cardNumber","billing-card-invalid", "Please enter a 16 digit card number.");
		}
		if (b.getCvvNumber().length() != 3) {
			errors.rejectValue("CVV number","billing-cvv-invalid", "Please enter a 3 digit CVV number.");
		}
		
	}


}
