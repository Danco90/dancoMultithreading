package com.daniele.multithreading.thread;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.3.1
 */
public class TestDaemonThread1 extends Thread {
	
	public void run(){
		if(Thread.currentThread().isDaemon()){//checking for daemon thread
			System.out.println("daemon thread: "+Thread.currentThread().getName()+" works");
		
		}else{
			System.out.println("user thread: "+Thread.currentThread().getName()+" works");
			
		}
	}

	public static void main(String[] args) {
		TestDaemonThread1 dt1 = new TestDaemonThread1();
		TestDaemonThread1 dt2 = new TestDaemonThread1();
		TestDaemonThread1 dt3 = new TestDaemonThread1();
		
		dt1.setDaemon(true);//now t1 is daemon thread
		dt1.start();
		dt2.start();
		dt3.start();
		
	}

}
