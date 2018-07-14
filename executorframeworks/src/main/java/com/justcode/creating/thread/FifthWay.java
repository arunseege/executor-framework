package com.justcode.creating.thread;

/*in fourth way , thread creating and task assigning is housed inside constructor of task
 * hence no thread reference will be available to developer to manipulate later */
public class FifthWay {

	public static void main(String[] args) {
		System.out.println("main thread begins");
		
		int i =8;
		while(i!=0){
			System.out.println("i in main thread -->"+i);
			i--;
		}
		
		new Thread(() -> {
			System.out.println("child thread begins");
			int j =8;
			while(j!=0){
				System.out.println("j in main thread -->"+j);
				j--;
			}
			System.out.println("child thread ends");
		}).start();
		System.out.println("main thread ends");

	}

}

