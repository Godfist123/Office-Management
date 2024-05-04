package com.as.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


//定义切面的注解
@Aspect
//定义Bean的注解
@Component
public class MyAspect1 {

	//切入点表达式
	//匹配的写法
	//使用execution()定义切点表达式，即指明该通知要应用的目标函数，
	//表示有公有的方法        任意返回值  该包下的所有类   所有方法    任意参数
	//@Before("execution(public * com.as.service.*.*(..))")
	
	//@Pointcut("execution(public * com.as.service.*.*(..))")
	//private void mypointcut() {}
	
	//@Before(value="mypointcut()")
	@Before("execution(* com.as.service.*.*(..))")
	public void beforeTest()
	//public void before(Pointcut pointcut)//Pointcut pointcut可选 参数可以获取目标对象的信息,如类名称,方法参数,方法名称等，，该参数是可选的。
	{
		System.out.println(this.getClass().getName()+"前置增强");//前置通知
//		System.out.println("参数名:"+pointcut.argNames());
//		System.out.println("类名:"+pointcut.getClass());
//		System.out.println("方法名:"+pointcut.value());
	}
	@AfterReturning("execution(public * com.as.service.*.*(..))")
	public void afterReturning() 
	{
		System.out.println(this.getClass().getName()+"后置增强");
	    //throw new RuntimeException("出错了");
	}
	
	@AfterThrowing("execution(public * com.as.service.*.*(..))")
	public void afterThrowing() 
	{
		System.out.println(this.getClass().getName()+"异常增强");
	    throw new RuntimeException("出错了");
	}
	
	
	@After("execution(public * com.as.service.*.*(..))")
	public void afterTest()
	{
		System.out.println(this.getClass().getName()+"最终增强");
	}
	
	@Around("execution(public * com.as.service.*.*(..))")
	public Object roundTest(ProceedingJoinPoint joinpoint) throws Throwable
	{
			System.out.println(this.getClass().getName()+"环绕增强 before");
			Object obj=joinpoint.proceed();
			//ProceedingJoinPoint，通过该对象的proceed()方法来执行目标函数，proceed()的返回值就是环绕通知的返回值。同样的，Proc
			System.out.println(this.getClass().getName()+"环绕增强 after");
			return obj;//结果是调用方法返回结果
			//return null;
	}
}
