package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {

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
			// create instructor
			Instructor tempInstructor = new Instructor("Daniel", "Dean", "dean@utexas.ed");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/d_dean", "Macro");
			
			// associate objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// start transaction
			session.beginTransaction();
			
			// save transaction
			System.out.println("SAVING INSTRUCTOR: " + tempInstructor);
			session.save(tempInstructor);
			
			
			// save instructor
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
