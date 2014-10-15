package com.airstrider.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {
	@Around("execution(* com.airstrider.service..*(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("# LoggingAspect.logAround() start");
		System.out.println("#  Hijected method: "+joinPoint.getSignature().getName());
		System.out.println("#  Hijected argument: "+Arrays.toString(joinPoint.getArgs()));

		System.out.println("#  Around before is running!");
		joinPoint.proceed();
		System.out.println("#  Around after is running!");
		
		System.out.println("# LoggingAspect.logAround() end");
	}
}
