package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;



public class FetchJoinDemo {

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
			
			//Option 2: Hibernate Query with HQL
			
			// get instructor from DB
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i " 
															+ "JOIN FETCH i.courses "
															+"WHERE i.id=:theInstructorId",
															Instructor.class);
			
			//set parameter on query
			
			query.setParameter("theInstructorId", theId);
			
			// execute the Query and get instructor
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("The instructor is: " + tempInstructor);
			
			
			// commit the transaction 
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			//Using Option two, even though it is lazy loaded it should print
		
			
			System.out.println("Latest:  The courses are=" + tempInstructor.getCourses());
	}
		
		finally {
			
			
			session.close();
			factory.close();
		}
	}
}
