package com.anuja.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anuja.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new
				AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean
		AccountDAO bean = context.getBean(AccountDAO.class);
		
		//call business method
		List<Account> accounts = null;
		try {
			accounts = bean.findAccounts(true);
		}
		catch (Exception e) {
			System.out.println("\n\n Main Program caught exception - " + e);
		}		
		System.out.println("\n\n Main program : After Throwing demo");
		System.out.println("~~~~~~~~~~~~~~~~");
		
		System.out.println(accounts);
		
		//close context
		context.close();
	}

}
