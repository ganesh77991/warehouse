package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerDao;
import com.app.model.Customer;
import com.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	@Transactional
	public Integer createCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return dao.createCustomer(cust);
	}

	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

	@Transactional(readOnly=true)
	public Customer getOneCustomerById(Integer custId) {
		// TODO Auto-generated method stub
		return dao.getOneCustomerById(custId);
	}

	@Transactional
	public void deleteCustomer(Integer custId) {
		// TODO Auto-generated method stub
		dao.deleteCustomer(custId);

	}

	@Override
	@Transactional
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		dao.updateCustomer(cust);

	}

}
