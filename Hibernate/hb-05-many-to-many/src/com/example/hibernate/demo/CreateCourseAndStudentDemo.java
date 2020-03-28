package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import com.example.hibernate.demo.entity.Student;



public class CreateCourseAndStudentDemo {

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
			
			//create a Course
			Course tempCourse = new Course("Pac MAN");
			
			//save the Course
			System.out.println("Saving the Course");
			session.save(tempCourse);
			
			  System.out.println("Saved Course" + tempCourse);
			  
			  //create the Students 
			  Student tempStudent1 = new Student("Raj", "Prashanth", "prashu@gmail.com"); 
			  Student tempStudent2 = new Student("john", "Doe", "john@gmail.com");
			  
			  //add the students to the Course 
			  tempCourse.addStudent(tempStudent1);
			  tempCourse.addStudent(tempStudent2);
			  
			  //save 
			  System.out.println("Saving the Student"); 
			  session.save(tempStudent1);
			  session.save(tempStudent2); 
			  System.out.println("Saved the Students" + tempCourse.getStudents());
			  
			 
						
			// commit the transaction 
			session.getTransaction().commit();
	}
		finally {
			
			session.close();
			factory.close();
		}
	}
}
