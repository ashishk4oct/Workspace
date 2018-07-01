package com.java.concurrency.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private BlockingQueue<String> bloakingQueue;
	
	public Consumer(BlockingQueue<String> bloakingQueue){
		this.bloakingQueue = bloakingQueue;
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				consume(bloakingQueue.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume(String take) {
		System.out.println(take);	
	}

}