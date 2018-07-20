package com.anuja.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").list();
			
			display(students);
			
			students = session.createQuery("from Student s where s.lastName='Dog'").getResultList();
			
			display(students);
			session.getTransaction().commit();
			System.out.println("done");
		}
		finally {
			factory.close();
		}
				
	}

	private static void display(List<Student> students) {
		for(Student student:students) {
			System.out.println(student.toString());
		}
	}

}
