package com.anuja.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;
import com.anuja.hibernate.demo.entity.Review;
import com.anuja.hibernate.demo.entity.Student;

public class AddCoursesforShreyasDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Student temp = session.get(Student.class, 2);
			
			System.out.println("loaded student " + temp);
			System.out.println("course : " + temp.getCourses());
			
			Course c1 = new Course("Rubik's Cube");
			Course c2 = new Course("Atari 2600");
			
			c1.addStudent(temp);
			c2.addStudent(temp);
			
			session.save(c1);
			session.save(c2);
			
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
