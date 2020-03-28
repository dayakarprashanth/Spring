package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService") 
	private FortuneService fortuneService;


	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	} */
	
	public TennisCoach() {
		
	}


	@Override
	public String getDailyWorkout() {
		
		return "Practise your backhand volley";
	}


	@Override
	public String getDailyFortune() {

		return  fortuneService.getFortune();
	}


	public FortuneService getFortuneService() {
		return fortuneService;
	}
/*
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		
	} */

}
