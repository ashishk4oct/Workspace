package com.hackerrank.hard;

public class BinaryIndexedTree {

    private int[] arr;

    public BinaryIndexedTree(int arr[]) {
        this.arr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            add(i + 1, arr[i]);
        }
    }

    private int sum(int r) {
        int result = 0;
        while (r > 0) {
            result += arr[r];
            r -= (r & -r);
        }
        return result;
    }

    private void add(int i, int num) {
        while (i < arr.length) {
            arr[i] += num;
            i += (i & -i);
        }
    }


    public int length(){
        return this.arr.length-1;
    }

    public void update(int i, int num) {
        int n = numberAt(i)-num;
        add(i+1,-n);
    }

    public int numberAt(int index) {
        return sum(index + 1) - sum(index);
    }

    public int sum(int l, int r) {
        return sum(r + 1) - sum(l);
    }
}
