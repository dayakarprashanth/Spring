package com.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from the spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theBaseballCoach = context.getBean("myBaseballCoach", Coach.class);
		//Coach theCricketCoach = context.getBean("myCricketCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theBaseballCoach.getDailyWorkout());
		
		//lets call our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theBaseballCoach.getDailyFortune());
	//	System.out.println(theCricketCoach.getDailyFortune());
		
		
		//close the context
		 context.close();
	}

}
