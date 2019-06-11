package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface VendorDao {

	public Integer createVendor(Vendor user);

	public List<Vendor> getAllVendors();

	public Vendor getOneVendorById(Integer omId);

	public void deleteVendor(Integer omId);

	public void updateVendor(Vendor om);

}
