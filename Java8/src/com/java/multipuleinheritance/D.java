package com.java.multipuleinheritance;

public class D implements A, B {

	public static void main(String[] args) {
		new D().testDefault();
	}

	@Override
	public void testDefault() {
		B.super.testDefault();
	}
}
