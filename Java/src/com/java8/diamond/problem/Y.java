package com.java8.diamond.problem;

public interface Y extends X, A{

	@Override
	default int count() {
		// TODO Auto-generated method stub
		return A.super.count();
	}

}
