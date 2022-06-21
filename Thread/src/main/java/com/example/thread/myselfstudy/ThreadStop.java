package com.example.thread.myselfstudy;

/**
 * 线程中断   interrupter 给线程打个标记 可用于线程停止
 */
public class ThreadStop {

    static class UserThread extends Thread {


        public UserThread(String name) {
            super(name);

        }

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + "-------正在循环-------interrupter   ==   " + isInterrupted());
            }
            System.out.println(Thread.currentThread().getName() + "-------跳出循环-------interrupter   ==   " + isInterrupted());

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new UserThread("华哥最帅");
        userThread.start();
        Thread.sleep(20);
        userThread.interrupt();  //中断线程  设置标志位为true
    }

}
