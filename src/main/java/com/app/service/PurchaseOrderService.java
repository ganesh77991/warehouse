package com.app.service;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface PurchaseOrderService {

	public Integer save(PurchaseOrder purchaseOrder);

	public PurchaseOrder edit(PurchaseOrder purchaseOrder);

	public void delete(Integer purchaseId);

	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseId);

	public List<PurchaseOrder> gerAllPurchaseOrders();

}
