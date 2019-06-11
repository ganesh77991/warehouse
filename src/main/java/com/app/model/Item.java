package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author admin
 *
 */
@Entity
@Table(name = "item_tab")
public class Item {

	@Id
	@GeneratedValue(generator="gen_name")
	@GenericGenerator(name = "gen_name", strategy = "increment")
	@Column(name = "item_id")
	private Integer itemId;
	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_width")
	private double itemWidth;

	@Column(name = "item_lenth")
	private double itemLength;

	@Column(name = "item_height")
	private double itemHeight;

	@Column(name = "item_basecost")
	private String itemBaseCost;
	@Column(name = "item_basecurrency")
	private String itemBaseCurrency;
	
	@ManyToOne
	@JoinColumn(name="uidFk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="omsaleId")
	private OrderMethod salesType;
	
	@ManyToOne
	@JoinColumn(name="ompurchaseId")
	private OrderMethod purchaseType;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "itm_venusr_tab", 
	joinColumns = @JoinColumn(name = "itmIdFk"), 
	inverseJoinColumns = @JoinColumn(name = "venIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> venUsers=new ArrayList<WhUserType>(0);

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "itm_custs_tab", 
	joinColumns = @JoinColumn(name = "itmIdfk"), 
	inverseJoinColumns = @JoinColumn(name = "custIdFk"))
	@Fetch(value = FetchMode.SUBSELECT)
	private List<WhUserType> custUsers=new ArrayList<WhUserType>(0);

	public List<WhUserType> getCustUsers() {
		return custUsers;
	}

	public void setCustUsers(List<WhUserType> custUsers) {
		this.custUsers = custUsers;
	}

	public Item() {
		super();
	}

	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public double getItemWidth() {
		return itemWidth;
	}

	public void setItemWidth(double itemWidth) {
		this.itemWidth = itemWidth;
	}

	public double getItemLength() {
		return itemLength;
	}

	public void setItemLength(double itemLength) {
		this.itemLength = itemLength;
	}

	public double getItemHeight() {
		return itemHeight;
	}

	public void setItemHeight(double itemHeight) {
		this.itemHeight = itemHeight;
	}

	public String getItemBaseCost() {
		return itemBaseCost;
	}

	public void setItemBaseCost(String itemBaseCost) {
		this.itemBaseCost = itemBaseCost;
	}

	public String getItemBaseCurrency() {
		return itemBaseCurrency;
	}

	public void setItemBaseCurrency(String itemBaseCurrency) {
		this.itemBaseCurrency = itemBaseCurrency;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public OrderMethod getSalesType() {
		return salesType;
	}

	public void setSalesType(OrderMethod salesType) {
		this.salesType = salesType;
	}

	public OrderMethod getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}

	public List<WhUserType> getVenUsers() {
		return venUsers;
	}

	public void setVenUsers(List<WhUserType> venUsers) {
		this.venUsers = venUsers;
	}

	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", itemWidth=" + itemWidth + ", itemLength="
				+ itemLength + ", itemHeight=" + itemHeight + ", itemBaseCost=" + itemBaseCost + ", itemBaseCurrency="
				+ itemBaseCurrency + ", uom=" + uom + ", salesType=" + salesType + ", purchaseType=" + purchaseType
				+ ", venUsers=" + venUsers + ", custUsers=" + custUsers + "]";
	}

	
}
