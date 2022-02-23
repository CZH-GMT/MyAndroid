package com.example.kotlin;

//TODO java 双检锁单例
public class JavaShuangJianSuoDanLi {
    //TODO    volatile
    private volatile static JavaShuangJianSuoDanLi instance;

    public JavaShuangJianSuoDanLi() {

    }

    public static JavaShuangJianSuoDanLi getInstance() {
        if (instance == null) {
            //TODO synchronized
            synchronized (JavaShuangJianSuoDanLi.class) {
                instance = new JavaShuangJianSuoDanLi();
            }

        }
        return instance;
    }
}
