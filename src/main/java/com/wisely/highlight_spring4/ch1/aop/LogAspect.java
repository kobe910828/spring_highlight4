package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.Action)")
    public void annotationPointCut(){}

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        //MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //Method method = signature.getMethod();
        //Action action = method.getAnnotation(Action.class);
        //System.out.println("注解式拦截:" + action.name());
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Method[] methods = joinPoint.getTarget().getClass().getMethods();
        String operationType = "";
        String operationName = "";
        System.out.println("targetName: " + targetName);
        System.out.println("methodName: " + methodName);
        for (Method method : methods) {
            System.out.println("method.name: " + method.getName());
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    System.out.println("arguments.length: " + arguments.length);
                    operationType = method.getAnnotation(Action.class).operationType();
                    operationName = method.getAnnotation(Action.class).operationName();
                    break;
                }
            }
        }
        System.out.println("operationType: " + operationType);
        System.out.println("operationName: " + operationName);
        //可以做一些操作，例如日志记录等

    }

    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截:" + method.getName());
    }
}
