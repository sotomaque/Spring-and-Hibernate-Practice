package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class GetInstructorCoursesDemo {

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
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// retreive coures for instructor
			System.out.println("The instructor: " + tempInstructor);
			
			// get courses for instructor
			System.out.println("Courses Taught: " + tempInstructor.getCourses());
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			System.out.println("\n");

		} finally {
			// handle leak 
			session.close();
			// close factory
			factory.close();
		}
	}

}
