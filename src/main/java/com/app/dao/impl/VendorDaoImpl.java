package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.VendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements VendorDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer createVendor(Vendor user) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(user);
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return ht.loadAll(Vendor.class);
	}

	@Override
	public Vendor getOneVendorById(Integer venId) {
		// TODO Auto-generated method stub
		return ht.get(Vendor.class, venId);
	}

	@Override
	public void deleteVendor(Integer venId) {
		// TODO Auto-generated method stub
		ht.delete(new Vendor(venId));

	}

	@Override
	public void updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		ht.update(vendor);

	}

}
