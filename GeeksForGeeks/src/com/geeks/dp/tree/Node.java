package com.geeks.dp.tree;

public class Node{
    protected Node left;
    protected Node right;
    protected int data;

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getData() {
        return data;
    }

    @Override
    public String toString() {
        return data + "";
    }
}