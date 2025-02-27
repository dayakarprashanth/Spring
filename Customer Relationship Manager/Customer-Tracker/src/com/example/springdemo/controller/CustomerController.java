package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject Customer Service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel)
	{
		
		//get the customer to the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create a model to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam ("customerId") int theId,Model theModel)
	{
		//get the customers from the database [get from the service]
		Customer theCustomer = customerService.getCustomer(theId);
		
		
		//set customer as a model attribute to pre-popolutate the form
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model theModel)
	{
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		//set customer as a model attribute
		
		
		return "redirect:/customer/list";
	}
	
}
