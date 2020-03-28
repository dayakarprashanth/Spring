package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;


public class DeleteDemo {

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
			
			int theId=1;
			
			//identify the instructor to delete
			Instructor tempInstructor = session.get(Instructor.class,theId);
			
			// delete the instructor
			
			if(tempInstructor != null) {
				
				session.delete(tempInstructor);
			}
			
			
			// commit the transaction
			session.getTransaction().commit();
	}
		finally {
			factory.close();
		}
	}
}
