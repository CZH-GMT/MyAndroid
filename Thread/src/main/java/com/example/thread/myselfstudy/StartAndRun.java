package com.example.thread.myselfstudy;

/**
 * 线程start 和 run的区别  调用run跟普通调用方法一样在主线程
 * 调用start才是真正的开启线程
 */
public class StartAndRun {
    static class ThreadRun extends Thread {
        @Override
        public void run() {
            super.run();
            int i = 90;
            while (i > 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am " + Thread.currentThread().getName()
                        + " and now the i=" + i--);
            }
        }
    }

    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("Thread And Run");
        threadRun.run(); //  I am main and now the i=4
    }
}
