package com.java.basics;

public class FinallyBehaviour {

	public static void main(String[] args) {
		System.out.println(behaviour1());
		System.out.println("------------------------------------");
		System.out.println(behaviour2());
		System.out.println("------------------------------------");
		System.out.println(behaviour3());
	}

	private static int behaviour1() {

		try {
			System.out.println(10/0);
			return 5;
		}catch(ArithmeticException ae) {
			System.out.println(15);
			return 15;
		}finally {
			System.out.println(20);
			return 20;
		}
	}	
	
	private static int behaviour2() {

		try {
			System.out.println(10/2);
			return 5;
		}catch(ArithmeticException ae) {
			System.out.println(15);
			return 15;
		}finally {
			System.out.println(20);
			return 20;
		}
	}
	
	private static int behaviour3() {

		try {
			System.out.println(10/2);
			System.exit(0);
		}catch(ArithmeticException ae) {
			System.out.println(15);
			return 15;
		}finally {
			System.out.println(20);
			return 20;
		}
	}	
	
	
	
}
