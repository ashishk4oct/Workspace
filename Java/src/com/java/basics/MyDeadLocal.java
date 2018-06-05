package com.java.basics;

public class MyDeadLocal {

	public static void main(String[] args) {

		
		Lock a = new Lock();
		Lock b = new Lock();
		
		Thread t = new Thread(new A(a, b));
		Thread t1 = new Thread(new A(b, a));
		
		
		t.start();
		t1.start();
	}

	
	
	static class A implements Runnable{

		Lock a , b;
		A(Lock a, Lock b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public void run() {
			System.out.println("in A");
			synchronized (a) {

				System.out.println("in A a");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (b) {
					System.out.println("in A b");
					System.out.println("Ashish");
				}
			}
			
		}
	}

	static class Lock{}
}
