package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


// ENSURE THAT WHEN WE DELETE A COURSE WE 
// DO NOT DELETE THE ASSOCIATED INSTRUCTOR
public class DeleteCourseDemo {

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
			
			// get course from db
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// delete course
			System.out.println(">> DELETING COURSE: " + tempCourse);
			session.delete(tempCourse);
			
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
