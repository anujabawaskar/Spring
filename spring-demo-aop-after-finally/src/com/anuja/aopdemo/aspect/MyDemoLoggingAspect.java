package com.anuja.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.anuja.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@AfterReturning(pointcut="execution(* com.anuja.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="results")
	public void afterReturningFindAccountsAdvice(JoinPoint jp,
			List<Account> results) {
		String method = jp.getSignature().toShortString();
		System.out.println("ADvising @AfterReturning on : ---- " + method);
		
		System.out.println("REsult is : ---- " + results);
		
		convertAccountToUpperCase(results);
		
		//System.out.println("REsult is : ---- " + results);
	}
	
	
	private void convertAccountToUpperCase(List<Account> results) {
		for(Account result : results) {
			String upperCase = result.getName().toUpperCase();
			result.setName(upperCase);
		}
	}


	@Before("com.anuja.aopdemo.aspect.AOPExpressions.exceptGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint jp) {
		System.out.println("~~~~~~Before method~~~~~~~~");
		
		MethodSignature methodsig = (MethodSignature) jp.getSignature();
		
		System.out.println("method : " + methodsig);
		
		Object[] args = jp.getArgs();
		
		for(Object o:args) {
			System.out.println(o);
			if(o instanceof Account) {
				Account acc = (Account)o;
				System.out.println("account name " + acc.getName());
				System.out.println("level " + acc.getLevel());
			}
		}
			
	}
	
	@AfterThrowing(pointcut="execution(* com.anuja.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="excp")
	public void afterThrowingFindAccountsAdvice(JoinPoint jp,
												Throwable excp) {
		
		System.out.println("Exception thrown -- " + excp);
		
	}
	
	@After("execution(* com.anuja.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
		String method = jp.getSignature().toShortString();
		System.out.println("Executing @After on : ---- " + method);
		
		
	}
}
