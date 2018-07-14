package com.justcode.thread.naming;

import java.util.concurrent.TimeUnit;

public class FirstwayThread implements Runnable {

	private int taskId;
	private static int count=0;
	private String currentThreadName;
	@Override
	public void run() {
System.out.println("#############  "+currentThreadName+"  ##### begins");
		int i=5;
		while(i!=0){
			System.out.println("value of i in "+currentThreadName+" is -> "+i);
			i--;		
		
		try {
			TimeUnit.MILLISECONDS.sleep((long)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("#############   "+currentThreadName+"  ##### ends");
	}
public FirstwayThread() {
	this.currentThreadName=" Thread -->"+ ++count;
	this.taskId=count;
}
}
