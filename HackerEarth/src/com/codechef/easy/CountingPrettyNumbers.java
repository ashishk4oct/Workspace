package com.codechef.easy;

import com.util.RandomUtil;import com.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingPrettyNumbers {


    public static void main1(String[] args) {
        for (int i = 0; i < 100; i++) {
            int arr [] = RandomUtil.generateRandom(2,1,10000,true);
            int c = solution(arr[0], arr[1]);
            int d = solution1(arr[0], arr[1]);
            System.out.println(c+" "+d+" "+(c==d));
        }
    }

    private static int solution1(int i, int j) {
        int count = 0;
        for (int k = i; k <= j ; k++) {
            if(checkPrettyNumber(k)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int tCount = Reader.readIntArr(reader)[0];
            while (tCount > 0){
                tCount--;
                int [] arr = Reader.readIntArr(reader);
                System.out.println(solution(arr[0], arr[1]));
            }
        }finally {
            if(null != reader)
                reader.close();
        }
    }

    private static int solution(int i, int j) {
        int count = 0;
        while(i%10 != 0 && i <= j){
            if(checkPrettyNumber(i)){
                count++;
            }
            i++;
        }
        while(j%10 != 0 && i <= j){
            if(checkPrettyNumber(j)){
                count++;
            }
            j--;
        }

        if(i <= j){
            int diff = (j - i)/10;
            count += diff*3;
        }

        return count;
    }

    private static boolean checkPrettyNumber(int i) {
        return i%10 == 2 || i%10 == 3 || i%10 == 9;
    }
}
