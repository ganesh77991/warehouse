package com.app.service;

import java.util.List;

import com.app.model.Vendor;

public interface VendorService {
	
	public Integer createVendor(Vendor user);

	public List<Vendor> getAllVendors();

	public Vendor getOneVendorById(Integer omId);

	public void deleteVendor(Integer omId);

	public void updateVendor(Vendor om);


}
