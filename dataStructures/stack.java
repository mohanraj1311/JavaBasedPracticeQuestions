package dataStructures;

import java.io.*;
import java.util.*;

/*
This program implemets stack

*/
class Node{

	int data;
	Node next;

	public Node(int data){

		this.data = data;
		this.next = null;
	}
}


class StackNode {

Node top;

public Node pop(){
	if(top!=null){
		Node popElement = top;
		top = top.next;
		return popElement;
	}
	return null;
}


public void push(int data){
	Node pushedElement = new Node(data);
	pushedElement.next = top;
	top = pushedElement;

}

public Object peek(){

	if(!isEmpty())
		return top.data;
	else
		return null;
	
}

public boolean isEmpty(){
	if(top==null)
		return true;
	else
		return false;
}

}

public class stack {
	public static void main(String args[])throws IOException{
		StackNode obj = new StackNode();
		
		obj.push(1);
		obj.push(2);
		obj.pop();
		obj.push(5);

		System.out.println("The top element : "+obj.peek());

	}
}
