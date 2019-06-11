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

import com.app.model.ShipmentType;
import com.app.service.IShipmentService;
import com.app.validator.ShipmentValidator;

@Controller
@RequestMapping("/ship")
public class ShipmentController {

	@Autowired
	private IShipmentService service;
	
	@Autowired
	private ShipmentValidator shipValidator;
	
	@RequestMapping("/show")
	public String showShip(ModelMap map) {
		System.out.println("ShipmentController.showShip()");
		map.addAttribute("ship", new ShipmentType());
		return "shipmentTypeCreate";
	}
	
	@RequestMapping(value="create",method=RequestMethod.POST)
	public String createShipment(@ModelAttribute("ship") ShipmentType ship,Errors errors,ModelMap map) {
		
		System.out.println(ship);
		shipValidator.validate(ship, errors);
		
	if (!errors.hasErrors()) {
		
		Integer shipId=service.createShipment(ship);
		String msg="Shipment Created '"+shipId+"' successfully";
		map.addAttribute("message", msg);
		
	}
		return "shipmentTypeCreate";
	}
	//3. ShipmentType show all
	@RequestMapping("/all")
	public String getAllShipmentTypes(ModelMap map) {
		
		List<ShipmentType> list=service.getAllShipments();
		System.out.println(list);
		System.out.println("all from shipment");
		map.addAttribute("ships", list);
		
		return "shipmentTypeData";
	}
	
	//4. ShipmentType update show form
	@RequestMapping("/update")
	public String showUpdateShipmentType(@RequestParam Integer shipId,ModelMap map) {
		ShipmentType ShipmentType=service.getOneShipmentById(shipId);
		map.addAttribute("ship", ShipmentType);
		
		
		return "shipmentTypeUpdate";
	}
	//5. ShipmentType update 
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType ShipmentType,ModelMap map) {

		System.out.println(ShipmentType);
		
		service.updateShipment(ShipmentType);
		
		String msg="updated '"+ShipmentType.getId()+"' successfully...";
		map.addAttribute("message", msg);
		List<ShipmentType> list=service.getAllShipments();
		map.addAttribute("ships", list);
		
		return "shipmentTypeData";
	}
	//6. ShipmentType delete
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam Integer shipId,ModelMap map) {
		service.deleteShipment(shipId);
		
		String msg="updated '"+shipId+"' successfully...";
		map.addAttribute("message", msg);
		List<ShipmentType> list=service.getAllShipments();
		map.addAttribute("ships", list);
		
		return "shipmentTypeData";
	}
}
