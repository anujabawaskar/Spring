package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating new student...");
			Student student = new Student("Courage", "Dog", "emailcartoon");
			session.beginTransaction();
			System.out.println("saving student");
			session.save(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			System.out.println("id set " + student.getId());
			session.beginTransaction();
			Student student2 = session.get(Student.class, student.getId());
			System.out.println("got students " + student2.toString());
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
				
	}

}
