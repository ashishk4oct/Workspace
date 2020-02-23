package com.geeks.dp.tree;

public class SampleDataUtil {

    public static Node getSampleBinaryTree() {
        return new Node(new Node(new Node(new Node(1), new Node(new Node(7), null, 8), 4), null, 12), new Node(new Node(16), new Node(new Node(50), new Node(100), 61), 31), 15);
    }


    public static Node getSampleSumTree() {
        return new Node(new Node(new Node(new Node(new Node(1), new Node(2),3),new Node(4),10), new Node(1),21), new Node(null, new Node(new Node(new Node(1),null, 1),new Node(2),4),8), 58);
    }

    public static Node getSampleChildSumTree() {
        return new Node(new Node(new Node(new Node(new Node(4), new Node(12),16),new Node(4),20), new Node(10),30), new Node(null, new Node(new Node(new Node(8),null, 8),new Node(20),28),28), 58);
    }


}
