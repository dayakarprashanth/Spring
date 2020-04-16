package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.SavingsAccount;



public class MainAOPClass {

	public static void main(String[] args) {
		
		// Spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoSpringConfig.class);
		
		// create java bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//new java bean
		SavingsAccount theSavingsAccount = context.getBean("savingsAccount", SavingsAccount.class);
		
		//bussines logic
		theAccountDAO.addAccount();
		
		theAccountDAO.deleteAccount();
		
		//for savings account 
		theSavingsAccount.addAccount();
		
		
		//close context
		context.close();
	}

}
