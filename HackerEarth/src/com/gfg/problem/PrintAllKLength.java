package com.gfg.problem;

public class PrintAllKLength {
    public static void main(String[] args) {

        char arr [] = new char[]{'a','b','c','d'};
        printAllWithLen(4, arr);

    }
    static int count = 0;
    private static void printAllWithLen(int len, char arr[]) {
        if( len == 0 || arr == null || arr.length == 0){
            return;
        }

        int indexArr [] = new int[len];

        int i = len-1;
        while(true){
            if(i == -1){
                break;
            }

            if(i == len-1){
                print(arr, indexArr);
            }

            if(indexArr[i] == arr.length - 1){
                indexArr[i] = 0;
                i--;
            }else {
                indexArr[i] = indexArr[i]+1;
                i = indexArr.length -1;
            }
        }
    }

    private static void print(char[] arr, int[] indexArr) {
        String s = "";
        for (int i : indexArr){
            s += arr[i];
        }
        System.out.println(++count+". "+s);
    }
}
