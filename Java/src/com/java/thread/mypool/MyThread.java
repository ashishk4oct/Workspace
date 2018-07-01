package com.java.thread.mypool;

import java.util.concurrent.BlockingQueue;

public class MyThread extends Thread {


	private BlockingQueue<Runnable> blockingQueue;
	private boolean running = true;
	
	public MyThread(BlockingQueue<Runnable> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while (running) {
			try {
				Runnable runnable = blockingQueue.take();
				runnable.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}

}
