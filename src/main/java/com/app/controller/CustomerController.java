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

import com.app.model.Customer;
import com.app.service.CustomerService;
import com.app.validator.CustomerValidator;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@Autowired
	private CustomerValidator custValidator;

	@RequestMapping("create")
	public String showCustomerForm(ModelMap map) {

		map.addAttribute("customer", new Customer());
		return "customerCreate";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createCustomer(@ModelAttribute Customer customer, Errors errors, ModelMap map) {

		custValidator.validate(customer, errors);

		if (!errors.hasErrors()) {

			Integer custId = service.createCustomer(customer);

			String msg = "customer is create '" + custId + "' successfully";

			map.addAttribute("message", msg);
			map.addAttribute("customer", new Customer());
		}

		return "customerCreate";
	}

	@RequestMapping("/all")
	public String displayData(ModelMap map) {

		System.out.println("CustomerController.displayData()");
		List<Customer> list = service.getAllCustomers();
		map.addAttribute("customers", list);

		return "customerData";
	}

	@RequestMapping("delete")
	public String deleteCustomer(@RequestParam("custId") Integer custId, ModelMap map) {

		System.out.println("CustomerController.deleteCustomer()" + custId);
		service.deleteCustomer(custId);
		String msg = "customer " + custId + " is deleted successfully";

		List<Customer> list = service.getAllCustomers();
		map.addAttribute("customers", list);

		map.addAttribute("message", msg);
		return "customerData";
	}

	@RequestMapping("update")
	public String getCustomerById(@RequestParam("custId") Integer custId, ModelMap map) {
		System.out.println("CustomerController.updateCustomer()" + custId);

		Customer customer = service.getOneCustomerById(custId);
		map.addAttribute("customer", customer);

		return "customerUpdate";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute Customer customer, Errors errors, ModelMap map) {

		custValidator.validate(customer, errors);

		if (!errors.hasErrors()) {

			service.updateCustomer(customer);

			String msg = "customer " + customer.getCustId() + " is updated";
			map.addAttribute("message", msg);

			List<Customer> list = service.getAllCustomers();
			map.addAttribute("customers", list);
			return "customerData";
		}
		return "customerUpdate";
	}

}
