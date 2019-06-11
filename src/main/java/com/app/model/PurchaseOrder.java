package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "purchase_order_tab")
public class PurchaseOrder {
	@Id
	@GeneratedValue(generator = "gen_name")
	@GenericGenerator(name = "gen_name", strategy = "increment")
	@Column(name="purchase_id")
	private Integer purchaseId;
	
	@Column(name = "purchase_code")
	private String purchaseOrderCode;
	
	@Column(name = "shipment_code")
	private ShipmentType shipmentCode;
	
	@Column(name="vendor_id_fk")
	private Vendor vendor;
	
	@Column(name = "ref_number")
	private String refNumber;
	
	@Column(name = "purchase_check")
	private String purchaseCheck;
	
	@Column(name = "purchase_status")
	private String purchaseStatus;
	
	@Column(name = "purchase_description")
	private String purchaseDescription;
	
	public PurchaseOrder() {
		super();
	}
	public PurchaseOrder(Integer purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}
	public PurchaseOrder(Integer purchaseId, String purchaseOrderCode, ShipmentType shipmentCode, Vendor vendor,
			String refNumber, String purchaseCheck, String purchaseStatus, String purchaseDescription) {
		super();
		this.purchaseId = purchaseId;
		this.purchaseOrderCode = purchaseOrderCode;
		this.shipmentCode = shipmentCode;
		this.vendor = vendor;
		this.refNumber = refNumber;
		this.purchaseCheck = purchaseCheck;
		this.purchaseStatus = purchaseStatus;
		this.purchaseDescription = purchaseDescription;
	}
	public Integer getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseOrderCode() {
		return purchaseOrderCode;
	}
	public void setPurchaseOrderCode(String purchaseOrderCode) {
		this.purchaseOrderCode = purchaseOrderCode;
	}
	public ShipmentType getShipmentCode() {
		return shipmentCode;
	}
	public void setShipmentCode(ShipmentType shipmentCode) {
		this.shipmentCode = shipmentCode;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getPurchaseCheck() {
		return purchaseCheck;
	}
	public void setPurchaseCheck(String purchaseCheck) {
		this.purchaseCheck = purchaseCheck;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public String getPurchaseDescription() {
		return purchaseDescription;
	}
	public void setPurchaseDescription(String purchaseDescription) {
		this.purchaseDescription = purchaseDescription;
	}
	
	@Override
	public String toString() {
		return "PurchaseOrder [purchaseId=" + purchaseId + ", purchaseOrderCode=" + purchaseOrderCode
				+ ", shipmentCode=" + shipmentCode + ", vendor=" + vendor + ", refNumber=" + refNumber
				+ ", purchaseCheck=" + purchaseCheck + ", purchaseStatus=" + purchaseStatus + ", purchaseDescription="
				+ purchaseDescription + "]";
	}
	
	
}
