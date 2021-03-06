package com.ali.crmrest.service;

import java.util.List;

import com.ali.crmrest.entity.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();

	Customer getCustomer(Integer id);

	void saveCustomer(Customer theCustomer);

	void deleteCustomer(Integer id);

	List<Customer> searchCustomer(String searchCustomer);
	
}
