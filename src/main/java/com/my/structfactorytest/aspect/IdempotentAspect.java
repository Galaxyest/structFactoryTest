package com.my.structfactorytest.aspect;

import com.my.structfactorytest.Interfaces.Idempotent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IdempotentAspect {

    @Pointcut("@annotation(idempotent)")
    public void idempotentPointcut(Idempotent idempotent) {
    }

    @Before("idempotentPointcut(idempotent)")
    public void before(JoinPoint joinPoint, Idempotent idempotent) {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before method: " + methodName);
        System.out.println("Args: " + args);
    }

    @AfterReturning(pointcut = "idempotentPointcut(idempotent)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Idempotent idempotent, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning method: " + methodName);
        System.out.println("Result: " + result);
    }
}
