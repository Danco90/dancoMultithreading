package com.daniele.multithreading.thread.concurrency.synchmethod;

import java.util.Vector;

/**
 * 
 * @author matteodaniele
 * @update 1/14/2018
 * @version 0.7.5
 */
public class MyPCMonitor {
	
	static final int MAXQUEUE = 5;
    private static Vector<String> messages = new Vector<String>();

	public synchronized void putMessage() throws InterruptedException {
		while (messages.size() == MAXQUEUE){
			wait();
		}
		String instantDate = new java.util.Date().toString(); 
		messages.addElement(instantDate);
		System.out.println(Thread.currentThread().getName()+" put message :"+instantDate);
		notify();
	}
	
	public synchronized String getMessage() throws InterruptedException {
		notify();
		while (messages.size() == 0){
			wait();
		}
		String message = (String) messages.firstElement();
		messages.removeElement(message);
//		notify();
		return message;
	}


	public static void main(String[] args) {
		
		MyPCMonitor monitor = new MyPCMonitor();
		MyProducer p = new MyProducer(monitor);
		MyConsumer c = new MyConsumer(monitor);
		
		p.start();
		
		c.start();
		
	}

}
