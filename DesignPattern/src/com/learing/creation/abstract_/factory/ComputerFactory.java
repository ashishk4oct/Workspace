package com.learing.creation.abstract_.factory;

import com.learing.creation.Computer;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory) {
		return factory.createComputer();
	}
}