package com.geeks.dp.tree;

public class ChildrenSumProperty {

    public static void main(String[] args) {

        Node node = SampleDataUtil.getSampleBinaryTree();
        System.out.println("Is sum tree: "+ checkChildrenSumProperty(node));

        node = SampleDataUtil.getSampleSumTree();
        System.out.println("Is sum tree: "+ checkChildrenSumProperty(node));

        node = SampleDataUtil.getSampleChildSumTree();
        System.out.println("Is sum tree: "+ checkChildrenSumProperty(node));
    }



    static boolean checkChildrenSumProperty(Node node) {
        if(null == node){
            return true;
        }

        if(!checkChildrenSumProperty(node.left))
            return false;
        if(!checkChildrenSumProperty(node.right))
            return false;

        int left = 0, right = 0;
        if(node.left != null){
            left = node.left.data;
        }

        if(node.right != null){
            right = node.right.data;
        }

        if(left == 0 && right == 0)
            return true;

        if(left+right == node.data){
            return true;
        }

        return false;

    }

}
