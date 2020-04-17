package com.example.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;




public class MainAOPClass {

	public static void main(String[] args) {
		
		// Spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoSpringConfig.class);
		
		// create java bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		//bussiness logic
		List<Account> myAccounts = theAccountDAO.findAccounts();
		
		
		System.out.println("\n \n Executing the main funtions:");
		System.out.println("-------------------------------");
		System.out.println(myAccounts);
		//close context
		context.close();
	}

}
