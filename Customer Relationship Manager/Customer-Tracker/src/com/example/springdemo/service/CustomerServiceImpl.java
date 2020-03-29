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

}
