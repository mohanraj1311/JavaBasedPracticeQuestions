/*

This pgm reverses a linked list recursively.


*/

import java.io.*;
import java.util.*;

class node{

	public int data;
	public node next;

	public node(int data){

		this.data = data;
		this.next = null;

	}

	public void displayNode(){
		System.out.println("The Node data : "+data);
	}
}


class linkedList{

	private node root;

	public linkedList(){

		root = null;
	}

	public boolean isEmpty(){
		return (root==null);
	}

	public void insertFirst(int data){
		node newNode = new node(data);
		newNode.next = root;
		root = newNode;
	}

	public node deleteFirst(){

		node tempNode = root;
		root = root.next;
		return tempNode;
	}

	public void printLinkedList(){

		node current = root;
		while(current!=null){
			current.displayNode();
			current = current.next;
		}

	}

	public void printReverseLinkedListRecursively(){
		node current = root;
		if(current!=null){
			root = current.next;
			printReverseLinkedListRecursively();
			current.displayNode();
		}

	}

	public void printReverseLinkedListIteratively(){

		Stack<node> newStack = new Stack<node>();
		node current = root;
		while(current!=null){
			newStack.push(current);
			current = current.next;
		}

		while(!newStack.empty()){
			node temp = newStack.pop();
			temp.displayNode();
		}
	}

}


class printlinkedlistTailtoHead{

	public static void main(String args[])throws IOException{

		linkedList theList = new linkedList();
		theList.insertFirst(1);
		theList.insertFirst(2);
		theList.insertFirst(3);
		//theList.printLinkedList();

		//node del = theList.deleteFirst();
		System.out.println("=======HEAD to TAIL========");
		//theList.printLinkedList();

		theList.insertFirst(4);
		theList.insertFirst(5);
		theList.printLinkedList();
		System.out.println("=======TAIL to HEAD Iteratively========");
		//theList.printReverseLinkedListRecursively();
		theList.printReverseLinkedListIteratively();
		System.out.println("=======TAIL to HEAD Recursively========");
		theList.printReverseLinkedListRecursively();



	}



}