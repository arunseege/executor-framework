package com.justcode.thread.naming;

public class NamingFirstWay {

	public static void main(String[] args) {
		System.out.println("main begins");
		new Thread(new FirstwayThread()).start();
		new Thread(new FirstwayThread()).start();
		System.out.println("main ends");
		//by Thread.setName or Thread constructor

	}

}
