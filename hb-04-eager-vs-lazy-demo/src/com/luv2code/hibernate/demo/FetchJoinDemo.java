package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		// try finally block
		try {
			System.out.println("\n");
			
			// start transaction
			session.beginTransaction();
			
			// get instructor from db
			int theId = 1;
			
			// option 2: Hibernate Query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses " 
															+ "WHERE i.id=:theInstructorId",
														Instructor.class);
			
			// set parameter for query
			query.setParameter("theInstructorId",  theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			// print results
			System.out.println(">> The instructor: " + tempInstructor);
							
			// commit transaction
			session.getTransaction().commit();
			
			// close session
			session.close();
			System.out.println(">> THE SESSION HAS BEEN CLOSED!");
			
			// still have access to this as we loaded it into memory while the session was open
			
			// now when we call tempInstructor.getCourses() we are retrieving it from memory instead
			// of from our db connection
			System.out.println(">> Courses Taught: " + tempInstructor.getCourses());

			System.out.println(">> Done!");
			System.out.println("\n");

		} finally {
			// handle leak 
			session.close();
			// close factory
			factory.close();
		}
	}

}
