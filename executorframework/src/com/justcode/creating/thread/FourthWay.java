package com.justcode.creating.thread;

/*in fourth way , thread creating and task assigning is housed inside constructor of task
 * hence no thread reference will be available to developer to manipulate later */
public class FourthWay {

	public static void main(String[] args) {
		System.out.println("main thread begins");
		ThreadFourthWay thirdway = new ThreadFourthWay();
		
		int i =8;
		while(i!=0){
			System.out.println("i in main thread -->"+i);
			i--;
		}
		System.out.println("main thread ends");

	}

}

class ThreadFourthWay implements Runnable {
	
	public ThreadFourthWay(){
		new Thread(this).start();
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