package com.example.kotlin;

//TODO  java匿名函数和具名函数
public class ktlinjava匿名函数具名函数 {

    //TODO  java匿名函数
    public static void main(String[] args) {
        //匿名函数
        hugesssss("陈智华", 18, new resultcallback() {
            @Override
            public void result(String str) {
                System.out.println("java匿名函数" + str);
            }
        });
        //TODO  java具名函数

        results results = new results();
        hugesssss("美女", 18, results);


    }

    public static void hugesssss(String name, int age, resultcallback resultcallback) {
        String str = name + age;
        resultcallback.result(str);
    }

    private static class results implements resultcallback {

        @Override
        public void result(String str) {
            System.out.println("具名函数" + str);
        }
    }

    interface resultcallback {
        void result(String str);
    }
}
