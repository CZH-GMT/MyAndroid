package com.example.kotlin;

//TODO java 单例
public class JavaDanLi {
    //TODO 饿汉式  （很着急先创建出来直接给你）
    private static final JavaDanLi instance = new JavaDanLi();

    public JavaDanLi() {
    }

    public static JavaDanLi getInstance() {
        return instance;
    }

}
