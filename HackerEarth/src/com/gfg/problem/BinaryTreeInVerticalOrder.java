package com.gfg.problem;

import java.util.*;

public class BinaryTreeInVerticalOrder {

    private class Node{
        int v;
        Node l;
        Node r;

    }


    public static void main(String[] args) {
        BinaryTreeInVerticalOrder binaryTreeInVerticalOrder = new BinaryTreeInVerticalOrder();
        binaryTreeInVerticalOrder.execute();
    }

    private void execute() {
        Node root = getTree();

        TreeMap<Integer, List<Node>> treeMap = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> queuePosition = new LinkedList<>();

        queue.add(root);
        queuePosition.add(0);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            Integer pos = queuePosition.poll();
            if(node == null){
                continue;
            }

            List<Node> list = treeMap.get(pos);
            if(list == null){
                list = new LinkedList<>();
                treeMap.put(pos, list);
            }
            list.add(node);

            queue.add(node.l);
            queuePosition.add(pos-1);
            queue.add(node.r);
            queuePosition.add(pos+1);

        }

        for(Map.Entry<Integer, List<Node>> entry : treeMap.entrySet()){
            for(Node n : entry.getValue()){
                System.out.print(n.v+" ");
            }
            System.out.println();
        }

    }
    private Node getTree() {
        Node r = new BinaryTreeInVerticalOrder.Node();
        r.v = 1;
        r.l = new Node();
        r.r = new Node();

        r.l.v = 2;
        r.l.l = new Node();
        r.l.r = new Node();

        r.l.l.v = 4;
        r.l.r.v = 5;

        r.r.v = 3;
        r.r.l = new Node();
        r.r.r = new Node();

        r.r.l.v = 6;

        r.r.r.v = 7;
        r.r.r.l = new Node();
        r.r.r.r = new Node();

        r.r.r.l.v = 8;
        r.r.r.r.v = 9;


        return r;
    }
}
