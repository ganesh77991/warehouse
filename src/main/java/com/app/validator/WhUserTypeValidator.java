package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserTypeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		WhUserType whUser=(WhUserType) target;
		
		if (whUser.getType()==null) {
			errors.rejectValue("type", null, "please select one type");
		}
		
		if ("".equals(whUser.getCode())) {
			errors.rejectValue("code", null, "please enter the code");
		}
		
		if ("".equals(whUser.getForType())) {
			errors.rejectValue("forType", null, "please enter the for type");
		}
		if ("".equals(whUser.getEmail())) {
			errors.rejectValue("email", null, "please enter the email");
		}
		if ("".equals(whUser.getContact())) {
			errors.rejectValue("contact", null, "please enter the contact");
		}
		if ("".equals(whUser.getIdType())) {
			errors.rejectValue("idType", null, "please enter the UserId Type");
		}
		if ("".equals(whUser.getIfOther())) {
			errors.rejectValue("ifOther", null, "please enter the ifOther");
		}
		if ("".equals(whUser.getIdNum())) {
			errors.rejectValue("idNum", null, "please enter the idNum");
		}
	}

}
