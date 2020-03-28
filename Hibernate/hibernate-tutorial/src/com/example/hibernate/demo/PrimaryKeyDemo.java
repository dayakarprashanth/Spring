package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;



public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			//////// use the session object to save java object
			//create a student object 
			Student s1 = new Student("Raj", "Prashanth", "prashu@gmail.com");
			Student s2 = new Student("John", "Doe", "john@gmail.com");
			Student s3 = new Student("Mary", "Public", "mary@gmail.com");
			
			//start transaction
			session.beginTransaction();
			
			// save the student object 
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			// commit the transaction
			session.getTransaction().commit();
	}
		finally {
			factory.close();
		}
	}

}
