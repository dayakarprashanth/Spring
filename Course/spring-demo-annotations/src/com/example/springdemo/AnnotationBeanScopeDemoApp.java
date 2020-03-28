package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
	
	//load the spring config file
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	//Retrieve the Bean
	Coach theCoach = context.getBean("baseballCoach",Coach.class);
	Coach alphaCoach = context.getBean("baseballCoach",Coach.class);
	
	// check if they are the same 
	boolean result = (theCoach==alphaCoach);
	
	//print out the results
	System.out.println("\n Pointing the same object: " + result);
	System.out.println("\n Memry location of the Coach object: " + theCoach);
	System.out.println("\n Memry location of the alphaCoach object: " + alphaCoach);
	
	//close the context
	context.close();
	}

}
