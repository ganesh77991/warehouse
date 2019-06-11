package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {

	@Autowired
	private IOrderMethodService service;
	
	@Autowired 
	private OrderMethodValidator omValidator;
	
	//1. order method show form
	@RequestMapping("/show")
	public String showOrderMethod(ModelMap map) {
		System.out.println("OrderMethodController.createOrderMethod()");
		map.addAttribute("om", new OrderMethod());
		return "orderMethodCreate";
	}
	//2. order method create
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createOrderMethod(@ModelAttribute("om") OrderMethod om,Errors errors,ModelMap map) {
		System.out.println(om);
		omValidator.validate(om, errors);
		
		if (!errors.hasErrors()) {
			
		Integer oredr_Id=service.createOrderMethod(om);
		String msg="created Order '"+oredr_Id+"' successfully...";
		map.addAttribute("message", msg);
		
		}
		
		return "orderMethodCreate";
	}
	//3. OrderMethod show all
	@RequestMapping("/all")
	public String getAllOrderMethods(ModelMap map) {
		System.out.println("OrderMethodController.getAllOrderMethods()");
		List<OrderMethod> list=service.getAllOrderMethods();
		System.out.println(list);
		map.addAttribute("orderMethods", list);
		
		return "orderMethodData";
	}
	
	//4. OrderMethod update show form
	@RequestMapping("/update")
	public String showUpdateOrderMethod(@RequestParam Integer orderMethodId,ModelMap map) {
			
		OrderMethod OrderMethod=service.getOneOrderMethodById(orderMethodId);
		System.out.println(OrderMethod);
		if(OrderMethod!=null) {
			map.addAttribute("OrderMethod", OrderMethod);
			
			
			return "orderMethodUpdate";

		}
		List<OrderMethod> list=service.getAllOrderMethods();
		map.addAttribute("orderMethods", list);
		map.addAttribute("message", "record "+orderMethodId+" is not found to update");
		return "orderMethodData";
		
		
	}
	//5. OrderMethod update 
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateOrderMethod(@ModelAttribute OrderMethod OrderMethod,ModelMap map) {

		System.out.println(OrderMethod);
		
		service.updateOrderMethod(OrderMethod);
		
		String msg="updated '"+OrderMethod.getId()+"' successfully...";
		map.addAttribute("message", msg);
		List<OrderMethod> list=service.getAllOrderMethods();
		map.addAttribute("orderMethods", list);
		
		return "orderMethodData";
	}
	//6. OrderMethod delete
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam Integer orderMethodId,ModelMap map) {
		
		String msg=null;
		
		try {
		service.deleteOrderMethod(orderMethodId);
		 msg="deleted '"+orderMethodId+"' successfully...";
		}catch (HibernateOptimisticLockingFailureException e) {
			msg="record "+orderMethodId+" is not Found to delete ";
		}
		
		map.addAttribute("message", msg);
		List<OrderMethod> list=service.getAllOrderMethods();
		map.addAttribute("orderMethods", list);
		
		return "orderMethodData";
	}
}
