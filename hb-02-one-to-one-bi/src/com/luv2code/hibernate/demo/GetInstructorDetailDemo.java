package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

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
			
			// start a transaction
			session.beginTransaction();
			
			// get instructor detail object
			int theId = 24324;
			InstructorDetail tempDetail = session.get(InstructorDetail.class, theId);
			
			// print inst. detail
			System.out.println("\n");
			System.out.println(">> tempInstructorDetail: " + tempDetail);
			
			// print associated instructor (using getter method we generated)
			System.out.println(">> associated instructor: " + tempDetail.getInstructor());
			System.out.println("\n");
			
			// commit transaction
			session.getTransaction().commit();

		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			// handle connection leak issue when "theId" references non-existing obj
			session.close();
			
			// close factory
			factory.close();
		}
	}

}
