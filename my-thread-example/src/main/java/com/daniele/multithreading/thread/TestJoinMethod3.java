package com.daniele.multithreading.thread;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.2.1
 */
public class TestJoinMethod3 extends Thread {
	
	public void run(){
		System.out.println("running...");
	}

	public static void main(String[] args) {
		
		TestJoinMethod3 thread1 = new TestJoinMethod3();
		TestJoinMethod3 thread2 = new TestJoinMethod3();
		
		System.out.println("Name of thread1:"+thread1.getName());
		System.out.println("Name of thread2:"+thread2.getName());
		System.out.println("id of thread1:"+thread1.getId());
		
		thread1.start();
		thread2.start();
		
		thread1.setName("Sonooo Matteo");//It could be executed before thread2.start()
		System.out.println("After changing name of thread1:"+thread1.getName());
	
	}

}
