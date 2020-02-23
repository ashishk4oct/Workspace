package com.codechef.beginner;

import java.util.Scanner;

public class BSTOperations {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt())
            return;

        int inputCount = in.nextInt();

        BST bst = new BST();
        for (int i = 0; i < inputCount; i++) {

            if (!in.hasNext())
                return;
            String operation = in.next();
            if (!in.hasNextInt())
                return;
            int data = in.nextInt();

            System.out.println(bst.performOperation(operation, data));


        }
        System.out.println(bst);
    }

}

class BST {
    Node root;


    public int performOperation(String operation, int data) {
        if (operation.equalsIgnoreCase("i")) {
            return insert(data);
        } else if (operation.equalsIgnoreCase("d")) {
            return delete(data);
        }
        return -1;
    }

    private int insert(int data) {
        if (null == root) {
            root = new Node(null, null, data);
            return 1;
        }

        Node node = root;
        int index = 1;
        while (true) {
            if (node.data > data) {
                index = 2 * index;
                if (null == node.left) {
                    node.left = new Node(null, null, data);
                    return index;
                } else {
                    node = node.left;
                }
            } else {
                index = 2 * index + 1;
                if (null == node.right) {
                    node.right = new Node(null, null, data);
                    return index;
                } else {
                    node = node.right;
                }
            }
        }
    }

    private int delete(int data) {
        if (null == root) {
            return -1;
        } else if (root.data == data) {
            root = deleteNode(root);
            return 1;
        }

        Node node = root;

        int index = 1;
        while (true) {
            if (node.data > data) {//node in left
                index = index * 2;
                if (node.left == null) {
                    return -1;
                }
                if (node.left.data == data) {
                    node.left = deleteNode(node.left);
                    return index;
                } else {
                    node = node.left;
                }
            } else { // node in right
                index = index * 2 + 1;
                if (node.right == null) {
                    return -1;
                }
                if (node.right.data == data) {
                    node.right = deleteNode(node.right);
                    return index;
                } else {
                    node = node.right;
                }
            }
        }
    }

    private Node deleteNode(Node node) {
        if (null == node.left && null == node.right)
            return null;
        if (null == node.left)
            return node.right;
        if (null == node.right)
            return node.left;
//
//        if(null == node.left.right){
//            node.left.right = node.right;
//            return node.left;
//        }

        if(null == node.right.left){
            node.right.left = node.left;
            return node.right;
        }


        Node temp = node.right;

        while(null != temp.left.left){
            temp = temp.left;
        }
        node.data = temp.left.data;
        temp.left = temp.left.right;

        return node;
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    Node() {
    }
}
//5
//i 1
//i 2
//i 0
//d 2
//i 3