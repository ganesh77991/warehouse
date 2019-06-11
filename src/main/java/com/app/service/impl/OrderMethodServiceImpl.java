package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Service
public class OrderMethodServiceImpl implements IOrderMethodService {

	@Autowired
	private IOrderMethodDao dao;
	
	@Override
	@Transactional
	public Integer createOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		return dao.createOrderMethod(om);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethods() {
		// TODO Auto-generated method stub
		return dao.getAllOrderMethods();
	}

	@Override
	@Transactional(readOnly=true)
	public OrderMethod getOneOrderMethodById(Integer omId) {
		// TODO Auto-generated method stub
		return dao.getOneOrderMethodById(omId);
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer omId) {
		// TODO Auto-generated method stub
		dao.deleteOrderMethod(omId);
		
	}

	@Override
	@Transactional
	public void updateOrderMethod(OrderMethod om) {
		// TODO Auto-generated method stub
		dao.updateOrderMethod(om);
		
	}
	
	@Override
	@Transactional
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		// TODO Auto-generated method stub
		return dao.getOrderMethodByMode(mode);
	}

}
