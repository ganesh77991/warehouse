package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserService;

@Service
public class WhUserServiceImpl implements IWhUserService {

	@Autowired
	private IWhUserTypeDao dao;
	
	@Override
	@Transactional
	public Integer createWhUserType(WhUserType user) {
		// TODO Auto-generated method stub
		return dao.createWhUserType(user);
	}

	@Override
	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUserTypes() {
		// TODO Auto-generated method stub
		return dao.getAllWhUserTypes();
	}

	@Override
	@Transactional(readOnly=true)
	public WhUserType getOneWhUserTypeById(Integer omId) {
		// TODO Auto-generated method stub
		return dao.getOneWhUserTypeById(omId);
	}

	@Override
	@Transactional
	public void deleteWhUserType(Integer omId) {
		// TODO Auto-generated method stub
		dao.deleteWhUserType(omId);
		
	}

	@Override
	@Transactional
	public void updateWhUserType(WhUserType om) {
		// TODO Auto-generated method stub
		dao.updateWhUserType(om);
		
	}

	@Override
	public List<WhUserType> getWhUserTypesByType(String userType) {
		// TODO Auto-generated method stub
		return dao.getWhUserTypesByType(userType);
	}

}
