package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retreive bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// preform check
		boolean result = (theCoach == alphaCoach);
		System.out.println("pointing to the same object?: " + result);
		System.out.println("Memory location for obj1: " + theCoach);
		System.out.println("Memory location for obj2: " + alphaCoach);
		
		// close context
		context.close();
	}

}
