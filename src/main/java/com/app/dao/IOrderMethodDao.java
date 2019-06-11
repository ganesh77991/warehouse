package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {

	public Integer createOrderMethod(OrderMethod om);
	
	public List<OrderMethod> getAllOrderMethods();

	public OrderMethod getOneOrderMethodById(Integer omId);

	public void deleteOrderMethod(Integer omId);

	public void updateOrderMethod(OrderMethod om);

	public List<OrderMethod> getOrderMethodByMode(String mode);
}
