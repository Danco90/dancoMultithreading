package com.daniele.multithreading.thread.concurrency.synchmethod;

public class MyMonitor {
	
	int total;
	
	public synchronized void doB(boolean isLocked){
		
		while(!isLocked){
			try {
				for(int i=0; i<100; i++){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					total += i;
					System.out.println("total is: "+ total);
				}
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isLocked = false;
		notify();
		
	}
	
	public synchronized void doA(boolean isLocked){
		//while(!isLocked){
		try{
			System.out.println("Waiting for b to complete...");
			//b.wait();
			wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		//System.out.println("Total is: "+ b.total);
		//}
		isLocked = false;
		notify();
	}

	public static void main(String[] args) {
		MyMonitor monitor = new MyMonitor();
		Thread1 t1 = monitor.new Thread1();
		Thread2 t2 = monitor.new Thread2();
		
		t1.start();
		t2.start();

	}
	
	class Thread1 extends Thread{
		@Override
		public void run(){
			
		}
		
	}
	
	class Thread2 extends Thread{
		@Override
		public void run(){
			
		}
	}

}
