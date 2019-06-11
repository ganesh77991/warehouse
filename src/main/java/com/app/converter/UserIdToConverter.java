package com.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.WhUserType;
import com.app.service.IWhUserService;

@Component
public class UserIdToConverter implements Converter<Object, WhUserType> {

	@Autowired
	private IWhUserService service;

	public WhUserType convert(Object whId) {
		// TODO Auto-generated method stub

		try {

			Integer id = Integer.parseInt((String) whId);
			

			return service.getOneWhUserTypeById(id);

		} catch (Exception e) {

			return new WhUserType();
		}

	}

}
