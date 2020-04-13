package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		TennisCoach myTennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		// call methods on bean
		System.out.println(myTennisCoach.getDailyWorkout());
		System.out.println(myTennisCoach.getDailyFortune());
		
		
		// close context
		context.close();
	}

}
