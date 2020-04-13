package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
 
	// field injection to avoid setter or constructor injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	// default constructor to print out details
	public TennisCoach() {
		System.out.println(">> TennisCoach: Inside default Constructor");
	}
	
	// custom init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside doMyStartupStuff");
	}
	// custom destory method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside doMyCleanupStuff");
	}
	
	// with this annotation, spring will scan components, looking for one that implements
	// FotuneService, initialize it, and inject it as a dependency for TennisCoach
	
	// this is a constructor injection
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
	
	
	// this is a setter injection
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: Inside setFortuneService() method");
//		fortuneService = theFortuneService;
//	}
	
	// we can inject dependencies to any method, not just setters
//	@Autowired
//	public void doCrazyStuff(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: Inside doCrazyStuff() method");
//		fortuneService = theFortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice backhand volley";
	}
	
	// here we will call the getDailyFortune of out dependency
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
}
