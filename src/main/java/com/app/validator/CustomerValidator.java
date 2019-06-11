package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Customer;

@Component
public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Customer customer=(Customer) target;
		
		if ("".equals(customer.getCustCode())) {
			
			errors.rejectValue("custCode", null, "enter ethe customer code");
		}
		if ("".equals(customer.getCustAddr())) {
			
			errors.rejectValue("custAddr", null, "enter ethe customer address");
		}
		if (customer.getCustLocs().isEmpty()) {

			errors.rejectValue("custLocs", null, "select atleast one Location");
		}
		if ("".equals(customer.getCustEmail())) {
			
			errors.rejectValue("custEmail", null, "please enter the email");
		}
		if ("".equals(customer.getCustContact())) {
			
			errors.rejectValue("custContact", null, "please enter the contact");
		}
		
	}

}
