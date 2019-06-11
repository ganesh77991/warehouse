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

import com.app.model.WhUserType;
import com.app.service.IWhUserService;
import com.app.validator.WhUserTypeValidator;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {

	@Autowired
	private IWhUserService service;
	
	@Autowired
	private WhUserTypeValidator whValidator;
	
	@RequestMapping("show")
	public String show(ModelMap map) {
		
		System.out.println("WhUserTypeController.show()");
		map.addAttribute("user", new WhUserType());
		return "WhUserTypeCreate";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createWhUser(@ModelAttribute("user") WhUserType user,Errors errors, ModelMap map) {
		
		whValidator.validate(user, errors);
		
		System.out.println(user);
		if (!errors.hasErrors()) {
			
		Integer userId=service.createWhUserType(user);
		String msg="Whuser created '"+userId+"' successfully";
		map.addAttribute("message", msg);
		
		}
		return "WhUserTypeCreate";
	}
	
	//3. WhUserType show all
	@RequestMapping("/all")
	public String getAllWhUserTypes(ModelMap map) {
		
		List<WhUserType> list=service.getAllWhUserTypes();
		System.out.println(list);
		map.addAttribute("whUsers", list);
		
		return "WhUserTypeData";
	}
	
	//4. WhUserType update show form
	@RequestMapping("/update")
	public String showUpdateWhUserType(@RequestParam Integer whUserTypeId,ModelMap map) {
		System.out.println(whUserTypeId);
		WhUserType whUserType=service.getOneWhUserTypeById(whUserTypeId);
		map.addAttribute("user", whUserType);
		
		
		return "WhUserTypeUpdate";
	}
	//5. WhUserType update 
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map) {

		System.out.println(whUserType);
		
		service.updateWhUserType(whUserType);
		
		String msg="updated '"+whUserType.getId()+"' successfully...";
		System.out.println(msg);
		map.addAttribute("message", msg);
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("whUsers", list);
		
		return "WhUserTypeData";
	}
	//6. WhUserType delete
	@RequestMapping("/delete")
	public String deleteWhUserType(@RequestParam Integer whUserTypeId,ModelMap map) {
		
		service.deleteWhUserType(whUserTypeId);
		
		String msg="updated '"+whUserTypeId+"' successfully...";
		map.addAttribute("message", msg);
		System.out.println(msg);
		List<WhUserType> list=service.getAllWhUserTypes();
		map.addAttribute("whUsers", list);
		
		return "WhUserTypeData";
	}
}
