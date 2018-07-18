package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
						
			session.beginTransaction();
			
			//get instructor detail object
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
			//print it
			System.out.println(instructorDetail.toString());
			
			//get associated instructor
			System.out.println(instructorDetail.getInstructor().toString());
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
