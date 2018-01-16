package com.daniele.multithreading.threadgroup;

/**
 * 
 * @author matteodaniele
 * @update 1/15/2018
 * @version 0.7.2
 */
public class MyBakeryProdThreadGroup implements Runnable {
	
	private MyBakeryMonitor monit;
	
	public MyBakeryProdThreadGroup(MyBakeryMonitor monit){
		this.monit = monit;
	}

    public void run(){
    	System.out.println("Thread started:::"+Thread.currentThread().getName());
    	try{
    		while(true){
    			monit.produceBread();
    			Thread.sleep(100);
    		}
    	} catch (InterruptedException e){
    	}
    	System.out.println("Thread ended:::"+Thread.currentThread().getName());
	    
    }
    
    
	
	

}
