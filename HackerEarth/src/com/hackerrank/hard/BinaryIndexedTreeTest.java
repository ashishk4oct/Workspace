package com.hackerrank.hard;

public class BinaryIndexedTreeTest {

    public static void main(String[] args) {
        int arr[]  = new int[]{5, 6, 4, 20, 6, 9};
        BinaryIndexedTree bit = new BinaryIndexedTree(arr);
        printArray(bit);

        System.out.println(bit.sum(1,3)+" "+30);
        bit.update(3,10);
        System.out.println(bit.sum(1,3)+" "+20);
        bit.update(5,10);
        System.out.println(bit.sum(0,bit.length()-1)+" "+41);
        printArray(bit);
    }

    private static void printArray(BinaryIndexedTree bit){
        for (int i = 0; i < bit.length() ; i++) {
            System.out.println((i+1)+"> "+bit.numberAt(i));
        }
    }
}
