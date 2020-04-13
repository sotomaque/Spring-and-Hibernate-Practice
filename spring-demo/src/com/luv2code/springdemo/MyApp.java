package com.luv2code.springdemo;

public class MyApp {
	
	public static void main(String[] args) {
		
		// create the obj
//		Coach theCoach = new BaseballCoach();
		Coach secondCoach = new TrackCoach();
//		Coach thirdCoach = new SoccerCoach();
//		
//		// use the obj
//		System.out.println(theCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyWorkout());
	}

}
