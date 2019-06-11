package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.CustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private HibernateTemplate ht;

	
	public Integer createCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(cust);
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return ht.loadAll(Customer.class);
	}

	public Customer getOneCustomerById(Integer custId) {
		// TODO Auto-generated method stub
		return ht.get(Customer.class, custId);
	}

	public void deleteCustomer(Integer custId) {
		// TODO Auto-generated method stu
		ht.delete(new Customer(custId));

	}

	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		ht.update(cust);

	}

	

}
