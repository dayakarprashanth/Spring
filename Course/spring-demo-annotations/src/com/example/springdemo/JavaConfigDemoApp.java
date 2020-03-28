package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach mySwimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		//use the methods
		System.out.println(mySwimCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(mySwimCoach.getDailyFortune());
		
		//call the values
		
		System.out.println(mySwimCoach.getTeam());
		System.out.println(mySwimCoach.getEmail());
		//close the context
		context.close();
	}

}
