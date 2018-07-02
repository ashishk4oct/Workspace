package com.java.designpattern.creational.abstractt.factory;

public class ComputerFactory {

	private ComputerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}
}
