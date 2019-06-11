package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Vendor;

@Component
public class VendorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Vendor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Vendor vendor = (Vendor) target;

		System.out.println("VendorValidator.validate()");

		if ("".equals(vendor.getVenName())) {

			errors.rejectValue("venName", null, "please enter the vendor name");

		}

		if ("".equals(vendor.getVenCode())) {

			errors.rejectValue("venCode", null, "please enter the vendor code");

		}
		if (vendor.getVenDesg() == null) {

			errors.rejectValue("venDesg", null, "select one designation");

		}
		if (vendor.getVenPreserve().isEmpty()) {

			errors.rejectValue("venPreserve", null, "select atleast one preserve");

		}

	}

}
