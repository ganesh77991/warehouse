package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentService {

	public Integer createShipment(ShipmentType ship);
	
	public List<ShipmentType> getAllShipments();

	public ShipmentType getOneShipmentById(Integer omId);

	public void deleteShipment(Integer omId);

	public void updateShipment(ShipmentType om);
}
