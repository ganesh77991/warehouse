package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Item item=(Item) target;
		
		if ("".equals(item.getItemCode())) {
			errors.rejectValue("itemCode", null, "please enter the code");
		}
		if (item.getItemWidth()<=0 || item.getItemHeight() <=0 || item.getItemLength()<=0) {
			errors.rejectValue("itemDimensions", null, "please enter the valid dimensions");
		}
		
		if ("".equals(item.getItemBaseCost())) {
			errors.rejectValue("itemBaseCost", null, "please enter the base cost");
		}
		if ("".equals(item.getItemBaseCurrency())) {
			errors.rejectValue("itemBaseCurrency", null, "please enter the base currency");
		}
		if (item.getUom().getId()==null) {
			errors.rejectValue("uom.id", null, "please select one Uom");
		}
		if (item.getSalesType().getId()==null) {
			errors.rejectValue("salesType.id", null, "please select one salesType");
		}
		if (item.getPurchaseType().getId()==null) {
			errors.rejectValue("purchaseType.id", null, "please select one purchaseType");
		}
		if (item.getVenUsers().isEmpty()) {
			errors.rejectValue("venUsers", null, "please select one vendor user");
		}
		if (item.getCustUsers().isEmpty()) {
			errors.rejectValue("custUsers", null, "please select one customer user");
		}
		
	}

}
