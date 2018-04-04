package com.gfg.problem;

public class Add1_to_a_number_represented_as_linked_list {

	public static void main(String[] args) {
		Node head = new Node(9);
	    head.next = new Node(9);
	    head.next.next = new Node(9);
	    head.next.next.next = new Node(8);
	 
	    System.out.println("List is ");
	    printList(head);
	 
	    head = addOne(head);
	    System.out.println("\nResultant list is ");
	    printList(head);
		 
	    head = addOneReversionList(head);
	    System.out.println("\nResultant list is ");
	    printList(head);
	}

	private static Node addOneReversionList(Node head) {
		head = reverseLinkedList(head);
		Node node = head;
		
		int add = 1;
		while(null != node) {
			node.data += add;
			
			if(node.data > 9) {
				add = 1;
				node.data = 0;
			}else {
				add = 0;
			}
			
			node = node.next;
		}
		
		head = reverseLinkedList(head);
		if(add == 1) {
			Node n = new Node(1);
			n.next = head ;
			head = n ;
		}
			
			
		return head ;
	}

	private static Node reverseLinkedList(Node head) {
		if(head == null || head.next == null)
			return head;
		
		return rever(head , null);
	}

	private static Node rever(Node current, Node previous) {
		Node next = current.next;
		
		current.next = previous;
		
		return (next == null) ? current : rever(next, current);
	}

	private static Node addOne(Node node) {
		if(node == null)
			return null;
		if(addOneToList(node) == 1) {
			Node n = new Node(1);
			n.next = node;
			node = n;
		}
		return node;
	}

	private static int addOneToList(Node node) {
		if(node.next == null) {
			node.data += 1;
		}else {
			node.data += addOneToList(node.next);
		}
		if(node.data > 9) { 
			node.data = 0;
			return 1;
		}else {
			return 0;
		}
	}

	private static void printList(Node node) {

		while(null != node){
			System.out.print(node.data+" ");
			node = node.next;
		}
	}

	static class Node{

		public Node(int data) {
			this.data = data ;
		}

		public int data;
		public Node next;
		
	}
}
