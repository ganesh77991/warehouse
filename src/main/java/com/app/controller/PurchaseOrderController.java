package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.PurchaseOrder;

@Controller
@RequestMapping("purchase")
public class PurchaseOrderController {

	@RequestMapping("create")
	public String purchaseOrderform(ModelMap map) {
		
		System.out.println("PurchaseOrderController.purchaseOrderform()");
		map.addAttribute("purchaseOrder", new PurchaseOrder());
		
		return "purchaseOrderRegister";
	}
}
