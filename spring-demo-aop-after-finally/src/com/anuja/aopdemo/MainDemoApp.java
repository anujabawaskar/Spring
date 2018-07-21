package com.anuja.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anuja.aopdemo.dao.AccountDAO;
import com.anuja.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		AccountDAO bean = context.getBean(AccountDAO.class);
		
		//call business method
		Account acc = new Account();
		acc.setLevel("gold");
		acc.setName("Shreyas");
		bean.addAccount(acc, true);
		bean.doWork();
		
		bean.setName("anuja");
		bean.setServiceCode("silver");
		
		bean.getServiceCode();
		bean.getName();
		
		
		MembershipDAO bean2 = context.getBean(MembershipDAO.class);
		
		bean2.addAccount();
		bean2.gosleep();

		//close context
		context.close();
	}

}
