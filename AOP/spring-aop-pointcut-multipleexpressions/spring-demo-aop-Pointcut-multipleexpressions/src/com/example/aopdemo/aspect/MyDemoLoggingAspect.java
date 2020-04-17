package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add related advises for logging
	
	//point cut declaration
	@Pointcut("execution(* com.example.aopdemo.dao.*.*())")
	private void forDAOpackage() {}

	//@Before Advise
	@Before("forDAOpackage()")
	public void beforeAdviseLogging() {
		
		System.out.println("\n =========> Executing @Before Advise ========= JUST LOGGING");
	}
	
	@Before("forDAOpackage()")
	public void beforeAdviseSecurityCheck() {
		
		System.out.println("\n ==> Executing @Before Advise ===========  Passing Security Check");
	}
}
