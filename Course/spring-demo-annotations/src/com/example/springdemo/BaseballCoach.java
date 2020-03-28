package com.example.springdemo;


import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;




// @Scope("singleton")
public class BaseballCoach implements Coach {
	
@Autowired 
@Qualifier("randomFortuneService")
private FortuneService fortuneService;
	
    //default constructor
	public BaseballCoach() 
	{
		System.out.println("Baseball: Default constructor");
	}
	
	//define my init method

	public void doMyStartUpStuff() {
		System.out.println("Inside of doMyStartUpStuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("Inside of doMyCleanUpStuff");
		
	}
	/*
	//define a setter methods
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside the setter method");
		this.fortuneService = fortuneService;
	}
	*/

	/*
	//define a new method to test autowired on this
	@Autowired
	public void newMethod(FortuneService fortuneService)
	{
		System.out.println("Inside a new method we just created");
		this.fortuneService=fortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		return "Practise Baseball and hit 1 home run";
	}

	@Override
	public String getDailyFortune() {
	
		return fortuneService.getFortune();
	}

}

