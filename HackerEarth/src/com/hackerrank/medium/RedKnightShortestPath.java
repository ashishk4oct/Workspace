package com.hackerrank.medium;

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
