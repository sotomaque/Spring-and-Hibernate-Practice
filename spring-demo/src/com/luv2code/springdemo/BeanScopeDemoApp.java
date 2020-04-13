package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on bean
		boolean result = (theCoach == alphaCoach);
		
		// print results
		System.out.println("Pointing to the same object: " + result);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		// close application context
		context.close();

	}

}
