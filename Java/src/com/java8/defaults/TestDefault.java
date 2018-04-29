package com.java8.defaults;

public class TestDefault implements MyInterfaceParent {

	public static void main(String[] args) {
		TestDefault test = new TestDefault();
		test.test();
		
		MyInterfaceParent.test1();
		MyInterfaceChild.test1();
	}
}
