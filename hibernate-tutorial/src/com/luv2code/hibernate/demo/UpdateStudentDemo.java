package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
		
			// begin transaction
			session.beginTransaction();
			
			// update student with student id = 2
			int studentId = 2;
			Student myStudent = session.get(Student.class, studentId);
			
			myStudent.setEmail("paul.wall@gmail.com");
			
			// commit the transaction
			session.getTransaction().commit();
			
			
		} finally {
			// close factory
			factory.close();
		}
	}



}
