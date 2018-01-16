package com.daniele.multithreading.thread.concurrency.synchmethod;

/**
 * 
 * @author matteodaniele
 * @update 1/14/2018
 * @version 0.7.2
 */
public class Consumer extends Thread{
	
	Producer producer;
	
	public Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run(){
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		try {
			while(true) {
				String message = producer.getMessage();
				System.out.println(Thread.currentThread().getName()+": Got message: " + message );
				//sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
	    
	}

	public static void main(String[] args) {
		Producer producer = new Producer();
		producer.start();
		new Consumer(producer).start();
	}

}
