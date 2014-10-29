

import java.io.*;
import java.util.*;

/*
This program implements linkedList
*/

class Node{

	int data;
	Node next = null;

	public Node(int d){
		data = d;
	}

	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while(n.next!= null){
			n = n.next;
		}
		n.next = end;
	}

	public void printNode(){
		System.out.println("The node data "+this.data);
	}

	public Node deleteNode(Node head, int d){
		Node n =head;

		if(head.data == d){
			head = head.next;
			return head;
		}

		else{
			while(n.next!=null){
				if(n.next.data==d){
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
		}
		
		return head;
	}
}

public class LinkedList{

	public static void printLinkedList(Node head){
		Node n = head;
		while(n != null){
			n.printNode();
			n = n.next;
		}
	}
	public static void main(String args[])throws IOException{
		Node head = new Node(1);

		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		printLinkedList(head);
		head = head.deleteNode(head, 2);
		printLinkedList(head);

	}
}
