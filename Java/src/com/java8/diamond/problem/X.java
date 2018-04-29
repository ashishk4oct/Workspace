package com.java8.diamond.problem;

public interface X {
	default int count() {
		System.out.println("1");
		return 1;
	}
}
