package com.java.thread.locks.ex1;

public class IntrinsicLock implements Runnable {

	private Object monitor;

	public IntrinsicLock(Object monitor) {
		this.monitor = monitor;
	}

	@Override
	public void run() {

//		printMessage("Entered run method...trying to lock monitor object");
		synchronized (monitor) {
			printMessage("Locked monitor object");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			printMessage("Releasing lock");
			monitor.notifyAll();
		}
//		printMessage("End of run method");
	}

	private void printMessage(String msg) {
		System.out.println(Thread.currentThread().getName() + " : " + msg);
	}

}
