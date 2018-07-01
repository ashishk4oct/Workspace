package com.java.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static void main(String[] args) {

		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		
		Thread p = new Thread(new Producer(blockingQueue));
		Thread c1 = new Thread(new Consumer(blockingQueue));
		Thread c2 = new Thread(new Consumer(blockingQueue));
		
		p.start();
		c1.start();
		c2.start();
	
	
	}

}
