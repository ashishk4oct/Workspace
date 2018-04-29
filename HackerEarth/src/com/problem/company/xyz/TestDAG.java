package com.problem.company.xyz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestDAG {
	
	public static void main(String[] args) {
		
		try (BufferedReader reader = new BufferedReader(new FileReader("D:/Ashish/Learning/gitWorkspace/Workspace/HackerEarth/src/com/problem/company/xyz/input.txt"))){
		
			int N = Integer.parseInt(reader.readLine().trim());
			
			DAG dag = new DAG(N);
			
			String line = reader.readLine();
			while(line != null) {
				if(!line.isEmpty()) {
					String[] edge = line.split(",");
					dag.addEdge(Integer.parseInt(edge[0].trim()),Integer.parseInt(edge[1].trim()));
				}
				line = 	reader.readLine();
			}
			
			dag.printAllPathFromZeroInDegreeNode();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
