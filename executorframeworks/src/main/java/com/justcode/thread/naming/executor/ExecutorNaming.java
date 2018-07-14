package com.justcode.thread.naming.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ExecutorNaming {

	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(5, new ExecutorThreadFactory());
		int i=5;
		while(i!=0){
executor.execute(new Task());

		i--;
		}
		
		Executor executor2 = Executors.newCachedThreadPool();
		int j=5;
		while(j!=0){
executor2.execute(new Task());

		j--;
		}
		
	}

}

class ExecutorThreadFactory implements ThreadFactory{
private static int count;
	@Override
	public Thread newThread(Runnable runnable) {
		
		return new Thread(runnable, "thread-->"+ ++count);
	}
	
 }

class Task implements Runnable{

	@Override
	public void run() {
System.out.println("started "+Thread.currentThread().getName());
		int i=5;
		while(i!=0){
			System.out.println("value of i in thread "+Thread.currentThread().getName()+" is =="+i);
			i--;		
		
		try {
			TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
		System.out.println("ended "+Thread.currentThread().getName());		
	}
	
}