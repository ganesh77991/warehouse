package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface PurchaseOrderDao {

	public Integer save(PurchaseOrder purchaseOrder);

	public PurchaseOrder edit(PurchaseOrder purchaseOrder);

	public void delete(Integer purchaseId);

	public PurchaseOrder getOnePurchaseOrderById(Integer purchaseId);

	public List<PurchaseOrder> gerAllPurchaseOrders();
}
