package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;


public class CreateStudentDemo {

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
			Student s = new Student("Raj", "Prashanth", "prashu@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			// save the student object 
			session.save(s);
			
			// commit the transaction
			session.getTransaction().commit();
	}
		finally {
			factory.close();
		}
	}
}
