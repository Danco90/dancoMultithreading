package com.daniele.multithreading.threadgroup;

/**
 * 
 * @author matteodaniele
 * @update 1/14/2018
 * @version 0.2.1
 */
public class ThreadGroupDemo implements Runnable {

	public void run() {
		System.out.println("Current thread running: "+Thread.currentThread().getName());
	}
	
	public static void main(String[] args){
		ThreadGroupDemo runnable = new ThreadGroupDemo();
		ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");//creates a thread  group with given name
		
		Thread t1 = new Thread(tg1,runnable,"one");
		t1.start();
		
		Thread t2 = new Thread(tg1,runnable,"two");
		t2.start();
		
		Thread t3 = new Thread(tg1,runnable,"three");
		t3.start();
		
		System.out.println("Thread Group Name: "+tg1.getName());
		
		tg1.list();
		
	}

}
