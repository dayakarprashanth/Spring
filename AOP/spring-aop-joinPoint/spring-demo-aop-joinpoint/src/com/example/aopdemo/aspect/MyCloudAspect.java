package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudAspect {
	
	@Before("com.example.aopdemo.aspect.PointCutExpression.excludingGetterSetterMethods()")
	public void cloudAdvise()
	{
		System.out.println("\\n =========> Executing @Before Advise ========= Checking Cloud Advise is it is THIRD");
	}

}
