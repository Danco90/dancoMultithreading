package com.daniele.multithreading.threadgroup;
/**
 * 
 * @author matteodaniele
 * @update 1/15/2018
 * @version 0.6.2
 */
public class MyBakeryConsThreadGroup implements Runnable {
	
	private MyBakeryMonitor monit;
	
	public MyBakeryConsThreadGroup(MyBakeryMonitor monit){
		this.monit = monit;
	}
	
	public void run(){
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		try{
			while(true){
				String item = monit.buySomeBread();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
	    
	}


}
