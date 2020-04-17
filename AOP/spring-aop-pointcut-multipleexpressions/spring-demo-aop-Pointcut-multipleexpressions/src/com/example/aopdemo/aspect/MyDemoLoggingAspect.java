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
	
	@Pointcut("execution(* com.example.aopdemo.dao.AccountDAO.set*())")
	private void setterDAOMethods() {}
	
	@Pointcut("execution(* com.example.aopdemo.dao.AccountDAO.get*())")
	private void getterDAOMethods() {}
	
	@Pointcut("forDAOpackage() && !(getterDAOMethods() || setterDAOMethods())")
	private void excludingGetterSetterMethods() {}
	
	
	//@Before Advise
	@Before("excludingGetterSetterMethods()")
	public void beforeAdviseLogging() {
		
		System.out.println("\n =========> Executing @Before Advise ========= JUST LOGGING");
	}
	
	@Before("excludingGetterSetterMethods()")
	public void beforeAdviseSecurityCheck() {
		
		System.out.println("\n ==> Executing @Before Advise ===========  Passing Security Check");
	}
}
