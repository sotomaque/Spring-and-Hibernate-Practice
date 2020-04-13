package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateCoursesDemo {

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
			
			// create courses
			System.out.println(">> Creating courses");
			Course tempCourse1 = new Course("ECON 323 - Microeconomic Theory");
			Course tempCourse2 = new Course("ECON 411 - Game Theory");
			System.out.println(">> Courses Created: " + tempCourse1 + " " + tempCourse2);
			
			// add courses to instructors list of courses taught
			System.out.println(">> Using convenience method to associate courses with Instructor");
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// save courses
			System.out.println(">> Saving courses");
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			System.out.println(">> Committing Transaction");
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
