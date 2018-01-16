package com.daniele.multithreading.thread.join;

/**
 * 
 * @author matteodaniele
 * @update 1/12/2018
 * @version 0.4.1
 */
public class ThreadJoinExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "t1");
		Thread t2 = new Thread(new MyRunnable(), "t2");
		Thread t3 = new Thread(new MyRunnable(), "t3");
		
		t1.start();
		
		//start second thread after waiting for 2 seconds or if it's dead
		try{
			t1.join(2000);//after 2 sec it put the current thread in waiting status till the thread is dead.
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		t2.start();//t2 is set in runnable state or after 2 second of waiting or after t1 is really died.
		//then, the thread.JVM calls the run() on t2. The action will be definitely performed for t2.
	
	
		//It starts third thread only when first thread is dead
		try{
			t2.join();//put current thread in wait till t1 has dead.
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		t3.start();//t3 start after t1 had dead.
		
		//let all threads finish execution before finishing main thread
		try{
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("All thread are dead, exiting main thread");
		
	}
	
	
	

}
