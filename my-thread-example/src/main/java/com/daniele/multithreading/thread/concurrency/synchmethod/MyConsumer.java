package com.daniele.multithreading.thread.concurrency.synchmethod;

/**
 * 
 * @author matteodaniele
 * @update 1/14/2018
 * @version 0.7.3
 */
public class MyConsumer extends Thread {
	
	private MyPCMonitor monit;
	
	public MyConsumer(MyPCMonitor monit){
		this.monit = monit;
	}
	
	@Override
	public void run(){
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		try{
			while(true){
				String message = monit.getMessage();
				System.out.println(Thread.currentThread().getName()+": Got message: " + message );
                sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
	    
	}

}
