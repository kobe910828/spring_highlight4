package com.wisely.highlight_spring4.ch2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig elConfig = context.getBean(ElConfig.class);//@Component注解修饰，也是一个Bean
        elConfig.outputResource();
        context.close();
    }
}
