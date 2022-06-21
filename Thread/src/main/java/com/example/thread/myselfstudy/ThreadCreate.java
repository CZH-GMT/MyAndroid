package com.example.thread.myselfstudy;

/**
 * 启动线程方式
 */
public class ThreadCreate {
    //继承Thread类 重写run方法
    static class UserThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("我是继承Thread类 重写run方法的线程");
        }
    }

    //实现runnable接口实现run方法
    static class RunnableThread implements java.lang.Runnable {

        @Override
        public void run() {
            System.out.println("我是实现Runnable接口 的线程");

        }
    }

    //调用
    public static void main(String[] args) {
        UserThread userThread = new UserThread();
        userThread.start();

        RunnableThread runnableThread = new RunnableThread();
        new Thread(runnableThread).start();
    }
}
