package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			System.out.println("\n");
			System.out.println(">>All students:");
			// display students
			displayStudents(theStudents);
			System.out.println("\n");
			
			// students: lastname=Doe or firstName=Daffy
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			System.out.println(">>Students with lastname=Doe or firstName=Daffy");
			displayStudents(theStudents);
			System.out.println("\n");
			
			// like predicate
			theStudents = session.createQuery("from Student s where s.email LIKE 'sotomaque@%'").getResultList();
			System.out.println(">>Students with my email");
			displayStudents(theStudents);
			System.out.println("\n");
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println(">> Done!");
			
		} finally {
			// close factory
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
