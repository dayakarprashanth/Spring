package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;


public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure().
								addAnnotatedClass(Student.class).
								buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			session = factory.getCurrentSession();
			//start transaction
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Object is: " + myStudent);
			
			myStudent.setFirstName("Scooby");
			
			System.out.println(myStudent.getFirstName());
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println(myStudent.getFirstName());
			
			//New Code
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Update email for int 1
			
			session.createQuery("update Student s set s.email ='scooby@gmail.com'" + " where s.firstName='Scooby'").executeUpdate();
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			
					
			
	}
		finally {
			factory.close();
		}
	}
}
