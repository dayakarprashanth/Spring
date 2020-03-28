package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import com.example.hibernate.demo.entity.Student;



public class GetCoursesForRajDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		//create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//start transaction
			session.beginTransaction();
			
			//fetch the Student
			int theId=1;
			Student tempStudent = session.get(Student.class, theId);  
			
			System.out.println("Courses are " + tempStudent.getCourses());
			
			// commit the transaction 
			session.getTransaction().commit();
	}
		finally {
			
			session.close();
			factory.close();
		}
	}
}
