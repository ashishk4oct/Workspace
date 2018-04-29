package com.problem.company.xyz;

import java.util.ArrayList;
import java.util.List;


public class DAG {
	private List<Integer> adjacencyList [] ;
	private int zeroInDegree [];
	
	public DAG(int n) {
		adjacencyList = new ArrayList[n];
		zeroInDegree = new int[n];
	}

	public void addEdge(int p, int c) {
		zeroInDegree[c] = -1;
		if(adjacencyList[p] == null){
			adjacencyList[p] = new ArrayList<>();
		}
		adjacencyList[p].add(c);
	}
	
	public void printAllPathFromZeroInDegreeNode() {
	
		for (int i = 0; i < zeroInDegree.length; i++) {
			if(zeroInDegree[i] == 0) {
				printAllPath(adjacencyList[i],i+"");
			}
		}
	}
	
	private void printAllPath(List<Integer> list,String path) {

		if(list == null || list.isEmpty()) {
			System.out.println(path);
			return;
		}
		
		for (int i = 0; i < list.size() ; i++) {
			printAllPath(adjacencyList[(int) list.get(i)], path+"->"+(int) list.get(i));
		}
	}
}