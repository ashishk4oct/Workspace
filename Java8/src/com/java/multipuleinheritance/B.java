package com.java.multipuleinheritance;

public interface B {

	default void testDefault() {
		System.out.println("default method of interface B");
	}
	
	static void testStatic() {
		System.out.println("static method of interface B");
	}
}
