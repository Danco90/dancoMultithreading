package com.daniele.multithreading.thread.concurrency.lock;

public class MyLock {
	
	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked){
			wait();
		}
		isLocked =true;
	}
	
	public synchronized void unlock(){
		isLocked = false;
		notify();
	}

}
