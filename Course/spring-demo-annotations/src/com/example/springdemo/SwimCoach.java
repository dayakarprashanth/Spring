package com.example.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	

	@Value("${foo.team}")
	private String team;



	public SwimCoach(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Do 100 Laps.";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
