package com.example.springdemo.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.springdemo.entity.Customer;



@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query ... sort by last name
		
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName",
											Customer.class);
		
		// execute query and get result list
		
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		return customers;
		
	}


	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		//since we need to perform insert for new customer and 
		//update for existing customer we would like to make use of new method
		/* currentSession.save(theCustomer); */
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrive/read from database using the Primary Key
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


}
