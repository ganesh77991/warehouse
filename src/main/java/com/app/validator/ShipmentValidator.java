package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ShipmentType ship=(ShipmentType) target;
		
		if ("".equals(ship.getMode())) {
			errors.rejectValue("mode", null, "please select one mode");
		}
		if ("".equals(ship.getCode())) {
			errors.rejectValue("code", null, "please enter the code");
		}
		/*if ("".equals(ship.getEnabled())) {
			errors.rejectValue("enabled", null, "please select the enabled");
		}*/
		
		if ("".equals(ship.getGrade()) || ship.getGrade()==null) {
			errors.rejectValue("grade", null, "please select the Grade");
		}
		
		if ("".equals(ship.getDsc())) {
			errors.rejectValue("dsc", null, "please enter the Description");
		}
		
	}

}
