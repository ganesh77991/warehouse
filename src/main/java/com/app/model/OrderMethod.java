package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order_methodtab")
public class OrderMethod {

	@Id
	@GeneratedValue(generator="gen_name")
	@GenericGenerator(name = "gen_name", strategy = "increment")
	@Column(name="order_id")
	private Integer id;
	@Column(name="order_mode")
	private String mode;
	@Column(name="order_code")
	private String code;
	@Column(name="order_method")
	private String method;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Accept",joinColumns=@JoinColumn(name="order_id"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private List<String> accept;
	@Column(name="order_dsc")
	private String dsc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public OrderMethod() {
		super();
	}
	public OrderMethod(int id) {
		super();
		this.id = id;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<String> getAccept() {
		return accept;
	}
	public void setAccept(List<String> accept) {
		this.accept = accept;
	}
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", mode=" + mode + ", code=" + code + ", method=" + method + ", accept="
				+ accept + ", dsc=" + dsc + "]";
	}
	
	
}
