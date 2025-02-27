package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject Customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}


	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
		
	}

	@Transactional
	@Override
	public Customer getCustomer(int theId) {
		//delegate the call to DAO
		return customerDAO.getCustomer(theId);
		
	}

	@Transactional
	@Override
	public void deleteCustomer(int theId) {
		//delegate call to DAO
		customerDAO.deleteCustomer(theId);
		
	}

}
