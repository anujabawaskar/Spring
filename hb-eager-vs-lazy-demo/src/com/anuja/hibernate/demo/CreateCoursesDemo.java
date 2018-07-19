package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, 1);
			Course course1 = new Course("Zumba");
			Course course2 = new Course("psychology");
			
			instructor.add(course1);
			instructor.add(course2);
			
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
