package com.java.thread.locks.ex1;

import java.util.concurrent.locks.Lock;

public class ExplicitLock implements Runnable {

	private Lock lock;

	public ExplicitLock(Lock lock) {
		super();
		this.lock = lock;
	}

	@Override
	public void run() {

//		printMessage("Entered run method...trying to lock monitor object");
		lock.lock();
		try {
			printMessage("Locked monitor object");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} finally {
			printMessage("Realising lock");
			lock.unlock();
		}
//		printMessage("End of run method");
	}

	private void printMessage(String msg) {
		System.out.println(Thread.currentThread().getName() + " : " + msg);
	}

}