package com.hackerrank.chalange3;

import java.io.IOException;
import java.util.Scanner;

public class KingdomConnectivity {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		String[] path = new String[M];

		for (int i = 0; i < M; i++) {
			int src = input.nextInt() - 1;
			int dest = input.nextInt() - 1;
			addPath(path, src, dest);
		}
		int v = findPossibleNoOfPath(path, ",0,", 0, N - 1);
		System.out.println((v == -1)?"INFINITE PATHS":v);
		input.close();
	}

	private static int findPossibleNoOfPath(String[] paths, String path, int lastNode, int dest) {
		if(path.equals(",0,,15,,13,,7,,10,,3,")) {
			System.out.println("ashish");
		}
		int count = 0;
		String nextNodes = paths[lastNode];
		if (nextNodes == null || nextNodes.length() == 0) {
			return 0;
		}
		String pathArr[] = nextNodes.split(",,");
			
		for (int j = 0; j < pathArr.length; j++) {
			String node = pathArr[j].replace(",", "");
			if (node.equals(dest+"")) {
				count++;
			} else {
				if (path.contains("," + node + ","))
					return -1;
				int val = findPossibleNoOfPath(paths, path + "," + node + ",", Integer.valueOf(node), dest);
				if (val == -1)
					return -1;
				count += val;
			}
		}
		return count;
	}

	private static void print(Object object) {
		System.out.println(object);
	}
	private static void print1(Object object) {
		System.out.print(object);
	}

	private static void addPath(String[] path, int src, int dest) {
		String pathJson = path[src];
		if (pathJson == null) {
			pathJson = new String("," + dest + ",");
		} else {
			pathJson += ("," + dest + ",");
		}
		path[src] = pathJson;
	}

}
