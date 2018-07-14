package com.justcode.creating.thread;

/*in first way of creating thread Thread and Task declaration are closely tied
 * thread  start logic goes inside the constructor*/
public class FirstWay {

	public static void main(String[] args) {
		System.out.println("main thread begins");
		new ThreadFirstWay();
		int i =8;
		while(i!=0){
			System.out.println("i in main thread -->"+i);
			i--;
		}
		System.out.println("main thread ends");

	}

}

class ThreadFirstWay extends Thread {
	
	public ThreadFirstWay(){
		this.start();
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