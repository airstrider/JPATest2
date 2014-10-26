package com.airstrider.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HijackAroundMethod implements MethodInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		
		System.out.println("[ AOP ] Method name : "+ methodInvocation.getMethod().getName());
		System.out.println("[ AOP ] Method arguments : "+ Arrays.toString(methodInvocation.getArguments()));
		System.out.println("[ AOP ] HijackAroundMethod : BEFORE method hijacking!");
 
		try {
			Object result = methodInvocation.proceed();
			System.out.println("[ AOP ] HijackAroundMethod : AFTER method hijacking!");
			return result;
		} catch (IllegalArgumentException e) {
			System.out.println("[ AOP ] HijackAroundMethod : Throw an exception hijacked!");
			throw e;
		}
	}
}
