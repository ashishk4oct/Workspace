package com.hackerrank.medium;

import java.math.BigInteger;
import java.util.Arrays;

public class JourneyToTheMoon {

    public static void main(String[] args) {
        int n = 100000 ;
        int ar[][] = new int[][]{
                {1, 2},
                {3, 4}
        };
        long v = journeyToMoon(n, ar);
        System.out.println(v);
        System.out.println(journeyToMoon1(n, ar).toString());
    }

    static int journeyToMoon(int n, int[][] astronaut) {

        int map[] = new int[n];
        int g = 1;
        for (int i = 0; i < astronaut.length; i++) {
            if (map[astronaut[i][0]] == 0 && map[astronaut[i][1]] == 0) {
                map[astronaut[i][0]] = g;
                map[astronaut[i][1]] = g;
                g++;
                continue;
            }
            int v = map[astronaut[i][0]] == 0 ? map[astronaut[i][1]] : map[astronaut[i][0]];
            map[astronaut[i][0]] = v;
            map[astronaut[i][1]] = v;
        }

        int groups[] = new int[g];
        for (int i = 0; i < map.length; i++) {
            int v = map[i];
            groups[v] = groups[v] + 1;
        }


        int ways = groups[0] * (n - groups[0]);

        for (int i = 1; i < groups.length; i++) {
            for (int j = i + 1; j < groups.length; j++) {
                ways += groups[i] * groups[j];
            }
        }
        int c = 0;
        for (int i = 1; i <= groups[0]; i++) {
            c += (i - 1);
        }
        ways += c;
        return ways;
    }


    static BigInteger journeyToMoon1(int n, int[][] astronaut) {

        Count map[] = new Count[n];
        int g = 1;
        for (int i = 0; i < astronaut.length; i++) {
            if (map[astronaut[i][0]] == null && map[astronaut[i][1]] == null) {
                Count count = new Count();
                count.v = g;
                map[astronaut[i][0]] = count;
                map[astronaut[i][1]] = count;
                g++;
                continue;
            } else if (map[astronaut[i][0]] == null || map[astronaut[i][1]] == null) {
                Count c = map[astronaut[i][0]] != null ? map[astronaut[i][0]] : map[astronaut[i][1]];
                map[astronaut[i][0]] = c;
                map[astronaut[i][1]] = c;
            } else if (map[astronaut[i][0]].v != map[astronaut[i][1]].v) {
                int min = map[astronaut[i][0]].v < map[astronaut[i][1]].v ? map[astronaut[i][0]].v : map[astronaut[i][1]].v;
                map[astronaut[i][0]].v = min;
                map[astronaut[i][1]].v = min;
            }

        }

        BigInteger groups[] = new BigInteger[g];
        Arrays.fill(groups, new BigInteger("0"));
        for (int i = 0; i < map.length; i++) {
            int v = map[i] == null ? 0 : map[i].v;
            groups[v] = groups[v].add(new BigInteger("1"));
        }


        BigInteger ways = new BigInteger("0");
        BigInteger r = new BigInteger(Integer.toString(n));
        for (int i = 1; i < groups.length; i++) {
            r = r.subtract(groups[i]) ;
            ways = ways.add(groups[i].multiply(r));
        }
        BigInteger c = r.multiply(r.subtract(new BigInteger("1"))).divide(new BigInteger("2"));
        ways = c.add(ways);
        return ways;
    }

    static class Count {
        int v;
    }
}
