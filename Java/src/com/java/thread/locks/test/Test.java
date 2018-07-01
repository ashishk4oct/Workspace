package com.java.thread.locks.test;

public class Test {

	public static void main(String args []) throws Exception {
//		Test t = new Test();
//		t.testWait();
//		t.testNotify();
		
		sample(new Integer(1));
		
		B b = new B();
		A a = new A();
		A c = new B();
		
		b.test(a);
		b.test(b);
		b.test(c);
		
	}

	private static void sample(int i) {
		System.out.println("int");
	}
	private static void sample(long i) {
		System.out.println("long");
	}
	
	private static void sample(Integer i) {
		System.out.println("Integer");
	}

	private synchronized void testWait() throws InterruptedException {
		Thread t = new Thread(() ->{
			System.out.println("wait");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
	}
	
	private synchronized void testNotify() throws InterruptedException {
		System.out.println("notify");
		this.notify();
	}

	
	
}

class A{
	protected void test(A a) {
		System.out.println("A");
	}
}
class B extends A{
	public void test(B b) {
		System.out.println("B");
	}
}
