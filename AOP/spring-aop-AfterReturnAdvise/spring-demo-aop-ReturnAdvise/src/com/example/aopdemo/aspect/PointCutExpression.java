package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExpression {

	//point cut declaration
		
		@Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
		public void forDAOpackage() {}
		
		@Pointcut("execution(* com.example.aopdemo.dao.AccountDAO.set*())")
		public void setterDAOMethods() {}
		
		@Pointcut("execution(* com.example.aopdemo.dao.AccountDAO.get*())")
		public void getterDAOMethods() {}
		
		@Pointcut("forDAOpackage() && !(getterDAOMethods() || setterDAOMethods())")
		public void excludingGetterSetterMethods() {}
	
}
