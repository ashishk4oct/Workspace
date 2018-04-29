package com.problem.company.xyz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Essay {

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new FileReader("D:/Ashish/Learning/gitWorkspace/Workspace/HackerEarth/src/com/problem/company/xyz/essay.txt"))){
			
			HashMap<String,Set<Integer>> words = new HashMap<>();
			int count = 1;
			String line = reader.readLine();
			while(line.isEmpty())
				line = reader.readLine();
				
			boolean bool = false;
			while(line != null) {
				if(line.isEmpty()) {
					if(bool)
						count++;
					bool = false;
				}else {
					String[] word = line.split(" ");
					for (int i = 0; i < word.length; i++) {
						if(!words.containsKey(word[i]))
							words.put(word[i], new HashSet<>());
						
						words.get(word[i]).add(count);
					}
					bool = true;
				}
				line = 	reader.readLine();
			}
			
			
			for (String word : words.keySet()) {
				System.out.print(word+": ");
				for(Integer paraCount :words.get(word)) {
					System.out.print(paraCount+" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
