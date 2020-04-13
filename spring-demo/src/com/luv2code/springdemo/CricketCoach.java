package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	

	public CricketCoach() {
		System.out.println("inside CricketCoach no-arg-constructor");
	}
	
	// setter method for fortune service; called when spring injects dependancy
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside setFortuneService setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "watch a bollywood movie";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// getter / setter 
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println("inside setEmailAddress setter method");
		this.emailAddress = emailAddress;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		System.out.println("inside setTeam setter method");
		this.team = team;
	}

}
