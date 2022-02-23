package com.example.kotlin;

//TODO  java懒汉式单例
public class JavaLazy {
    private static JavaLazy instance;

    public JavaLazy() {
    }

    public static JavaLazy getInstance() {
        if (instance == null) {
            instance = new JavaLazy();
        }
        return instance;
    }

    public void show() {
        System.out.print("show------------------------------------------");
    }

    public static void main(String[] args) {
        JavaLazy.getInstance().show();
    }
}
