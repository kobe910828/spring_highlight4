package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    //@Action(name="注解式拦截的add操作")
    @Action(operationType = "add", operationName = "插入")
    public void add(){}

    @Action(operationType = "update", operationName = "更新")
    public void update(){}
}
