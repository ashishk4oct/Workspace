package com.java.methodreference;

import java.util.*;

public class LearningMethodReference {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(6,7,17,8,8,9,1,2,13,4));
		
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		
		list.sort((Integer o1, Integer o2) -> o2.compareTo(o1));
//		Collections.sort (list, new Descending() );

		System.out.println();
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
	}
}

class Descending implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1 > o2) {
			return -1;
		}else if(o1 < o2) {
			return 1;
		}
		return 0;
	}
}
