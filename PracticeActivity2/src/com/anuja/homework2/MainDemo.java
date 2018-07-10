package com.anuja.homework2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach bean = context.getBean("football", Coach.class);
		System.out.println(bean.getDailyWorkout());
		System.out.println(bean.getDailyFortune());
	}

}
