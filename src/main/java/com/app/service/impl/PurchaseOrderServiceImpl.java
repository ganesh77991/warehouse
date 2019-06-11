package com.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.PurchaseOrder;
import com.app.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{

	@Override
	@Transactional
	public Integer save(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public PurchaseOrder edit(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(Integer purchaseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public List<PurchaseOrder> gerAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
