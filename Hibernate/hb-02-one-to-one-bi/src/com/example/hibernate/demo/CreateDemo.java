package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;


public class CreateDemo {

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
			//create the objects
			Instructor tempInstructor = new Instructor(1,"Raj","Prashanth","raj@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://raj/youtube","Coding");
			
			Instructor tempInstructor1 = new Instructor("Hari","Krishnan","hari@gmail.com");
			
			InstructorDetail tempInstructorDetail1 = new InstructorDetail("http://hari/youtube","Gaming");
			
			//associate the objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);
			//start transaction
			session.beginTransaction();
			
			//save the instructor
			//Note: this will ALSO save the details object
			//because of CascadeType.ALL
			session.save(tempInstructor);
			session.save(tempInstructor1);
			
			////session.createQuery("update Instructor i set i.instructorDetail=1 WHERE i.firstName='Raj'").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
	}
		finally {
			factory.close();
		}
	}
}
