package com.daniele.multithreading.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.3.1
 */
public class TestThreadPool {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads
		for(int i=0; i<10; i++){
			Runnable worker = new WorkerThread("" +i);
			executor.execute(worker);//calling execute method of ExecutorService
		
		}
		
		executor.shutdown();
		while(!executor.isTerminated()){ }
		
		System.out.println("Finished all threads");
	}

}
