package com.geeks.dp.tree;

import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {

        Node node = SampleDataUtil.getSampleBinaryTree();

        postOrderRecursion(node);
        System.out.println();
        postOrderStack(node);
        System.out.println();
        postOrder(node);

    }

    private static void postOrder(Node root) {
        return;
    }

    private static void postOrderStack(Node node) {
        return;
    }

    private static void postOrderRecursion(Node node) {
        if (null == node)
            return;

        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.print(node.data + ", ");
    }

}
