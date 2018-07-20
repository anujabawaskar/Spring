package com.anuja.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
	@Pointcut("execution(* com.anuja.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.anuja.aopdemo.dao.*.set*(..))")
	public void setters() {}
	
	@Pointcut("execution(* com.anuja.aopdemo.dao.*.get*(..))")
	public void getters() {}
	
	@Pointcut("forDaoPackage() && !(setters() || getters())")
	public void exceptGetterSetter() {}
}
