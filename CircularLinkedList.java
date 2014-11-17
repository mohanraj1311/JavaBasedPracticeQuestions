/* This program check if the linked list is circular
and also returns the point of intersection
*/

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

	public boolean isCircular(Node head){

		boolean isCircular = false;
		if(head.next==null)
			return false;

		Node slow = head;
		Node fast = head;

		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast){
				isCircular = true;
				break;

			}
				
		}

		if(fast == null || fast.next == null)
			return false;
	
		return isCircular;
	
	}

	public Node findStartOfLoop(Node head){

		Node slow = head;
		Node fast = head;

		while(fast!=null && fast.next!=null){

			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}

		if(fast == null || fast.next == null)
			return null;

		slow = head;
		while(slow!=fast)
		{
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}
	
}

class CircularLinkedList{

	public static void main(String args[])throws IOException{

		Node head = new Node(1);
		head.insertNode(head,2);
		head.insertNode(head,3);
		head.insertNode(head,4);
		head.insertNode(head,5);
		head.insertNode(head,6);
		head.insertNode(head,7);
		head.insertNode(head,8);
		head.insertNode(head,9);
		//Begin: Create circular linkedList such that 9 points to 4
		Node current = head;
		while(current.next!=null)
			current = current.next;
		current.next = head.next.next.next;
		//End: Create circular linkedList such that 9 points to 4

		LinkedList linkedObj = new LinkedList();
		if(linkedObj.isCircular(head))
			System.out.println("Circular");
		else
			System.out.println("Not Circular");

		Node startOfLoopNode = linkedObj.findStartOfLoop(head);
		System.out.println("The loop starts at "+startOfLoopNode.data); 

	}
}