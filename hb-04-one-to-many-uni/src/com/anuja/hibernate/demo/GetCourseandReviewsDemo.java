package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;
import com.anuja.hibernate.demo.entity.Review;

public class GetCourseandReviewsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			Course course = new Course("Belly Dance");
			course.addReview(new Review("Great class"));
			course.addReview(new Review("Yo!"));
			course.addReview(new Review("so bad!"));
			
			System.out.println("save course and reviews");
			session.save(course);
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
