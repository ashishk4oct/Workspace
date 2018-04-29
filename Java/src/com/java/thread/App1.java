package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App1 {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService es = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			es.submit(new Processor(i));
		}
		
		es.shutdown();
		
		System.out.println("All tasks submitted...");
		
		es.awaitTermination(60, TimeUnit.SECONDS);


		System.out.println("All tasks completed...");
		
	}

	static class Processor implements Runnable{
		
		private int id;

		public Processor(int id) {
			this.id = id;
		}

		@Override
		public void run() {

			System.out.println("Starting ... "+id);
			
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("Completed ... "+id);
			
		}
	}
}
