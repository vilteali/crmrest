package com.ali.crmrest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.crmrest.entity.Customer;
import com.ali.crmrest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class RestCustomer {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// set id to 0 because in hibernate method 'saveOrUpdate' != 0 then it'll update
//		customer.setId(0);
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
}
