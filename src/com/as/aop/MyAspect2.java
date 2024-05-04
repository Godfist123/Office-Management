package com.as.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;




public class MyAspect2 {



	public void beforeTest()
	//public void before(Pointcut pointcut)//Pointcut pointcut可选 参数可以获取目标对象的信息,如类名称,方法参数,方法名称等，，该参数是可选的。
	{
		System.out.println(this.getClass().getName()+"前置增强");//前置通知

	}

	public void afterReturning() 
	{
		System.out.println(this.getClass().getName()+"后置增强");

	}
	public void afterThrowing()
	{
		System.out.println(this.getClass().getName()+"异常增强");
	}
	public void afterTest()
	{
		System.out.println(this.getClass().getName()+"最终增强");
	}
	

	public Object roundTest(ProceedingJoinPoint joinpoint) throws Throwable
	{
			System.out.println(this.getClass().getName()+"环绕增强 before");
			Object obj=joinpoint.proceed();
			//obj="就改你的值!!!!";`
			//ProceedingJoinPoint，通过该对象的proceed()方法来执行目标函数，proceed()的返回值就是环绕通知的返回值。同样的，Proc
			System.out.println(this.getClass().getName()+"环绕增强 after");
			return obj;//结果是调用方法返回结果
			//return null;
	}
}
