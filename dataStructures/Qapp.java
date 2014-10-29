//package dataStructures;

import java.io.*;
//import dataStructures.stack.*;

class Node{
	int data;
	Node next;

	public Node(int data){
		this.data = data;
		this.next = null;
	}
}

class Queue{
	Node first, last;

	public void enqueue(int item){
		if(first==null){
			last = new Node(item);
			first = last;
		} else{
			last.next = new Node(item);
			last = last.next;
		}
	}

	public Node dequeue(){
		if(first!=null){
			Node item = first;
			first = first.next;
			return item;
		}

		return null;
	} 
}

public class Qapp{
	public static void main(String args[])throws IOException{
		Queue obj = new Queue();
		obj.enqueue(1);
		obj.enqueue(2);
		Node dequeuedEle = obj.dequeue();
		obj.enqueue(3);
		dequeuedEle = obj.dequeue();
		System.out.println("The deq element "+dequeuedEle.data);
	}
}

