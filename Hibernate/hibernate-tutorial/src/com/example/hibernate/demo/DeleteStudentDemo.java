package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure().
								addAnnotatedClass(Student.class).
								buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("delete from Student s where s.firstName='Scooby'").executeUpdate();
					
			session.getTransaction().commit();
			
	}
		finally {
			factory.close();
		}
	}
}
