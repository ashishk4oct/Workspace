package com.hackerrank.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RedKnightShortestPath {

    public static void main(String[] args) {
        printShortestPath(7,6,0,6,1);
    }
    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int i_end, int j_start, int j_end)     {
        if(i_start%2 != j_start%2){
            System.out.println("Impossible");
            return;
        }
        if(!((i_end%2 == j_end%2 && i_start%4 == j_start%4)||(i_end%2 != j_end%2 && (i_start+2)%4 == j_start%4))){
            System.out.println("Impossible");
            return;
        }

        moveToDesitination(n, i_start, j_start, i_end, j_end);

    }

    private static void moveToDesitination(int n, int i_start, int j_start, int i_end, int j_end) {
        String path = "";
        int count = 0;
        while(i_start > j_start && i_end > j_end){
            count++;
            path += "UL ";
            i_start -= 2;
            i_end -= 1;
        }
        while(i_start > j_start && i_end < j_end){
            count++;
            path += "UR ";
            i_start -= 2;
            i_end += 1;
        }
        while(i_start < j_start && i_end > j_end){
            count++;
            path += "LL ";
            i_start += 2;
            i_end -= 1;
        }
        while(i_start < j_start && i_end < j_end){
            count++;
            path += "LR ";
            i_start += 2;
            i_end += 1;
        }

        while(i_start == j_start && i_end < j_end){
            count++;
            path += "R ";
            i_end += 2;
        }
        while(i_start == j_start && i_end > j_end){
            count++;
            path += "L ";
            i_end -= 2;
        }


        while(i_start < j_start && i_end == j_end){
            if(i_end == n-1){
                path += "LL LR ";
            }else{
                path += "LR LL ";
            }
            count++;
            count++;
            i_start += 4;
        }
        while(i_start < j_start && i_end == j_end){
            if(i_end == n-1){
                path += "UL UR ";
            }else{
                path += "UR UL ";
            }
            count++;
            count++;
            i_start -= 4;
        }


        System.out.println(count);
        System.out.println(path);

    }
}

class NewRedKnightShortestPath{
    public static void main(String[] args) {
        printShortestPath(70, 7, 15, 67, 3);
    }


    static void printShortestPath(int n, int is, int ie, int js, int je)     {
        if(impossible(is,ie,js,je)){
            System.out.println("Impossible");
            return;
        }

        int m [][] = new int[n][n];

        int t[][][] = new int [n][n][2];
        Queue<Integer> q = new LinkedList<>();
        q.add(is);
        q.add(ie);
        while(!q.isEmpty()){
            int x = q.poll(), y = q.poll();

            addToQueue(x-2 ,y-1, x, y, q, m , is, ie, t);
            addToQueue(x-2 ,y+1, x, y, q, m , is, ie, t);
            addToQueue(x     ,y+2, x, y, q, m , is, ie, t);
            addToQueue(x+2 ,y+1, x, y, q, m , is, ie, t);
            addToQueue(x+2 ,y-1, x, y, q, m , is, ie, t);
            addToQueue(x     ,y-2, x, y, q, m , is, ie, t);


            if(m[js][je] != 0){
                break;
            }
        }
//        print(m);
//        print(t);
        System.out.println(m[js][je]);


        int x = js,y = je;
        StringBuilder result = new StringBuilder();

        while(x != is || y != ie){
            int a = t[x][y][0];
            int b = t[x][y][1];
            result = result.insert(0, actionName(a, b, x, y)+" ");
            x = a;
            y = b;
        }
        System.out.println(result);

    }

    private static String actionName(int a, int b, int x, int y) {
        String s = "";

        if(a > x){
            s += "U";
        }else if(a < x){
            s += "L";
        }
        if(b > y){
            s += "L";
        }else if(b < y){
            s += "R";
        }

        return s;
    }

    private static void addToQueue(int i, int j, int x, int y, Queue<Integer> q, int[][] m,int is, int ie, int [][][] t)   {
        if(!inMetrix(i,j,m.length)){
            return;
        }
        if(i == is && j == ie){
            return;
        }
//        System.out.println(i+","+j +" "+ x+","+y);
//        print(m);
        if( m[i][j] == 0 || m[i][j] > m[x][y]+1){
            m[i][j] =  m[x][y]+1;
            t[i][j][0] = x;
            t[i][j][1] = y;
            q.add(i);
            q.add(j);
        }
    }

    private static boolean inMetrix(int i, int j, int n) {
        return (i < n && i >= 0 && j < n && j >= 0);
    }

    private static void print(int m[][]){
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m.length ; j++) {
                System.out.printf(" %2d |",m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void print(int m[][][]){
        for (int i = 0; i < m.length ; i++) {
            for (int j = 0; j < m.length ; j++) {
                System.out.printf(" %2d %2d |",m[i][j][0],m[i][j][1]);
            }
            System.out.println();
        }
        System.out.println();
    }


    private static boolean impossible(int is, int ie, int js, int je) {
        int v = is > js ? is-js : js-is;

        if(v%2 != 0){
            return true;
        }

        int x = ie > je ? ie-je : je-ie;

        v = v/2;
        if(v%2 == 1){
            x++;
        }

        if(x%2 == 0){
            return false;
        }
        return true;
    }
}
