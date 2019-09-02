package com.leetcode.problems;

public class BinaryTreeMaximumPathSum {

    private int sum = Integer.MIN_VALUE;

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();

        TreeNode treeNode = new TreeNode(-3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        System.out.print(binaryTreeMaximumPathSum.maxPathSum(treeNode));

    }

    public int maxPathSum(TreeNode root) {
        this.sum = root.val;
        int sum = getMax(root);
        return sum > this.sum ? sum : this.sum;
    }

    private int getMax(TreeNode node){
        if(null == node){
            return Integer.MIN_VALUE;
        }

        int left = getMax(node.left);
        int right = getMax(node.right);

        if(left > 0 && right > 0){
            int sum = node.val + left + right;
            if(sum > this.sum){
                this.sum = sum;
            }
        }
        if(left > this.sum){
            this.sum = left;
        }
        if(right > this.sum){
            this.sum = right;
        }

        int max = left > right ? left : right;

        int parentVal = node.val;
        if(max > 0){
            parentVal += max;
        }
        return parentVal;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
