package com.java.pack1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Animal {

	public static void main(String args[]) {

		
		StringBuffer sb = new StringBuffer();
		
		
		for (int i = 0; i < 1000000; i++) {
			System.out.println(i);
		}

		int i = 10, j = 10;
		System.out.println("Binary multiply " + i + "^" + j + ": " + (i ^ j ^ 6));
		HashMap<String, String> hm = new HashMap<>();
		hm.put(null, "Null");

		Set<String> s = new HashSet<>();
		s.add(null);
		s.add("ashish");

		s.forEach(System.out::println);

	}
}

class Dog extends Animal {

}

class Cat extends Animal {

}
