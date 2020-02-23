package com.geeks.dp.tree;

import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {

        Node node = SampleDataUtil.getSampleBinaryTree();

        preOrderRecursion(node);
        System.out.println();
        preOrderStack(node);
        System.out.println();
        preOrder(node);

    }

    private static void preOrder(Node root) {
        if(null == root)
            return;

        Node pre, current = root;

        while(null != current){
            if(null == current.left){
                System.out.print(current.data+", ");
                current = current.right;
            }else{
                pre = current.left;
                while (null != pre.right && current != pre.right){
                    pre = pre.right;
                }

                if(null == pre.right){
                    pre.right = current;
                    System.out.print(current.data+", ");
                    current = current.left;
                }else{
                    pre.right = null;
                    current = current.right;
                }
            }
        }

    }

    private static void preOrderStack(Node node) {
        if (null == node)
            return;

        Stack<Node> stack = new Stack<>();
        pushLeftInStack(stack, node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            pushLeftInStack(stack, node.right);
        }

    }
    private static void pushLeftInStack(Stack<Node> stack, Node node) {
        while (null != node) {
            stack.push(node);
            System.out.print(node.data+", ");
            node = node.left;
        }
    }

    private static void preOrderRecursion(Node node) {

        if (null == node)
            return;
        System.out.print(node.data + ", ");
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);

    }
}
