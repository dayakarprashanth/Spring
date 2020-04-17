package com.example.aopdemo;



import java.util.ArrayList;
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
		Account temp1 = new Account();
		temp1.setLevel("silver");
		temp1.setName("raj");
		theAccountDAO.addAccount(temp1);
		
		
		theAccountDAO.deleteAccount();
		
		//close context
		context.close();
	}

}
