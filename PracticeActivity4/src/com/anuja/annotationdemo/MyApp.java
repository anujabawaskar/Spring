package com.anuja.annotationdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach bean = context.getBean("info", Coach.class);
		System.out.println(bean.nextWorkingDay());
		context.close();
	}
}
