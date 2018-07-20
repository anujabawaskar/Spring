package com.anuja.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLog {

	@Before("com.anuja.aopdemo.aspect.AOPExpressions.exceptGetterSetter()")
	public void logToCloud() {
		System.out.println("Logging to cloud~~~~~~~~~~~~~~");
	}
}
