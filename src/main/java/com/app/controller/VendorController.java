package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Vendor;
import com.app.service.VendorService;
import com.app.validator.VendorValidator;

@Controller
@RequestMapping("vendor")
public class VendorController {

	@Autowired
	private VendorService service;

	@Autowired
	private VendorValidator venValidator;

	@RequestMapping("create")
	public String showVendorform(ModelMap map) {

		System.out.println("VendorController.showVendorform()");

		map.addAttribute("vendor", new Vendor());

		return "vendorCreate";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createVendor(@ModelAttribute Vendor vendor, Errors errors, ModelMap map) {

		System.out.println(vendor);

		venValidator.validate(vendor, errors);

		if (!errors.hasErrors()) {

			Integer venId = service.createVendor(vendor);

			String msg = "created vendor " + venId + " successfully";
			map.addAttribute("message", msg);
			map.addAttribute("vendor", new Vendor());
		}

		return "vendorCreate";
	}

	@RequestMapping("/all")
	public String showData(ModelMap map) {

		List<Vendor> vendors = service.getAllVendors();
		System.out.println(vendors);

		map.addAttribute("vendors", vendors);

		return "vendorData";
	}

	@RequestMapping("delete")
	public String deleteVendor(@RequestParam("vendorId") Integer venId, ModelMap map) {

		service.deleteVendor(venId);

		List<Vendor> vendors = service.getAllVendors();
		map.addAttribute("vendors", vendors);

		String msg = "vendor " + venId + " is delete successfully";
		map.addAttribute("message", msg);
		return "vendorData";
	}

	@RequestMapping("/update")
	public String getVendorById(@RequestParam("vendorId") Integer venId,ModelMap map) {

		
			Vendor vendor = service.getOneVendorById(venId);

			map.addAttribute("vendor", vendor);
		
		return "vendorUpdate";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateVendor(@ModelAttribute Vendor vendor,Errors errors,ModelMap map) {
			
		venValidator.validate(vendor, errors);

		if (!errors.hasErrors()) {

			service.updateVendor(vendor);
			String msg="vendor "+vendor.getVenId()+" is updated";
			
			map.addAttribute("message", msg);
			List<Vendor> list=service.getAllVendors();
			map.addAttribute("vendors", list);
			
			return "vendorData";
		}
		
		return "vendorUpdate";
	}
}
