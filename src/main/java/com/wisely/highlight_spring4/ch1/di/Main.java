package com.wisely.highlight_spring4.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService =
                context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("helloworld"));
        context.close();
    }
}
