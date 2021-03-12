package com.codechef.easy;

import com.util.RandomUtil;import com.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeliveryMan {
    public static void main(String[] args) {
        int n = 7;
        int a[] = RandomUtil.generateRandom(n, 1, 10);
        int b[] = RandomUtil.generateRandom(n, 1, 10);
        System.out.println(solution(a, b, n, 4, 4));
        Printer.print(a);
        Printer.print(b);
    }

    public static void main1(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().trim().split(" ");
        int n = Integer.parseInt(arr[0]);
        int x = Integer.parseInt(arr[1]);
        int y = Integer.parseInt(arr[2]);


        arr = reader.readLine().trim().split(" ");
        int xArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            xArr[i] = Integer.parseInt(arr[i]);
        }

        arr = reader.readLine().trim().split(" ");
        int yArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            yArr[i] = Integer.parseInt(arr[i]);
        }

        System.out.println(solution(xArr, yArr, n, x, y));
    }

    public static long solution(int[] xArr, int[] yArr, int n, int x, int y) {

        List<int[]> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new int[]{xArr[i], yArr[i]});
        }
        Collections.sort(list, (A, B) -> Math.abs(B[0] - B[1]) - Math.abs(A[0] - A[1]));

        int sum = 0;

        for (int i = 0; i < n; i++) {
            int ar[] = list.get(i);
            if (x == 0) {
                sum += ar[1];
                y--;
            } else if (y == 0) {
                sum += ar[0];
                x--;
            } else {
                if (ar[0] > ar[1]) {
                    sum += ar[0];
                    x--;
                } else {
                    sum += ar[1];
                    y--;
                }
            }
        }
        return sum;
    }
}
