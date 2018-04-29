package com.java8.diamond.problem;

public interface A {
	default int count() {
		System.out.println("0");
		return 0;
	}
}
