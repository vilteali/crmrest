package com.ali.crmrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ali.crmrest.entity.Customer;
import com.ali.crmrest.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		List<Customer> theCustomers = customerService.getCustomers();
		model.addAttribute("customers", theCustomers);
		
		return "listCustomers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer theCustomer = new Customer();
		model.addAttribute("customer", theCustomer);
		
		return "addCustomerForm";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("customerId") Integer id) {
		
		Customer theCustomer = customerService.getCustomer(id);
		model.addAttribute("customer", theCustomer);
		
		return "addCustomerForm";
	}
	
	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("customerId") Integer id) {
		
		customerService.deleteCustomer(id);
		return "redirect:/list";
		
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomers(Model model, @RequestParam("searchCustomer") 
									String searchCustomer) {
		
		List<Customer> theCustomer = customerService.searchCustomer(searchCustomer);
		model.addAttribute("customers", theCustomer);
		
		return "listCustomers";
		
	}
	
}
