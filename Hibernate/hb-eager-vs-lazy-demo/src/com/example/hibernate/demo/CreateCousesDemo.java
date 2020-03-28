package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;



public class CreateCousesDemo {

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
			int intId=2;
			Instructor tempInstructor = session.get(Instructor.class, intId);
			System.out.println("The instructor is = " + tempInstructor.getFirstName());
			
			//create some courses
			
			Course tempCourse = new Course("Biology");
			Course tempCourse1 = new Course("zoology");
			Course tempCourse2 = new Course("Botany");
			
			//add courses to instructor
			
			tempInstructor.add(tempCourse);
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//save the courses
			
			session.save(tempCourse);
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit the transaction 
			session.getTransaction().commit();
	}
		finally {
			
			session.close();
			factory.close();
		}
	}
}
