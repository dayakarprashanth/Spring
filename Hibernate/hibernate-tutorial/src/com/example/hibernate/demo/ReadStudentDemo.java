package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure().
								addAnnotatedClass(Student.class).
								buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			//////// use the session object to save java object
			//create a student object 
			Student s = new Student("Daffy", "Duck", "daffy@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			// save the student object 
			session.save(s);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// code to retrive the object
			System.out.println("Saved student. Generated id " + s.getId());
			
			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrive the student based on id.primary key
			System.out.println("\n Saved student. Generated id " + s.getId());
			
			Student myStudent = session.get(Student.class, s.getId());
			System.out.println("Get complete: " + myStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
	}
		finally {
			factory.close();
		}
	}
}
