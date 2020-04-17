package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// this is where we add related advises for logging
	
	//@Before Advise
	@Before("com.example.aopdemo.aspect.PointCutExpression.excludingGetterSetterMethods()")
	public void beforeAdviseLogging() {
		
		System.out.println("\n =========> Executing @Before Advise ========= Checking LOGGING Advise is it is FIRST");
	}
	
	
}
