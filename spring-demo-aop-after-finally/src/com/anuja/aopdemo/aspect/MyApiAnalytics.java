package com.anuja.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalytics {
	
	@Before("com.anuja.aopdemo.aspect.AOPExpressions.exceptGetterSetter()")
	public void performAPIAnalytic() {
		System.out.println("Doing some analytics~~~~~~~~~~~~~~");
	}
	
}
