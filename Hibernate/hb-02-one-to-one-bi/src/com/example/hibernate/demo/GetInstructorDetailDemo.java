package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;


public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
						
			//start transaction
			session.beginTransaction();
			
			int theId=22;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
						
			System.out.println("The Instructor is :" + tempInstructorDetail.getInstructor());
			
			// commit the transaction
			session.getTransaction().commit();
	}
		catch (Exception exc) {
			
			exc.printStackTrace();
			
		}
		finally {
			
			session.close();
			factory.close();
		}
	}
}
