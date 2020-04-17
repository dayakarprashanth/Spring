package com.example.aopdemo.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// this is where we add related advises for logging
	
	//@After Retrun Advise
	@AfterReturning(pointcut = ("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))"),
				returning = "result")
	public void afterReturningAdvise(JoinPoint theJoinPoint, List<Account> result)
	{
		System.out.println("\n===========> @AfterReturning Advise");
		
		System.out.println("Running in After Return Advise" + result);
		
		for(Account tempAccounts : result)
		{
			//chnage Account name to UpperCase
			String theUpperName = tempAccounts.getName().toUpperCase();
			//Update in result
			tempAccounts.setName(theUpperName);
		}
		
		System.out.println("After converting " + result);
		
	}
	
	
	
	//@Before Advise
	@Before("com.example.aopdemo.aspect.PointCutExpression.excludingGetterSetterMethods()")
	public void beforeAdviseLogging(JoinPoint theJoinPoint) {
		
		System.out.println("\n =========> Executing @Before Advise ========= Checking LOGGING Advise is it is FIRST");
		
		MethodSignature mySigMethod = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " +mySigMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgs : args)
		{
			System.out.println("Arguments: " + tempArgs);
		
			if(tempArgs instanceof Account)
			{
				Account theAccount = (Account)tempArgs;
				
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Level: " + theAccount.getLevel());
			}
		}
		
	}
	
}
