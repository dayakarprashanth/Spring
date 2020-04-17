package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyAPIAspect {

	@Before("com.example.aopdemo.aspect.PointCutExpression.excludingGetterSetterMethods()")
	public void apiAspectAdvise()
	{
		System.out.println("\n ==> Executing @Before Advise ===========  Checking API Advise if it is Second");
	
	}
}
