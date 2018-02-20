package com.java.streams.questions;

import java.util.stream.Stream;

public class Febonacci {

	public static void main(String[] args) {

		Stream.iterate(new int[]{0,1}, (a) -> new int[] {a[1],a[0]+a[1]})
			  .limit(20)
			  .forEach((a) -> System.out.println(a[0]));
	}

}
