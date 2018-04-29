package com.java.thread.locks.ex1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) {
		System.out.println("=========Intrinsic Test=======");
		String[] myThreads = { "Therad ONE", "Thread TWO", "Thread THREE", "Thread FOUR" };

		
		Object monitor = new Object();
		for (String threadName : myThreads) {
			new Thread(new IntrinsicLock(monitor), threadName).start();
		}

		/*Lock lock = new ReentrantLock(true);
		for (String threadName : myThreads) {
			new Thread(new ExplicitLock(lock), threadName).start();
		}*/
	}

}
