package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
	}
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// custom init / destory methods
	public void doMyStartupStuff() {
		System.out.println("Track Coach: inside method doMyStartupStuff\n");
	}
	
	public void doMyCleanupStuff() {
		System.out.println("\nTrack Coach: inside method doMyCleanupStuff");
	}

}
