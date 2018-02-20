package com.java.multipuleinheritance;

public interface A {

	default void testDefault() {
		System.out.println("default method of interface A");
	}
	
	static void testStatic() {
		System.out.println("static method of interface A");
	}
}
