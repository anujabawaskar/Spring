package com.anuja.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			//Course course = session.get(Course.class, 10);
			//System.out.println("deleting course " + course);
			//session.delete(course);
			session.getTransaction().commit();
			System.out.println("done");
		}
		catch(Exception e) {
			System.out.println(e);	
		}
			
		finally {
			session.close();
			factory.close();
		}
				
	}

}
