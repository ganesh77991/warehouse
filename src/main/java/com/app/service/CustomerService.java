package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface CustomerService {

	public Integer createCustomer(Customer cust);

	public List<Customer> getAllCustomers();

	public Customer getOneCustomerById(Integer custId);

	public void deleteCustomer(Integer custId);

	public void updateCustomer(Customer cust);
}
