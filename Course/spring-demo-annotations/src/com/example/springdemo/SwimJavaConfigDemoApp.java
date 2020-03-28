package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach myswimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//use the methods
		System.out.println(myswimCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(myswimCoach.getDailyFortune());
		
		//call new methods
		System.out.println("Email Address: " + myswimCoach.getEmail());
		System.out.println("Team: " + myswimCoach.getTeam());
		
		//close the context
		context.close();
	}

}
