package com.wisely.highlight_spring4.ch2.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent{
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
