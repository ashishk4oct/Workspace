package com.java.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyCountDownLatch {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(3);
		ExecutorService es = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 3; i++) {
			es.submit(new Processors(countDownLatch));
		}

		es.shutdown();

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completed...");
	}

	static class Processors implements Runnable {

		private CountDownLatch latch;

		public Processors(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {

			System.out.println("Started... ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			latch.countDown();

		}

	}

}
