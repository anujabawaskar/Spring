package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
						
			session.beginTransaction();
			System.out.println("Saving instructor and detail");
			//session.save(instructor);
			Instructor temp = session.get(Instructor.class, 1);
			if(temp != null) {
				System.out.println("deleting instructor");
				session.delete(temp);
			}
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
				
	}

}
