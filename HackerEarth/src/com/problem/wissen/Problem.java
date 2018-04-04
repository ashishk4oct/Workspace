package com.problem.wissen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

	
	
	public double balancePoint(Log log) {
		return getbalancePoint(0, log.length(), log);
	}
	
	private double getbalancePoint(double start , double end , Log log){
		if(end-start < .01) 
			return start;
		
		double middle = (start+end)/2;
		double wtStart = log.weightUpto(middle)-log.weightUpto(start);
		double wtEnd = log.weightUpto(end)-log.weightUpto(middle);
		
		double len = 0 ;
		double diff = (end - start)/2;
		if(wtStart < wtEnd) {
			len =  getbalancePoint(start+ diff, end, log);
		}else if(wtStart > wtEnd) {
			len =  getbalancePoint(start, start+ diff, log);
		}else if(wtStart == wtEnd) {
			len = middle;
		}
		return len;
	}

	// DO NOT MODIFY CODE BELOW THIS LINE
	interface Log {
           double weightUpto(double x); // returns the weightUpto of the part of the log from the left end to a point at distance x from it.
           double length(); // returns the total length of the log
	}
	
	
	Map<String, List<Double>> map = new HashMap<>();

	public void putNewPrice(String symbol, double price) {
		synchronized (this) {
			if(map.get(symbol) == null) 
				map.put(symbol, new ArrayList<>());
			
			map.get(symbol).add(price);
		}
	}

	public double getAveragePrice(String symbol) {
		synchronized (this) {
			double sum = 0.0;
			for (Double d : map.get(symbol)) {
				sum += d;
			}
			return (sum/(map.get(symbol).size()));
		}
	}

	public int getTickCount(String symbol) {
	// YOUR CODE HERE
		return map.get(symbol).size();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
	/*	
		Problem p = new Problem();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				p.test();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				staticTest();
			}
		};
		Thread t3 = new Thread() {
			@Override
			public void run() {
				staticTest();
			}
		};
		
		

		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();*/
	}
/*
	public static synchronized void staticTest() {
		System.out.println("staticTest");
	}

	public synchronized void test() {
		System.out.println("test");
	}
*/
}
