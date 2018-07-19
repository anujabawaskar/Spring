package com.anuja.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;
import com.anuja.hibernate.demo.entity.Review;
import com.anuja.hibernate.demo.entity.Student;

public class CreateCourseandStudentsDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Course course = new Course("Pacman");
			System.out.println("saving course");
			session.save(course);
			
			Student s1 = new Student("Shreyas", "Lakhe", "email1");
			Student s2 = new Student("Anuja", "Bawaskar", "email2");
			
			course.addStudent(s1);
			course.addStudent(s2);
			
			session.save(s1);
			session.save(s2);
			
			
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
