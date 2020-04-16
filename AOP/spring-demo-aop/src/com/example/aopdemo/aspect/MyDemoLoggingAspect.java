package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add related advises for logging
	
	//@Before Advise
	@Before("execution(public void com.example.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvise() {
		
		System.out.println("\n =========> Executing @Before Advise");
	}
}
