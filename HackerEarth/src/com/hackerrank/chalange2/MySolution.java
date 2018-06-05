package com.hackerrank.chalange2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

public class MySolution {

	static int computerGame(int[] a, int[] b) {
		int LEN = a.length;
		HashMap<Integer, List<Integer>> possibleNonCoprimeSet = new HashMap<>();

		for (int i = 0; i < LEN; i++) {
			possibleNonCoprimeSet.put(a[i], new ArrayList<>());
			for (int j = 0; j < LEN; j++) {
				if (!coprime(a[i], b[j])) {
					if(possibleNonCoprimeSet.get(a[i]) == null) {
						possibleNonCoprimeSet.put(a[i], new ArrayList<>());
					}
					possibleNonCoprimeSet.get(a[i]).add(b[j]);
				}
			}
		}

		TreeSet<MySolution> mySolutions = new TreeSet<>();
		
		for (int i = 0; i < LEN ; i++) {
//			System.out.printf("{%d}:%-2d", a[i], count[i]);
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	static boolean isCoprime(int a, int b) {
		int num = a < b ? a : b;
		for (int i = 2; i <= num; i++) {
			if (a % i == 0 && b % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int gcd(int a, int b)
    {
        // Everything divides 0 
        if (a == 0 || b == 0)
            return 0;
         
        // base case
        if (a == b)
            return a;
         
        // a is greater
        if (a > b)
            return gcd(a-b, b);
                 
        return gcd(a, b-a);
    }
     
    // function to check and print if 
    // two numbers are co-prime or not 
    static boolean coprime(int a, int b) {
         return gcd(a, b) == 1 ? true : false;     
    }
}
