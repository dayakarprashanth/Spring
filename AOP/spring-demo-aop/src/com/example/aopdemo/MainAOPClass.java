package com.example.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.aopdemo.dao.AccountDAO;



public class MainAOPClass {

	public static void main(String[] args) {
		
		// Spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoSpringConfig.class);
		
		// create java bean
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//bussines logic
		theAccountDAO.addAccount();
		
		//close context
		context.close();
	}

}
