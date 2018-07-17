package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Anuja", "Bawaskar", "anuja@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("Anuja channel", "dance");
			
			Instructor instructor1 = new Instructor("Shreyas", "Lakhe", "shreyas@gmail.com");
			
			InstructorDetail detail1 = new InstructorDetail("Shreyas channel", "study");
			
			
			instructor.setInstructorDetail(detail);
			instructor1.setInstructorDetail(detail1);
			session.beginTransaction();
			System.out.println("Saving instructor and detail");
			session.save(instructor);
			session.save(instructor1);
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
				
	}

}
