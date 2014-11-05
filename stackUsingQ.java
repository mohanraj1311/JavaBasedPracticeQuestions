/*
Implement stack using Queues. keywords: use Queue inbuilt interface of JAVA

Basic algo:
Make the push operation more costly.
1. For push operation
	a. Enqueue the new element into Q2
	b. Dequeue Q1 until it becomes empty
	c. When Q1 is empty, swap Q1 and Q2.

2. For pop operation
	a. Dequue from Q1 always.
*/

import java.io.*;
import java.util.*;

class stackImplementationUsingQ{


	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	Queue<Integer> temp = new LinkedList<Integer>();


	public void push(int data){

		q2.add(data);
		while(!q1.isEmpty()){
			int popElement = q1.remove();
			q2.add(popElement);
		}

		temp = q2;
		q2 = q1;
		q1 = temp;

	}

	public int pop(){

		int popElement=0;
		if(!q1.isEmpty()){
			popElement = q1.remove();
		}
		return popElement;

	}
}

class stackUsingQ{

	public static void main(String args[])throws IOException{

		stackImplementationUsingQ obj = new stackImplementationUsingQ();
		obj.push(1);
		obj.push(2);
		obj.push(3);

		int popElement = obj.pop();
		System.out.println("Popped out : "+popElement);

		obj.push(4);
		popElement = obj.pop();
		System.out.println("Popped out : "+popElement);
		popElement = obj.pop();
		System.out.println("Popped out : "+popElement);

		obj.push(5);
		popElement = obj.pop();

		System.out.println("Popped out : "+popElement);




	}
}