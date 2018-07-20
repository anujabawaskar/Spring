package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating new student...");
			Student student = new Student("Anuja", "Lakhe", "email");
			session.beginTransaction();
			System.out.println("saving student");
			session.save(student);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
				
	}

}
