package com.learning.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsingPredicate {

	public static void main(String[] args) {

		Predicate<String> isEmptyPredicate = (str) -> str.isEmpty();
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("Ashish");
		stringList.add("");
		stringList.add("Kumar");
		stringList.add("");
		stringList.add("Singh");
		List<String> nonEmptyStringList = filter(stringList,isEmptyPredicate);
		for (String string : nonEmptyStringList) {
			System.out.print(string+".");
		}
	}

	private static List<String> filter(List<String> stringList, Predicate<String> isEmptyPredicate) {
		List<String> nonEmptyStringList = new ArrayList<String>();
		for (String string : stringList) {
			
			if(!isEmptyPredicate.test(string)) {
				nonEmptyStringList.add(string);
			}
			
		}
		return nonEmptyStringList;
	}

}
