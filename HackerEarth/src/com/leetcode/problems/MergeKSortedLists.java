package com.leetcode.problems;

import java.util.List;

public class MergeKSortedLists {
    public static void main(String[] args) {

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(22);

        ListNode listNode1 = new ListNode(10);
        listNode1.next = new ListNode(20);
        listNode1.next.next = new ListNode(21);

        ListNode [] listNodes = {listNode, null ,listNode1 , new ListNode(5)};

        ListNode l = mergeKSortedLists.mergeKLists(listNodes);
        while(l != null){
            System.out.printf("%d ",l.val);
            l = l.next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0){
            return null;
        }
        while(len > 1){
            ListNode[] listNodes = new ListNode[getLenBy2(len)];
            for (int i = 0; i < listNodes.length; i++) {
                listNodes[i] = ((2*i)+2 <= len) ? mergeList(lists[2*i], lists[(2*i)+1]) : lists[2*i];
            }
            lists = listNodes;
            len = lists.length;
        }
        return lists[0];
    }

    private int getLenBy2(int len) {
        if(len <= 0)
            return 0;

        return len%2 == 0 ? len/2 : (len/2)+1;
    }

    private ListNode mergeList(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode newNode = new ListNode(0);
        ListNode pointerNode = newNode;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pointerNode.next = l1;
                l1 = l1.next;
                pointerNode.next.next = null;
            }else{
                pointerNode.next = l2;
                l2 = l2.next;
                pointerNode.next.next = null;
            }
            pointerNode = pointerNode.next;
        }
        if(l1 != null){
            pointerNode.next = l1;
        }else if(l2 != null){
            pointerNode.next = l2;
        }

        return newNode.next;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
