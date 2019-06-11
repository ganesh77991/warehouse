package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUomDao;
import com.app.model.Uom;
import com.app.service.IUomService;

@Service
public class UomServiceImpl implements IUomService {

	@Autowired
	private IUomDao dao;
	
	@Override
	@Transactional
	public Integer createUom(Uom uom) {
		// TODO Auto-generated method stub
		return dao.createUom(uom);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uom> getAllUoms() {
		// TODO Auto-generated method stub
		return dao.getAllUoms();
	}

	@Override
	@Transactional(readOnly=true)
	public Uom getOneUomById(Integer uomId) {
		// TODO Auto-generated method stub
		return dao.getOneUomById(uomId);
	}

	@Override
	@Transactional
	public void deleteUom(Integer uomId) {
		// TODO Auto-generated method stub
		dao.deleteUom(uomId);
		
	}

	@Override
	@Transactional
	public void updateUom(Uom uom) {
		// TODO Auto-generated method stub
		
		System.out.println(uom);
		
		dao.updateUom(uom);
		
	}

	@Override
	@Transactional(readOnly=true)
	public boolean isUomModelExist(String model) {
		// TODO Auto-generated method stub
		return dao.isUomModelExist(model);
	}

}
