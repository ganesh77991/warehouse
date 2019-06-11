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

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserService;
import com.app.service.ItemService;
import com.app.validator.ItemValidator;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService service;

	@Autowired
	private IUomService uomService;

	@Autowired
	private IOrderMethodService omService;

	@Autowired
	private IWhUserService whuserService;

	@Autowired
	private ItemValidator itemValidator;

	// 1. Item Show form
	@RequestMapping("/create")
	public String show(ModelMap map) {
		Item item = new Item();
		map.addAttribute("item", item);

		// get uoms objs
		List<Uom> uoms = uomService.getAllUoms();
		map.addAttribute("uoms", uoms);

		// order method get sales
		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		// order method get purchase
		List<OrderMethod> purchases = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchases", purchases);

		// WhuserService vendors
		List<WhUserType> vendors = whuserService.getWhUserTypesByType("vendor");
		System.out.println("vendors---------------");
		System.out.println(vendors);
		map.addAttribute("vendors", vendors);

		// WhuserService Customers
		List<WhUserType> customers = whuserService.getWhUserTypesByType("customer");
		System.out.println("purchase-------------");
		System.out.println(customers);
		map.addAttribute("customers", customers);

		return "itemCreate";
	}

	// 2. Item create
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String ItemCreate(@ModelAttribute Item item, Errors errors, ModelMap map) {
		System.out.println("ItemController.ItemCreate()");
		System.out.println(item);

		itemValidator.validate(item, errors);

		if (!errors.hasErrors()) {

			Integer itemId = service.createItem(item);
			String msg = "created '" + itemId + "' successfully...";
			map.addAttribute("message", msg);

		}
		// get uoms objs
		List<Uom> uoms = uomService.getAllUoms();
		map.addAttribute("uoms", uoms);

		// order method get sales
		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		// order method get purchase
		List<OrderMethod> purchases = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchases", purchases);

		// WhuserService vendors
		List<WhUserType> vendors = whuserService.getWhUserTypesByType("vendor");
		System.out.println("vendors---------------");
		System.out.println(vendors);
		map.addAttribute("vendors", vendors);

		// WhuserService Customers
		List<WhUserType> customers = whuserService.getWhUserTypesByType("customer");
		System.out.println("purchase-------------");
		System.out.println(customers);
		map.addAttribute("customers", customers);

		return "itemCreate";
	}

	// 3. Item show all
	@RequestMapping("/all")
	public String getAllItems(ModelMap map) {
			System.out.println("from all data");
		List<Item> list = service.getAllItems();
		System.out.println("ItemController.getAllItems()");
		System.out.println(list);
		map.addAttribute("items", list);

		return "itemData";
	}

	// 4. Item update show form
	@RequestMapping("/update")
	public String showUpdateItem(@RequestParam Integer itemId, ModelMap map) {

		Item item = service.getOneItemById(itemId);
		map.addAttribute("item", item);

		// get uoms objs
		List<Uom> uoms = uomService.getAllUoms();
		map.addAttribute("uoms", uoms);

		// order method get sales
		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		// order method get purchase
		List<OrderMethod> purchases = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchases", purchases);

		// WhuserService vendors
		List<WhUserType> vendors = whuserService.getWhUserTypesByType("vendor");
		System.out.println("vendors---------------");
		System.out.println(vendors);
		map.addAttribute("vendors", vendors);

		// WhuserService Customers
		List<WhUserType> customers = whuserService.getWhUserTypesByType("customer");
		System.out.println("purchase-------------");
		System.out.println(customers);
		map.addAttribute("customers", customers);

		return "itemUpdate";
	}

	// 5. Item update
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateItem(@ModelAttribute Item item, Errors errors, ModelMap map) {

		System.out.println(item);

		itemValidator.validate(item, errors);

		if (!errors.hasErrors()) {

			service.updateItem(item);

			String msg = "updated '" + item.getItemId() + "' successfully...";
			map.addAttribute("message", msg);
			List<Item> list = service.getAllItems();
			map.addAttribute("items", list);
			return "itemData";
		}

		// get uoms objs
		List<Uom> uoms = uomService.getAllUoms();
		map.addAttribute("uoms", uoms);

		// order method get sales
		List<OrderMethod> sales = omService.getOrderMethodByMode("sale");
		map.addAttribute("sales", sales);

		// order method get purchase
		List<OrderMethod> purchases = omService.getOrderMethodByMode("purchase");
		map.addAttribute("purchases", purchases);

		// WhuserService vendors
		List<WhUserType> vendors = whuserService.getWhUserTypesByType("vendor");
		System.out.println("vendors---------------");
		System.out.println(vendors);
		map.addAttribute("vendors", vendors);

		// WhuserService Customers
		List<WhUserType> customers = whuserService.getWhUserTypesByType("customer");
		System.out.println("purchase-------------");
		System.out.println(customers);
		map.addAttribute("customers", customers);

		return "itemUpdate";

	}

	// 6. Item delete
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam Integer itemId, ModelMap map) {
		service.deleteItem(itemId);

		String msg = "updated '" + itemId + "' successfully...";
		map.addAttribute("message", msg);
		List<Item> list = service.getAllItems();
		map.addAttribute("items", list);

		return "itemData";
	}

}
