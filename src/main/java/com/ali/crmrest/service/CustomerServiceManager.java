package com.ali.crmrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ali.crmrest.api.exception.CustomerNotFoundException;
import com.ali.crmrest.dao.CustomerDAO;
import com.ali.crmrest.entity.Customer;

@Service
public class CustomerServiceManager implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer id) {
		
		Customer customer = customerDAO.getCustomer(id);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer ID not found: "+id);
		}
		
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer id) {
		
		Customer customer = customerDAO.getCustomer(id);
		if(customer.getId() == null) {
			throw new CustomerNotFoundException("Customer ID not found: "+id);
		}
		
		customerDAO.deleteCustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String searchCustomer) {
		
		return customerDAO.searchCustomers(searchCustomer);
	}

}
