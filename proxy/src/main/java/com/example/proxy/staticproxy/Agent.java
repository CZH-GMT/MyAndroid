package com.example.proxy.staticproxy;

//代理角色
public class Agent implements MessageInterface {
    private MessageInterface message;

    public Agent(MessageInterface message) {
        this.message = message;
    }

    @Override
    public void text() {
        message.text();

    }
}
