package com.justcode.creating.thread;

/*in third way , creating thread is independent from task 
 *declarartion .Hence we have to create thread and assign task to it
 *and start the thread and all these under developer control ,when to create assign and start
 *.it also give reference to thread for developer*/
public class ThirdWay {

	public static void main(String[] args) {
		System.out.println("main thread begins");
		ThreadThirdWay thirdway = new ThreadThirdWay();
		Thread t1=new Thread(thirdway);
		t1.start();
		int i =8;
		while(i!=0){
			System.out.println("i in main thread -->"+i);
			i--;
		}
		System.out.println("main thread ends");

	}

}

class ThreadThirdWay implements Runnable {
	
	public ThreadThirdWay(){
		
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