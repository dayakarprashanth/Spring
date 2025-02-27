package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;



public class EagerLazyDemo {

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
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Latest:  The Instructor is :" + tempInstructor);
		
			System.out.println("Latest:  The courses are=" + tempInstructor.getCourses());
		
		
			
			// commit the transaction 
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			//since courses are lazy loaded so this should fail
			//to overcome the issue Option 1: Call the getter method before closing the session, like in line 41
			
			System.out.println("Latest:  The courses are=" + tempInstructor.getCourses());
	}
		
		finally {
			
			
			session.close();
			factory.close();
		}
	}
}
