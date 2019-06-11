package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;


@Component
public class UomValidator implements Validator{
	
	@Autowired
	private IUomService service;

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("UomValidator.validate()");
		
		Uom uom=(Uom) obj;
		
		if("".equals(uom.getType())){
			errors.rejectValue("type", null, "please choose one type");
		}
		if("".equals(uom.getModel()) || Pattern.compile("[A-Z]{4}").matcher(uom.getModel()).matches()){
			errors.rejectValue("model", null, "please enter A-Z 4 chars one model");
		}
		else if(service.isUomModelExist(uom.getModel())) {
			errors.rejectValue("model", null, "entered model is already existed");
		}
		
		if("".equals(uom.getDsc())){
			errors.rejectValue("dsc", null, "please enter one Description");
		}
	}

}
