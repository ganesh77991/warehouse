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
@Table(name = "cust_tab")
public class Customer {

	@Id
	@GeneratedValue(generator="gen_name")
	@GenericGenerator(name = "gen_name", strategy = "increment")
	@Column(name = "cust_id")
	private Integer custId;
	@Column(name = "cust_code")
	private String custCode;
	@Column(name = "cust_addr")
	private String custAddr;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="cust_locs",joinColumns=@JoinColumn(name="cust_id"))
	@OrderColumn(name="pos")
	@Column(name = "data")
	private List<String> custLocs;

	@Column(name = "cust_enabled")
	private String custEnabled="No";
	@Column(name = "cust_email")
	private String custEmail;
	@Column(name = "cust_contact")
	private String custContact;

	public Customer() {
		super();
	}

	public Customer(Integer custId) {
		super();
		this.custId = custId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public List<String> getCustLocs() {
		return custLocs;
	}

	public void setCustLocs(List<String> custLocs) {
		this.custLocs = custLocs;
	}

	public String getCustEnabled() {
		return custEnabled;
	}

	public void setCustEnabled(String custEnabled) {
		this.custEnabled = custEnabled;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCode=" + custCode + ", custAddr=" + custAddr + ", custLocs="
				+ custLocs + ", custEnabled=" + custEnabled + ", custEmail=" + custEmail + ", custContact="
				+ custContact + "]";
	}

	
}
