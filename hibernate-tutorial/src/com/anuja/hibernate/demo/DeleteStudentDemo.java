package com.anuja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuja.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//Student temp = session.get(Student.class, 1);
			//session.delete(temp);
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			System.out.println("done");
			
		}
		finally {
			factory.close();
		}
				
	}

}
