package com.example.proxy.staticproxy;
//真实的对象1
public class Real1 implements MessageInterface {
    @Override
    public void text() {
        System.out.println("我是真实的对象1");
    }
}
