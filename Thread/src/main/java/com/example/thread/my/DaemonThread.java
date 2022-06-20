package com.example.thread.my;

import java.util.concurrent.ExecutionException;

/**
 *
 *类说明：守护线程的使用   第六个类守护线程
 */
public class DaemonThread {
	private static class UseThread extends Thread{
		@Override
		public void run() {
			try {
				while (!isInterrupted()) {
					System.out.println(Thread.currentThread().getName() 
							+ " I am extends Thread.");
				}
				System.out.println(Thread.currentThread().getName() 
						+ " interrupt flag is " + isInterrupted());
			} finally {
				//守护线程中finally不一定起作用
				System.out.println(" .............finally");
			}
		}
	}
	
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		UseThread useThread = new UseThread();
		//useThread.setDaemon(true);
		useThread.start();
		Thread.sleep(5);
		useThread.interrupt();
	}
}
