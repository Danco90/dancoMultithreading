package com.daniele.multithreading.threadpool;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.3.1
 */
public class WorkerThread implements Runnable {
	
	private String message;
	
	public WorkerThread(String s){
		this.message=s;
	}
	
	public void run(){
		System.out.println(Thread.currentThread().getName()+" (Start) message ="+message);
		processMessage();//call method that sleeps the thread for 2 seconds.
		System.out.println(Thread.currentThread().getName()+" (End)");
		
	}
	
	private void processMessage(){
		try{ Thread.sleep(2000);} catch(InterruptedException e){ e.printStackTrace(); }
	}

}
