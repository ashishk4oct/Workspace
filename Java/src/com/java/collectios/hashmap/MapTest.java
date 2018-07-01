package com.java.collectios.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		HashMap<A,String> hm = new HashMap<A,String>();
		
		A a = new A(10);

		hm.put(a, "Ashish");
		a.setID(20);
		hm.put(a, "Kumar");
		
		for (Iterator iterator = hm.entrySet().iterator(); iterator.hasNext();) {
			Entry<A, String> type = (Entry<A, String>) iterator.next();
			
			System.out.println((A)type.getKey()+" "+type.getValue());
			
		}
		System.out.println(hm.get(a));
	}

	private static class A{
		int id = 100;


		@Override
		public String toString() {
			return this.id+"";
		}

		public A(int id) {
			this.id = id;
		}
		
		public void setID(int id) {
			this.id = id;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			A other = (A) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
		
		
	}
}
