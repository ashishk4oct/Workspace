package com.java.collectios.hashmap;

public class TestHashMap {

	public static void main(String[] args) {
		
		MyHashMap<String, Integer> map = new MyHashMap<String, Integer>();
		
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		
		System.out.println(map.get("a"));
		System.out.println(map.get("b"));
		System.out.println(map.get("c"));
		
	}

}
