package com.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WhUserType_tab")
public class WhUserType {

	@Id
	@GeneratedValue(generator="gen_name")
	@GenericGenerator(name = "gen_name", strategy = "increment")
	@Column(name = "whuser_id")
	private Integer id;
	@Column(name = "whuser_type")
	private String type;
	@Column(name = "whuser_code")
	private String code;
	@Column(name = "whuser_fortype")
	private String forType;
	@Column(name = "whuser_email")
	private String email;
	@Column(name = "whuser_contact")
	private String contact;
	@Column(name = "whuser_idtype")
	private String idType;
	@Column(name = "whuser_ifother")
	private String ifOther;
	@Column(name = "whuser_idnum")
	private String idNum;

	public WhUserType() {
		super();
	}

	public WhUserType(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getForType() {
		return forType;
	}

	public void setForType(String forType) {
		this.forType = forType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIfOther() {
		return ifOther;
	}

	public void setIfOther(String ifOther) {
		this.ifOther = ifOther;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Override
	public String toString() {
		return "WhUserType [id=" + id + ", type=" + type + ", code=" + code + ", forType=" + forType + ", email="
				+ email + ", contact=" + contact + ", idType=" + idType + ", ifOther=" + ifOther + ", idNum=" + idNum
				+ "]";
	}

}
