// program to reverse a linked list iteratively


import java.io.*;
import java.util.*;

class Node{

	int data;
	Node next;

	public Node(int data){

		this.data = data;
		this.next = null;
	}

	public void insertNode(Node head, int data){

		Node first = head;
		Node current = first;

		while(current.next!=null){
			current = current.next;
		}

		current.next = new Node(data);

	}
}

class LinkedList{

	public void printLinkedList(Node head){
		Node first = head;
		Node current = first;

		while(current!= null){
			System.out.println(current.data);
			current = current.next;
		}
	
	}

	public Node reverseLinkedList(Node head){

		Node first = head;
		Node second = first.next;
		Node third = second.next;

		if(head.next==null)
			return head;

		second.next = first;
		first.next = null;

		if(third==null){
			return second;
		}

		Node currentNode = third;
		Node previousNode = second;


		while(currentNode!=null){
			Node nextNode = currentNode.next;
			currentNode.next = previousNode;

			previousNode = currentNode;
			currentNode = nextNode;

		}
		return previousNode;
	}
}

class reverseLinkedList{

	public static void main(String args[])throws IOException{

		Node head = new Node(1);
		LinkedList LinkedListObj = new LinkedList();
		head.insertNode(head,2);
		head.insertNode(head,3);
		head.insertNode(head,4);
		System.out.println("--Before reverse--");
		LinkedListObj.printLinkedList(head);
		//System.out.println(head.data);

		Node afterReverseHead = LinkedListObj.reverseLinkedList(head);
		System.out.println("--After reverse--");
		LinkedListObj.printLinkedList(afterReverseHead);
	}
}