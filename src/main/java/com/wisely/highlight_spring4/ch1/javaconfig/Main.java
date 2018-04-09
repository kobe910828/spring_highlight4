package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        UserFunctionService userFunctionService =
                context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("java config"));
        context.close();
    }
}
