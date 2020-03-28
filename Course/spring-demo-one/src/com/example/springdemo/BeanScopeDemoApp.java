package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		
		//if they are the same 
		boolean result = (theCoach == alphaCoach);
		
		//To print out the result
		System.out.println("\n Pointing to the same object: " + result);
		
		System.out.println("\n Memory location for theCoach: " + theCoach);
		
		System.out.println("\n Memory location for theCoach: " + alphaCoach);
		
		context.close();
	}

}
