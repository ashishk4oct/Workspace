package com.interview.clearwater;

import com.util.RandomUtil;
import com.util.Printer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
//        int[] arr = RandomUtil.generateRandom(10, 1, 15, false);
//        int sum = RandomUtil.generateRandom(1, 1, 20)[0];

        int arr[] = new int[]{9, 1, 5, 11, 2, 8, 4, 10, 3, 6};
        int sum = 39;

        Printer.print(arr);
        System.out.println(sum);


        int arrSum[] = new int[arr.length];
        arrSum[0] = Math.abs(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            arrSum[i] = arrSum[i - 1] + Math.abs(arr[i]);
        }
        System.out.println(arrSum[arr.length - 1]);
        System.out.println(arrSum[arr.length - 1] - sum);
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> ind = new LinkedList<>();
        q.add(sum);
        ind.add(arr.length - 1);
        while (!q.isEmpty()) {
            int s = q.poll();
            int i = ind.poll();
            if (i == 0) {
                if (arrSum[i] == Math.abs(s)) {
                    count++;
                }
                continue;
            }
            int x = s - arr[i];
            int y = s + arr[i];
            if (arrSum[i - 1] == Math.abs(x)) {
                count++;
            }
            if (arrSum[i - 1] == Math.abs(y)) {
                count++;
            }

            if (arrSum[i - 1] > Math.abs(x)) {
                q.add(x);
                ind.add(i - 1);
            }
            if (arrSum[i - 1] > Math.abs(y)) {
                q.add(y);
                ind.add(i - 1);
            }

        }
        System.out.println(count);
    }


    public static void left(int[] xyd) {
        if (xyd[2] == 0) {
            xyd[2] = 3;
        } else {
            xyd[2]--;
        }
    }

    public static void right(int[] xyd) {
        if (xyd[2] == 3) {
            xyd[2] = 0;
        } else {
            xyd[2]++;
        }
    }

    public static void move(int[] xyd) {
        switch (xyd[2]) {
            case 0:
                xyd[1]++;
                break;
            case 1:
                xyd[0]++;
                break;
            case 2:
                xyd[1]--;
                break;
            case 3:
                xyd[0]--;
                break;
        }
    }

}
