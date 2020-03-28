package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure().
								addAnnotatedClass(Student.class).
								buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
	
			
			//start transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			//display the students
			displayStudents(theStudents);
			
			//query student with last name Doe
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//display the students
			System.out.println("\n\n\n");
			displayStudents(theStudents);
			
			// query student with last name Doe or first name Raj
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe'" + " OR s.firstName='Raj'").getResultList();
			
			//display the students
			System.out.println("\n\n\n");
			displayStudents(theStudents);
			
			// query student with email ending @gmail.com
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			
			//display the students
			System.out.println("\n\n\n");
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
	}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
			
		}
	}
}
