package com.daniele.multithreading.threadgroup;

import java.util.Vector;

/**
 * 
 * @author matteodaniele
 * @update 1/15/2018
 * @version 0.6.1
 */
public class MyBakeryMonitor {

	static final int MAXQUEUE = 5;
    private Vector messages = new Vector();
    

	public synchronized void produceBread() throws InterruptedException{
    	while (messages.size() == MAXQUEUE) {
//    		wait();
    		if(Thread.currentThread().getThreadGroup().getParent()!=null 
    				&&"Parents ThreadGroup".equals(Thread.currentThread().getThreadGroup().getParent().getName()))
    		{
    				System.out.println("Interrupting group: "+Thread.currentThread().getThreadGroup().getParent().getName());
    				Thread.currentThread().getThreadGroup().getParent().interrupt();//It causes interruption of this group and also all its subgroups.
    		}
    		wait();
    	}
    	int range = (5 - 1) +1;// Range 5 = from 0 to 4
    	int random = (int)(Math.random() * range)+1;//from 1 to 5
    	String item = (Bakery.getText(String.valueOf(random))).getValue() /*new java.util.Date().toString()*/; 
    	messages.addElement(item);
    	
    	System.out.println(Thread.currentThread().getName()+" produced :"+item+". Item left:"+messages.size());
    	notify();//Later, when the necessary event happens, 
    	//the thread that is running it calls notify() from a block synchronized 
    	//on the same object.
    }
    
    public synchronized String buySomeBread() throws InterruptedException {
    	notify();
    	while(messages.size() == 0) {
    		wait();//By exec wait() from a sync block, a thread gives up 
    		//its hold on the lock and goes to sleep
    	}
    	String item = (String) messages.firstElement();
    	messages.removeElement(item);
    	System.out.println(Thread.currentThread().getName()+": Got bread: " + item+". Items left:"+messages.size() );
    	return item;
    }
	
	public static void main(String[] args) {
		
		MyBakeryMonitor monit = new MyBakeryMonitor();
		MyBakeryProdThreadGroup runnableP = new MyBakeryProdThreadGroup(monit);
		MyBakeryConsThreadGroup runnableC = new MyBakeryConsThreadGroup(monit);
		
		ThreadGroup tg1 = new ThreadGroup("Parents ThreadGroup");
		//ThreadGroup tg2 = new ThreadGroup("Sons ThreadGroup");
		ThreadGroup tg3 = new ThreadGroup(tg1,"Family ThreadGroup");//creates a thread group with given parent group and name
		
		ThreadGroup tg4 = new ThreadGroup("Customers ThredGroup");//creates a thread group with given parent group and name
		
		Thread t1 = new Thread(tg1,runnableP,"dad");
		Thread t2 = new Thread(tg1,runnableP,"mum");
		t1.start();
		t2.start();
		
		Thread t3 = new Thread(tg3,runnableP,"son");
		System.out.println("Producer Thread Group Name: "+tg3.getName());
		tg3.list();
		t3.start();
		
		Thread t4 = new Thread(tg3,runnableP,"daughter");
		System.out.println("Consumer Thread Group Name: "+tg4.getName());
		tg4.list();
		t4.start();
		
		Thread t5 = new Thread(tg4,runnableC,"matteo clubber");
		Thread t6 = new Thread(tg4,runnableC,"antonio student");
		t5.start();
		t6.start();
		
	}

}
