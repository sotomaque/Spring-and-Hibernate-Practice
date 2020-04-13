package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp2 {

	public static void main(String[] args) {
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach mySwimCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call methods on bean
		System.out.println(mySwimCoach.getDailyWorkout());
		System.out.println(mySwimCoach.getDailyFortune());
		
		System.out.println(mySwimCoach.getEmail());
		System.out.println(mySwimCoach.getTeam());
		
		// close context
		context.close();
	}

}
