package com.example.proxy.staticproxy;

//真实的对象2
public class Real2 implements MessageInterface {
    @Override
    public void text() {
        System.out.println("我是真实的对象2");
    }
}
