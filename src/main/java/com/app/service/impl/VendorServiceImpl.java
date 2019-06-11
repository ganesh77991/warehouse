package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VendorDao;
import com.app.model.Vendor;
import com.app.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	private VendorDao dao;

	@Override
	@Transactional
	public Integer createVendor(Vendor user) {
		// TODO Auto-generated method stub
		return dao.createVendor(user);
	}

	@Override
	@Transactional
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return dao.getAllVendors();
	}

	@Override
	@Transactional
	public Vendor getOneVendorById(Integer venId) {
		// TODO Auto-generated method stub
		return dao.getOneVendorById(venId);
	}

	@Override
	@Transactional
	public void deleteVendor(Integer venId) {
		// TODO Auto-generated method stub
		dao.deleteVendor(venId);

	}

	@Override
	@Transactional
	public void updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		dao.updateVendor(vendor);
	}

}
