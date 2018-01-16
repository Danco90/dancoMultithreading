package com.daniele.multithreading.thread.concurrency.synchmethod;

import java.util.Vector;

/**
 * 
 * @author matteodaniele
 * @update 1/14/2018
 * @version 0.7.3
 */
public class MyProducer extends Thread {
	
	private MyPCMonitor monit;
	
	public MyProducer(MyPCMonitor monit){
		this.monit = monit;
	}
	
	@Override
	public void run(){
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		try{
			while(true){
				monit.putMessage();
				sleep(1200);
			}
		} catch (InterruptedException e){		
		}
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
	    
	}
	
	
}
