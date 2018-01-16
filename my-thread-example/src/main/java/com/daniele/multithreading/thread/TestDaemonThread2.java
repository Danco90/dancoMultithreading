package com.daniele.multithreading.thread;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.3.1
 */
public class TestDaemonThread2 extends Thread {
	
	public void run(){
		System.out.println("thread name: "+Thread.currentThread().getName()+" works");
		System.out.println("Daemon: "+Thread.currentThread().isDaemon());
		
	}

	public static void main(String[] args) {
		TestDaemonThread2 dt1 = new TestDaemonThread2();
		TestDaemonThread2 dt2 = new TestDaemonThread2();
		TestDaemonThread2 dt3 = new TestDaemonThread2();
		
		dt1.start();//if start() is invoked before setting the deamon, the thread become an user one
		dt1.setDaemon(true);//It will throw IlleganThreadStateException here
		dt2.start();
		dt3.start();
		
	}

}
