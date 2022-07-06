package com.example.thread.myselfstudy;

/**
 * synchronized
 */
public class SynThread {

    private int cont = 0;

    private Object object = new Object();

    public int getCont() {
        return cont;
    }

    //正常的cont
    private void AddCont1() {
        cont++;
    }

    //todo 加锁的cont第一种  叫做同步方法
    private synchronized void AddCont2() {
        cont++;
    }

    //todo 加锁的cont第2种  叫做同步块
    private void AddCont3() {
        synchronized (object) {
            cont++;
        }

    }

    //todo 加锁的cont第3种  叫做同步块
    private void AddCont4() {
        synchronized (this) {
            cont++;
        }

    }

    private static class initContThread extends Thread {
        private SynThread synThread;

        public initContThread(SynThread synThread) {
            this.synThread = synThread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
//                synThread.AddCont1();//值不等于20000
//                synThread.AddCont2();//值等于20000
                synThread.AddCont3();//值等于20000

            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynThread synThread = new SynThread();
        //启动两个线程
        initContThread initContThread1 = new initContThread(synThread);
        initContThread initContThread2 = new initContThread(synThread);
        initContThread1.start();
        initContThread2.start();
        Thread.sleep(50);
        System.out.println(synThread.cont);
    }


}
