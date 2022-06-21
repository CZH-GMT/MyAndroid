package com.example.thread.myselfstudy;

import com.example.thread.tools.SleepTools;

/**
 * 线程join方法的使用  简单地说就是插队
 */
public class UserJoin {
    static class Goddess implements Runnable {
        private Thread thread;

        public Goddess(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println("Goddess开始排队打饭.....");
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SleepTools.second(2);//休眠2秒
                System.out.println("Goddess打饭完成.....");
            }
        }
    }

    static class GoddessFriends implements Runnable {

        @Override
        public void run() {
            SleepTools.second(2);//休眠2秒
            System.out.println("Goddess  朋友  开始排队打饭.....");
            System.out.println(" Goddess  朋友  打饭完成.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GoddessFriends goddessFriends = new GoddessFriends();
        Thread goddessFriendsThread = new Thread(goddessFriends);

        Goddess goddess = new Goddess(goddessFriendsThread);
        Thread goddessThread = new Thread(goddess);

        goddessThread.start();
        goddessFriendsThread.start();
        System.out.println("我开始打饭");
        goddessThread.join();
        SleepTools.second(2);
        System.out.println("我打饭完成");




    }
}
