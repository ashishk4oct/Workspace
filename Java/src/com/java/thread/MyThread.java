package com.java.thread;

public class MyThread {

	private int count = 0;

	public static void main(String[] args) throws InterruptedException {

		MyThread myThread = new MyThread();
		myThread.doWork();
		

	}

	private void doWork() throws InterruptedException {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				increment();
			}
		}, "A");
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				increment();
			}
		}, "B");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(count);
	}

	private synchronized void increment() {
		count++;
	}
}
