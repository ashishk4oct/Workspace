package com.java.thread.mypool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private MyThread [] threads ;
	private BlockingQueue<Runnable> blockingQueue;
	
	public ThreadPool(int max) {
		blockingQueue = new LinkedBlockingQueue<>();
		
		threads = new MyThread[max];
		for(int i = 0 ; i < max ; i++) {
			threads[i] = new MyThread(blockingQueue);
			threads[i].start();
		}
		
	}
	
	public void execute(Runnable runnable) {
		try {
			this.blockingQueue.put(runnable);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].shutdown();
		}
	}
}
