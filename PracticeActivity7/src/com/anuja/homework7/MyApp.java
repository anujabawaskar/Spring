package com.anuja.homework7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(JavaConfig.class);
		Coach bean = context.getBean("coach", Coach.class);
		System.out.println(bean.getHoliday());
		System.out.println(bean.predict());
		context.close();
	}

}
