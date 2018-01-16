package com.daniele.multithreading.thread;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.3.1
 */
public class TestJoinMethod4 extends Thread {
	
	public void run(){
		
	 System.out.println("current running thread is: "+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		
		TestJoinMethod4 t1 = new TestJoinMethod4();
		TestJoinMethod4 t2 = new TestJoinMethod4();
		
		t1.start();
		t2.start();
		
	}

}
