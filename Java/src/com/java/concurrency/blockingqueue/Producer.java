package com.java.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<String> bloakingQueue;
	
	static int count = 0;
	
	Producer(BlockingQueue<String> bloakingQueue){
		this.bloakingQueue = bloakingQueue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				bloakingQueue.put(produce());
//				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private String produce() {
		return ""+count++;
	}

}
