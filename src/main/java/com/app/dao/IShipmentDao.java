package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentDao {

	public Integer createShipment(ShipmentType ship);
	
	public List<ShipmentType> getAllShipments();

	public ShipmentType getOneShipmentById(Integer omId);

	public void deleteShipment(Integer omId);

	public void updateShipment(ShipmentType om);
}
