package com.anuja.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.anuja.hibernate.demo.entity.Course;
import com.anuja.hibernate.demo.entity.Instructor;
import com.anuja.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+ "where i.id=:theInstructorId", Instructor.class );
			
			query.setParameter("theInstructorId", 1);
			Instructor instructor = query.getSingleResult();
			
			System.out.println("---------: " + instructor);
			session.getTransaction().commit();
			
			session.close();
			System.out.println("courses " + instructor.getCourses());

			System.out.println("done-----------------");
		}
		finally {
			session.close();
			factory.close();
		}
				
	}

}
