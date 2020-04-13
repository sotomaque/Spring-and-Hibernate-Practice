package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		// try finally block
		try {
		
			// create the objects
			Instructor tempInstructor = new Instructor("Enrique", "Sotomayor", "enrique@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.sotomaque.github.io/personal", "coding");
			
			// associate the objects together
			tempInstructor.setInstructorDetail(tempInstructorDetail);			
			
			// start a transaction
			session.beginTransaction();
			
			// save transaction
			//
			// NOTE: this will also save details object because of CASCADEType.ALL
			//
			System.out.println("SAVING INSTRUCTOR: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
		} finally {
			// close factory
			factory.close();
		}
	}

}
