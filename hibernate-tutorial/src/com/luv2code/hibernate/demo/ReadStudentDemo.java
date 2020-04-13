package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		// try finally block
		try {
		
			// Create Student Obj
			System.out.println(">> Creating new Student Obj");
			Student tempStudent = new Student("Daffy", "Duck", "duck@gmail.com");
			
			// begin transaction
			session.beginTransaction();
			
			// save student obj
			System.out.println(">> Saving the Student Obj");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find primary key set by hibernate (auto-increment key)
			System.out.println("Saved student. Generated ID: " + tempStudent.getId());
			
			// get a new session
			session = factory.getCurrentSession();
			
			// start a transaction
			session.beginTransaction();
			
			// retrieve student based on id: primary key
			System.out.println("\nGetting student wiht id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get Complete: " + myStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(">> Done!");
			
		} finally {
			// close factory
			factory.close();
		}
	}

}
