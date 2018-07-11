package com.anuja.homework5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach bean = context.getBean("coachImpl", Coach.class);
		System.out.println(bean.getCalorie());
		System.out.println(bean.getFortune());
		context.close();
	}

}
