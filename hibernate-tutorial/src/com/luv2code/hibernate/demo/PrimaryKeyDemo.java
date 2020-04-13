package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
		
			// Create 3 Student Objs
			System.out.println(">> Creating 3 new Student Obj's");
			Student tempStudent1 = new Student("Pall", "Wall", "pw@gmail.com");
			Student tempStudent2 = new Student("John", "Doe", "john@gmail.com");
			Student tempStudent3 = new Student("Jane", "Apple", "jane@gmail.com");
			
			// begin transaction
			session.beginTransaction();
			
			// save student obj
			System.out.println(">> Saving the Students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(">> Done!");
			
		} finally {
			// close factory
			factory.close();
		}
	}

}
