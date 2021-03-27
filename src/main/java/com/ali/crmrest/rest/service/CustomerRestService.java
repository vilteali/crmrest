package com.ali.crmrest.rest.service;

import java.util.List;

import com.ali.crmrest.entity.Customer;

public interface CustomerRestService {

	List<Customer> getCustomers();

	Customer getCustomer(Integer id);

	void saveCustomer(Customer theCustomer);

	void deleteCustomer(Integer id);
	
}
