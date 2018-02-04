package com.learning.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UsingFunction {

	public static void main(String[] args) {

		Function<String,Integer> print = (str) -> str.length();
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("abc");
		stringList.add("Y");
		stringList.add("hehe");
		
		for (Integer i : operate(stringList,print)) {
			System.out.println(i);
		}
	
	}

	private static List<Integer> operate(List<String> stringList, Function<String,Integer> print) {
		List<Integer> strLength = new ArrayList<>();
		for (String string : stringList) {
			strLength.add(print.apply(string));
		}
		return strLength;
	}

}
