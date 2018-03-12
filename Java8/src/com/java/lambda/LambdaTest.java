package com.java.lambda;

public class LambdaTest {

	public void test() {
		Runnable r = () -> {
			int i = 1;
			System.out.println(i +". Hi this is runnable from lambda.");
			System.out.println(this);
		};
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				int i = 1;
				System.out.println(i +". Hi this is runnable from anonymusClass.");
				System.out.println(this);
			}
		};
		
		Thread t = new Thread(r);
		t.run();
		
		Thread t1 = new Thread(r1);
		t1.run();
	}
	public static void main(String[] args) {
		new LambdaTest().test();
	}

}
