package com.leetcode.problems;

public class Candy {

    public static void main(String[] args) {
        Candy c = new Candy();
        System.out.println(c.candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(c.candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
    }

    public int candy(int[] r) {
        int s[] = new int[r.length];
        s[0] = 1;
        for (int i = 1; i < r.length; i++) {
            if (r[i - 1] < r[i]) {
                s[i] = s[i - 1] + 1;
            } else {
                s[i] = 1;
            }
        }

        int sum = s[r.length - 1];
        for (int i = r.length - 2; i >= 0; i--) {
            if (r[i + 1] < r[i]) {
                if (!(s[i + 1] < s[i])) {
                    s[i] = s[i + 1] + 1;
                }
            }
            sum += s[i];
        }

        return sum;
    }
}
