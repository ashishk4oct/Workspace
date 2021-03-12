package com.codechef.easy;

import com.util.RandomUtil;
import com.util.Printer;
import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Kamehameha {
    public static void main1(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int tCount = Reader.readIntArr(reader)[0];
            while (tCount > 0){
                tCount--;
                int indexes = Reader.readIntArr(reader)[0];
                int xy[][] = new int [indexes][2];
                while(indexes > 0){
                    indexes--;
                    xy[indexes] = Reader.readIntArr(reader);
                }
                int count = solution(xy);
                System.out.println(count);
            }
        }finally {
            if(null != reader)
                reader.close();
        }
    }

    public static void main(String[] args) {
        int xy [][] = new int [1000][2];
        for (int i = 0; i < 1000; i++) {
            xy[i] = RandomUtil.generateRandom(2,1,1000);
            Printer.print(xy[i]);
        }
        int count = solution(xy);
        System.out.println(count);
    }

    private static int solution(int[][] xy) {

        int count  = 0;
        int ct = 0;
        while(true){

            int xElementCount[] = findMax(xy,0);
            int yElementCount[] = findMax(xy,1);
            int k = xElementCount[1] > yElementCount[1] ? 0: 1;
            int elementCount[] = xElementCount[1] > yElementCount[1] ? xElementCount : yElementCount;

            if(elementCount[0] == -1){
                break;
            }
            count++;
            for (int i = 0; i < xy.length; i++) {
                if(xy[i][k] == elementCount[0]){
                    xy[i][0] = -1;
                    xy[i][1] = -1;
                    ct++;
                }
            }

        }
        System.out.println(ct);
        return count;
    }

    private static int[] findMax(int[][] xy, int i) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < xy.length; j++) {
            if(xy[j][i] == -1)
                continue;
            Integer count = map.get(xy[j][i]);
            if(null == count){
                count = 0;
            }
            map.put(xy[j][i],count+1);
        }
        if(map.size() == 0){
            return new int[]{-1,-1};
        }
        Integer max = 0;
        Integer element = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
                element = entry.getKey();
            }
        }
        return new int[]{element, max};
    }
}



