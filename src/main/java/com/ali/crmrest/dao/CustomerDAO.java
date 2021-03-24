package com.ali.crmrest.dao;

import java.util.List;

import com.ali.crmrest.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();
	
	Customer getCustomer(Integer id);

	void saveCustomer(Customer theCustomer);
	
	void updateCustomer(Customer theCustomer);

	void deleteCustomer(Integer id);

	List<Customer> searchCustomers(String searchCustomer);
	
}
