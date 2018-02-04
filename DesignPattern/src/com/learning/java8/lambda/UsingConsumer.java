package com.learning.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UsingConsumer {

	public static void main(String[] args) {

		Consumer<String> print = (str) -> System.out.print(str+"**");
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("Ashish");
		stringList.add("Kumar");
		stringList.add("Singh");
		
		operate(stringList,print);
	
	}

	private static void operate(List<String> stringList, Consumer<String> print) {
		for (String string : stringList) {
			print.accept(string);
		}
	}
}
