package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {

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
			
			// get instructor by PK (id)
			int idToDelete = 2;
			Instructor tempInstructor = session.get(Instructor.class, idToDelete);
			
			System.out.println("FOUND INSTRUCTOR: " + tempInstructor);
			
			// delete instructor		
			if (tempInstructor != null) {
				System.out.println("DELETING: " + tempInstructor);
				//
				// NOTE: this will also delete "details" object because of CASCADEType.ALL
				//
				session.delete(tempInstructor);
				
				// commit transaction
				session.getTransaction().commit();
				System.out.println("DONE");
			} else {
				System.out.println("INSTRUCTOR NOT FOUND");
			}
			
			
			
		} finally {
			// close factory
			factory.close();
		}
	}

}
