package com.ali.crmrest.rest.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ali.crmrest.entity.Customer;
import com.ali.crmrest.service.CustomerService;

@Service
public class CustomerServiceManager implements CustomerService {
	
	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public CustomerServiceManager(RestTemplate restTemplate, @Value("{crm.rest.url})") String crmRestUrl) {
			this.restTemplate = restTemplate;
			this.crmRestUrl = crmRestUrl;
			
			logger.info("Loaded property: crm.rest.url="+crmRestUrl);
	}

	@Override
	public List<Customer> getCustomers() {
		
		logger.info("in getCustomers(): Calling REST API "+crmRestUrl);
		
		// REST call
		ResponseEntity<List<Customer>> responseEntity = 
			restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
		
		List<Customer> customers = responseEntity.getBody();
		logger.info("in getCustomers(): customers "+customers);
			
		return customers;
	}

	@Override
	public Customer getCustomer(Integer id) {
		
		logger.info("in getCustomer(): Calling REST API"+crmRestUrl);
		
		Customer customer = restTemplate.getForObject(crmRestUrl+ "/"+ id, Customer.class);
		logger.info("in saveCustomer(): customer= "+customer);
		
		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		logger.info("in saveCustomer(): Calling REST API "+crmRestUrl);
		
		int customerId = theCustomer.getId();
		
		if(customerId == 0) {
			restTemplate.postForEntity(crmRestUrl, theCustomer, String.class);
				restTemplate.put(crmRestUrl, theCustomer);
		}
			
		logger.info("in saveCustomer(): success");
	}
		

	@Override
	public void deleteCustomer(Integer id) {
		
		logger.info("in deleteCustomer(): Calling REST API "+crmRestUrl);
		
		restTemplate.delete(crmRestUrl+"/"+id);
		logger.info("ind deleteCustomer(): deleted customer id= "+id);
	}

	@Override
	public List<Customer> searchCustomer(String searchCustomer) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
