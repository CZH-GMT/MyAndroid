package com.example.thread.myselfstudy;

/**
 * 守护线程
 * 守护线程中finally不一定起作用
 */
public class DaemonThread {

    private static class TextThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName()
                            + " I am extends Thread.");
                }
                System.out.println(Thread.currentThread().getName()
                        + " interrupt flag is " + isInterrupted());
            }finally {
                //守护线程中finally不一定起作用
                System.out.println(" .............finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TextThread textThread = new TextThread();
        textThread.start();
//        textThread.setDaemon(true);  添加守护线程之后finally不一定起作用
        Thread.sleep(5);

        textThread.interrupt();

    }
}
