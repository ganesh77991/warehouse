package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;

@Component
public class OrderMethodValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		System.out.println("OrderMethodValidator.validate()");
		OrderMethod om=(OrderMethod) target;
		
		if ("".equals(om.getMode()) || om.getMode()==null) {
			System.out.println("".equals(om.getMode()) || om.getMode()==null);
			errors.rejectValue("mode", null, "please select one Mode");
		}
		if ("".equals(om.getCode())) {
			errors.rejectValue("code", null, "please enter the code");
		}
		if ("".equals(om.getMethod())) {
			errors.rejectValue("method", null, "please enter the code");
		}
		if (om.getAccept().isEmpty()) {
			errors.rejectValue("accept", null, "please select the Accept");
		}
		if ("".equals(om.getDsc())) {
			errors.rejectValue("dsc", null, "please enter the description");
		}
		
	}

}
