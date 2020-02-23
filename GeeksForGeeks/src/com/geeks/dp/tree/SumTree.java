package com.geeks.dp.tree;

public class SumTree {

    public static void main(String[] args) {

        Node node = SampleDataUtil.getSampleBinaryTree();
        System.out.println("Is sum tree: "+checkSumTree(node));

        node = SampleDataUtil.getSampleSumTree();
        System.out.println("Is sum tree: "+checkSumTree(node));
    }

    static boolean checkSumTree(Node node) {
       if(null == node){
           return false;
       }

       return findSumOfTree(node) < 0 ? false : true;
    }


    private static int findSumOfTree(Node node) {
        int left = 0 , right = 0;

        if(null != node.right)
            right = findSumOfTree(node.right);
        if(right < 0)
            return -1;

        if(null != node.left)
            left = findSumOfTree(node.left);
        if(left < 0)
            return -1;

        if(!(left == 0 && right == 0) && left+right != node.data)
            return -1;

        return left+right+node.data;
    }

}
