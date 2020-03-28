package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;



public class DeleteCousesDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
		
			//start transaction
			session.beginTransaction();
			
			// get instructor from DB
			int intId = 10;
			Course tempCourse = session.get(Course.class, intId);
			
			session.delete(tempCourse);
		
			// commit the transaction 
			session.getTransaction().commit();
	}
		finally {
			
			session.close();
			factory.close();
		}
	}
}
