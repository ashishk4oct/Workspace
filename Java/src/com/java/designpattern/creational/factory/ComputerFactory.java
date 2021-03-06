package com.java.designpattern.creational.factory;

public class ComputerFactory {

	private ComputerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {

		if ("PC".equalsIgnoreCase(type))
			return new PC(ram, hdd, cpu);
		else if ("Server".equalsIgnoreCase(type))
			return new Server(ram, hdd, cpu);

		return null;
	}
}
