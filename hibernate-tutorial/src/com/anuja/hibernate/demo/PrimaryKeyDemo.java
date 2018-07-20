package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating 3 new student...");
			Student student1 = new Student("Shreyas", "Lakhe", "email1");
			Student student2 = new Student("Esha", "Bawaskar", "email2");
			Student student3 = new Student("Neil", "Bawaskar", "email3");
			session.beginTransaction();
			System.out.println("saving student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
				
	}

}
