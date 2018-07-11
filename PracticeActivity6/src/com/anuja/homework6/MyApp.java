package com.anuja.homework6;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach bean = context.getBean("coachImpl", Coach.class);
		System.out.println(bean.getCalorie(50));
		System.out.println(bean.getFortune());
		context.close();
	}

}
