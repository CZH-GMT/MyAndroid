package com.example.myandroid;

public class SingleText {
    private volatile static SingleText instance;

    public SingleText() {
    }
//双重检查
    public static SingleText getInstance(){
        if (instance==null){
            synchronized (SingleText.class){
                if (instance==null){
                    instance=new SingleText();
                }
            }
        }
        return instance;
    }
}
