package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		
		//Load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Retrieve the bean from Spring Container
		CricketCoach theCricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call the methods
		System.out.println(theCricketCoach.getDailyFortune());
		System.out.println(theCricketCoach.getDailyWorkout());
		
		//call new methods 
		System.out.println(theCricketCoach.getEmailAddress());
		System.out.println(theCricketCoach.getTeam());
		//close the context
		context.close();
	}

}
