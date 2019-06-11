package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="shipment_type_tab")
public class ShipmentType {

	@Id
	@GeneratedValue(generator="gen_name")
	@GenericGenerator(name = "gen_name", strategy = "increment")
	@Column(name="ship_Id")
	private Integer id;
	@Column(name="ship_mode")
	private String mode;
	@Column(name="ship_code")
	private String code;
	@Column(name="ship_enabled")
	private String enabled;
	@Column(name="ship_grade")
	private String grade;
	@Column(name="ship_dsc")
	private String dsc;
	
	public ShipmentType() {
		super();
	}

	public ShipmentType(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}

	@Override
	public String toString() {
		return "ShipmentType [id=" + id + ", mode=" + mode + ", code=" + code + ", enabled=" + enabled + ", grade="
				+ grade + ", dsc=" + dsc + "]";
	}

	
}
