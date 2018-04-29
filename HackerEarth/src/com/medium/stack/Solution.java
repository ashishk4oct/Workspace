package com.medium.stack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int equalStacks(int[] h1, int[] h2, int[] h3) {
        long height1 = 0,height2 = 0,height3 = 0;
        int top1 = 0,top2 = 0,top3 = 0;
        for(int i = 0; i<h1.length ;i++)
                height1 += h1[i];
        for(int i = 0; i<h2.length ;i++)
                height2 += h2[i];
        for(int i = 0; i<h3.length ;i++)
                height3 += h3[i];
        
        while(height1 != height2 || height2 != height3){
            if(height1>=height2 && height1>=height3){
                height1 -= h1[top1++];
            }else if(height2>=height1 && height2>=height3){
                height2 -= h2[top2++];
            }else{
                height3 -= h3[top3++];
            } 
            if(height1 <= 0 || height2 <= 0 || height3 <= 0 )
                return 0;
        }
        return (int)height1;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    	List<String> lines = Files.readAllLines(Paths.get("C:/Users/ashkumar/Desktop/input.txt"), StandardCharsets.UTF_8);
    	
        String[] n1N2N3 = lines.get(0).split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = lines.get(1).split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = lines.get(2).split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = lines.get(3).split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);
        
        System.out.println(result);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/
    }
}
