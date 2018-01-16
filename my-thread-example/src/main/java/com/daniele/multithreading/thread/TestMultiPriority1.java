package com.daniele.multithreading.thread;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.3.1
 */
public class TestMultiPriority1 extends Thread {
	
	public void run(){
		System.out.println("current running thread name is: "+Thread.currentThread().getName());
		System.out.println("current running thread priority is: "+Thread.currentThread().getPriority());
		
	}

	public static void main(String[] args) {
		TestMultiPriority1 m1 = new TestMultiPriority1();
		TestMultiPriority1 m2 = new TestMultiPriority1();
		m1.setName("thread-m1");
		m1.setPriority(Thread.MIN_PRIORITY);
		m2.setName("thread-m2");
		m2.setPriority(Thread.MAX_PRIORITY);
		
		m1.start();
		m2.start();
		
	}

}
