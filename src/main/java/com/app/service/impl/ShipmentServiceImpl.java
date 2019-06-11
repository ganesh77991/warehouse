package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentService;

@Service
public class ShipmentServiceImpl implements IShipmentService {

	@Autowired
	private IShipmentDao dao;
	
	@Override
	@Transactional
	public Integer createShipment(ShipmentType ship) {
		// TODO Auto-generated method stub
		return dao.createShipment(ship);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipments() {
		// TODO Auto-generated method stub
		return dao.getAllShipments();
	}

	@Override
	@Transactional(readOnly=true)
	public ShipmentType getOneShipmentById(Integer omId) {
		// TODO Auto-generated method stub
		return dao.getOneShipmentById(omId);
	}

	@Override
	@Transactional
	public void deleteShipment(Integer omId) {
		// TODO Auto-generated method stub
		dao.deleteShipment(omId);
		
	}

	@Override
	@Transactional
	public void updateShipment(ShipmentType om) {
		// TODO Auto-generated method stub
		dao.updateShipment(om);
		
	}

}
