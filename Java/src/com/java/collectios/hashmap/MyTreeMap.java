package com.java.collectios.hashmap;

import java.util.TreeMap;

public class MyTreeMap {

	public static void main(String[] args) {

		TreeMap<Key, String> treeMap = new TreeMap<>();
		treeMap.put(new Key(1), "1");
		treeMap.put(new Key(2), "2");
		treeMap.put(new Key(3), "3");
		treeMap.put(new Key(4), "4");
		treeMap.put(new Key(5), "5");
		treeMap.put(new Key(6), "6");
		
		for (Key key : treeMap.keySet()) {
			
			System.out.println(treeMap.get(key));
			
		}
		
	}

	static class Key implements Comparable<Key>{
		int id ;
		int name ;
		
		Key(int id){
			this.id = id;
		}
		
		@Override
		public int compareTo(Key o) {
			return this.id - o.id;
		}
		
	}
}
