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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.service.ItemService;
import com.app.validator.UomValidator;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;

	@Autowired
	private UomValidator uomValidator;

	@Autowired
	private ItemService itemService;

	// 1. uom Show form
	@RequestMapping("/show")
	public String show(ModelMap map) {
		Uom u = new Uom();
		map.addAttribute("uom", u);
		return "uomCreate";
	}

	// 2. uom create
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String uomCreate(@ModelAttribute Uom uom, Errors errors, ModelMap map) {
		System.out.println(uomValidator.getClass().getName());
		uomValidator.validate(uom, errors);

		System.out.println(errors.hasErrors());

		if (!errors.hasErrors()) {

			Integer uId = service.createUom(uom);
			String msg = "created '" + uId + "' successfully...";
			map.addAttribute("message", msg);

		}
		return "uomCreate";
	}

	// 3. uom show all
	@RequestMapping("/all")
	public String getAllUoms(ModelMap map) {

		List<Uom> list = service.getAllUoms();
		System.out.println(list);
		map.addAttribute("uoms", list);

		return "uomData";
	}

	// 4. uom update show form
	@RequestMapping("/update")
	public String showUpdateUom(@RequestParam Integer uomId, ModelMap map) {

		Uom uom = service.getOneUomById(uomId);
		if (uom != null) {
			map.addAttribute("uom", uom);

			return "uomUpdate";
		}

		List<Uom> list = service.getAllUoms();
		map.addAttribute("uoms", list);
		map.addAttribute("message", "record " + uomId + " is not found to update");

		return "uomData";

	}

	// 5. uom update
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUom(@ModelAttribute Uom uom, Errors errors, ModelMap map) {

		uomValidator.validate(uom, errors);
		System.out.println(!errors.hasErrors());

		if (!errors.hasErrors()) {

			service.updateUom(uom);

			String msg = "updated '" + uom.getId() + "' successfully...";
			map.addAttribute("message", msg);
			List<Uom> list = service.getAllUoms();
			map.addAttribute("uoms", list);

			return "uomData";
		}

		return "uomUpdate";
	}

	// 6. uom delete
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer uomId, ModelMap map) {

		String msg = null;

		try {

			if (itemService.isUomConnectedWithItem(uomId)) {

				System.out.println(itemService.isUomConnectedWithItem(uomId));
				msg = " Uom " + uomId + " con`t delete this is used in Item";

			} else {
				System.out.println(itemService.isUomConnectedWithItem(uomId));
				service.deleteUom(uomId);

				msg = "deleted '" + uomId + "' successfully...";
			}

		} catch (Exception e) {
			msg = "record is  '" + uomId + "' not found to delete";
		}

		map.addAttribute("message", msg);
		List<Uom> list = service.getAllUoms();
		map.addAttribute("uoms", list);

		return "uomData";
	}

}
