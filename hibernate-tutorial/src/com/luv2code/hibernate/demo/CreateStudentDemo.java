package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Enrique", "Sotomayor", "sotomaque@gmail.com");
			
			// begin transaction
			session.beginTransaction();
			
			// save student obj
			System.out.println(">> Saving the Student Obj");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(">> Done!");
			
		} finally {
			// close factory
			factory.close();
		}
	}

}
