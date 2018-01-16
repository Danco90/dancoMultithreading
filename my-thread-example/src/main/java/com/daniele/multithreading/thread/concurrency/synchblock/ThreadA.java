package com.daniele.multithreading.thread.concurrency.synchblock;

public class ThreadA {

	public static void main(String[] args) {
		
		ThreadB b = new ThreadA().new ThreadB();
		b.start();
		
		synchronized(b){
			try{
				System.out.println("Waiting for b to complete...");
				b.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("Total is: "+ b.total);
		}
	}
	
	class ThreadB extends Thread{
		int total;
		@Override
		public void run(){
			synchronized(this){
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
				notify();
			}
		}
	}

}
