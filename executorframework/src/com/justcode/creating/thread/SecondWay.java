package com.justcode.creating.thread;

/*in second way of creating thread, Thread and Task declaration are closely tied
 * thread  start logic comes to developer control,he can decide when to start*/
public class SecondWay {

	public static void main(String[] args) {
		System.out.println("main thread begins");
		ThreadSecondWay secondway = new ThreadSecondWay();
		secondway.start();
		int i =8;
		while(i!=0){
			System.out.println("i in main thread -->"+i);
			i--;
		}
		System.out.println("main thread ends");

	}

}

class ThreadSecondWay extends Thread {
	
	public ThreadSecondWay(){
		
	}
	
	@Override
	public void run() {
		System.out.println("child thread begins");
		int i =8;
		while(i!=0){
			System.out.println("i in chile thread -->"+i);
			i--;
		}
		System.out.println("child thread ends");
	}
 }