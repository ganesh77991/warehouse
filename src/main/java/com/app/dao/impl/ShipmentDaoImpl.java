package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentDao;
import com.app.model.ShipmentType;

@Repository
public class ShipmentDaoImpl implements IShipmentDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer createShipment(ShipmentType ship) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(ship);
	}

	@Override
	public List<ShipmentType> getAllShipments() {
		// TODO Auto-generated method stub
		return ht.loadAll(ShipmentType.class);
	}

	@Override
	public ShipmentType getOneShipmentById(Integer omId) {
		// TODO Auto-generated method stub
		return ht.get(ShipmentType.class, omId);
	}

	@Override
	public void deleteShipment(Integer omId) {
		// TODO Auto-generated method stub
		ht.delete(new ShipmentType(omId));
		
	}

	@Override
	public void updateShipment(ShipmentType om) {
		// TODO Auto-generated method stub
		
		ht.update(om);
		
	}

}
