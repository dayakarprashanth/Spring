package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;


public class GetInstructorCourseDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
						
			//start transaction
			session.beginTransaction();
			
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
						
			System.out.println("The Instructor is :" + tempInstructor);
			
			System.out.println("The Instructor is :" + tempInstructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
	}
		
		finally {
			
			session.close();
			factory.close();
		}
	}
}
