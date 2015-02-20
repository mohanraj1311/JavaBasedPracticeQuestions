/*
In this program we clone a linkedList with a next pointer & random pointer.
*/

import java.io.*;
import java.util.*;

class RandomNode{
	int data;
	RandomNode next;
	RandomNode randomPointer;
	RandomNode(int data){
		this.data = data;
		this.next = null;
		this.randomPointer = null;

	}

	public void appendToTail(int d){
		RandomNode end = new RandomNode(d);
		RandomNode n = this;
		while(n.next!= null){
			n = n.next;
		}
		n.next = end;
	}

	public void connectrandomly(RandomNode head,int x, int y){
		RandomNode node1 = find(head,x);
		RandomNode node2 = find(head,y);
		node1.randomPointer = node2;
	}

	public RandomNode find(RandomNode head,int x){
		RandomNode curr = head;
		while(curr!=null){
			if(curr.data==x)
				return curr;
			else
				curr = curr.next;
		}
		return null;

	}

	public RandomNode clone(RandomNode head){
		HashMap<RandomNode, RandomNode> myMap = new HashMap<RandomNode, RandomNode>();
		RandomNode x = head;
		while(x!=null){
			RandomNode y = new RandomNode(x.data);
			myMap.put(x,y);
			x = x.next;
		}

		x = head;
		while(x!=null){
			RandomNode y = myMap.get(x);
			y.next = myMap.get(x.next);
			y.randomPointer = x.randomPointer;
			x = x.next;
		}
		return myMap.get(head);
	}

	public void printLinkedList(RandomNode head){
		RandomNode curr = head;
		while(curr!=null){
			System.out.print(curr.data+"->");
			if(curr.randomPointer!=null)
				System.out.print(" "+curr.data+" has a random pointer to "+curr.randomPointer.data+" ");
		curr = curr.next;
		}
	}

}





class RandomPointerLinkedListCloning{

	

	public static void main(String args[])throws IOException{
		RandomNode head = new RandomNode(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		
		head.connectrandomly(head,3,6);
		System.out.println("----ORIGINAL linkedList-----");
		head.printLinkedList(head);
		System.out.println("");
		RandomNode newHead = head.clone(head);
		System.out.println("----CLONED linkedList-------");
		head.printLinkedList(newHead);
		System.out.println("");

	}
}

/*
SAMPLE OUTPUT 

----ORIGINAL linkedList
1->2->3-> 3 has a random pointer to 6 4->5->6->
----CLONED linkedList
1->2->3-> 3 has a random pointer to 6 4->5->6->
*/