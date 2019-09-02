package com.leetcode.problems;

import java.util.List;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);


        ListNode t = listNode;
        while(null != t){
            System.out.printf("%d ",t.val);
            t = t.next;
        }

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode l = reverseNodesInKGroup.reverseKGroup(listNode, 5);

        System.out.println();

        while(null != l){
            System.out.printf("%d ",l.val);
            l = l.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if( k<2 )
            return head;

        ListNode reversedList = reverseList(head);
        int count = listSize(reversedList);
        int extra = count%k;

        ListNode s, e, p = reversedList;

        for (int i = 1; i < extra ; i++) {
            p = p.next;
        }

        if(extra > 0){
            e = s = p.next;
            p.next = null;
            head = reverseList(reversedList);
        }else{
            e = s = p;
            p = null;
        }
        while(null != s){
            for (int i = 1; i < k ; i++) {
                s= s.next;
            }
            ListNode t = s.next;
            s.next = p;
            p = e;
            e = s = t;
        }
        return p;
    }

    private ListNode reverseList(ListNode head){
        if(null == head || null == head.next)
            return head;

        ListNode current = head, previous = null, next;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private int listSize(ListNode listNode){
        int count = 0;
        while (null != listNode){
            count++;
            listNode = listNode.next;
        }
        return count;
    }


}
