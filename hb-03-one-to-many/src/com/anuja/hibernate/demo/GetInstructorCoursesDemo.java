package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("instrunctor " + instructor );
			System.out.println("courses " + instructor.getCourses());
			
			
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
