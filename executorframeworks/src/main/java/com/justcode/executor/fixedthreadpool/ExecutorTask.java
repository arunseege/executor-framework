package com.justcode.executor.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorTask{
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.execute(new Task());
		executor.shutdown();
	}
}
class Task implements Runnable {

	private static int count = 0;
	private int id;

	public Task() {
		++count;
		id = count;

	}

	@Override
	public void run() {
		System.out.println("Task <" + id + ">"+"begins");
		int i = 10;
		while (i != 0) {
			System.out.println("Task id is <" + id + "> value of i is {" + i + "}");
			i--;
		}
		try {
			TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task <" + id + ">"+"ends");
	}

 }
