package com.java8.defaults;

public interface MyInterfaceParent {
	
	default void test() {
		System.out.println("Parent");
	}
	
	static void test1() {
		System.out.println("Parent1");
	}
}

