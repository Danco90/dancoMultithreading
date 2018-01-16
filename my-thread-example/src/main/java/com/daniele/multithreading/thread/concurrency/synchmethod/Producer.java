package com.daniele.multithreading.thread.concurrency.synchmethod;

import java.util.Vector;

/**
 * 
 * @author matteodaniele
 * @update 1/14/2018
 * @version 0.7.2
 */
public class Producer extends Thread {
	static final int MAXQUEUE = 5;
    private Vector messages = new Vector();
    
    @Override
    public void run(){
    	System.out.println("Thread started:::"+Thread.currentThread().getName());
    	try{
    		while(true){
    			putMessage();
    			//sleep(100);
    		}
    	} catch (InterruptedException e){
    	}
    	System.out.println("Thread ended:::"+Thread.currentThread().getName());
	    
    }
    
    private synchronized void putMessage() throws InterruptedException{
    	while (messages.size() == MAXQUEUE) {
    		wait();
    	}
    	String instantDate = new java.util.Date().toString(); 
    	messages.addElement(instantDate);
    	
    	System.out.println(Thread.currentThread().getName()+" put message :"+instantDate);
    	notify();//Later, when the necessary event happens, 
    	//the thread that is running it calls notify() from a block synchronized 
    	//on the same object.
    }
    
    public synchronized String getMessage() throws InterruptedException {
    	notify();
    	while(messages.size() == 0) {
    		wait();//By exec wait() from a sync block, a thread gives up 
    		//its hold on the lock and goes to sleep
    	}
    	String message = (String) messages.firstElement();
    	messages.removeElement(message);
    	return message;
    }
    
}
