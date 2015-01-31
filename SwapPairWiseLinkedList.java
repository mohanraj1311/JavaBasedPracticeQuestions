// Reverse the nodes of a linked list pairwise
import java.io.*;
import java.util.*;


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      public void appendToTail(int d){
		ListNode end = new ListNode(d);
		ListNode n = this;
		while(n.next!= null){
			n = n.next;
		}
		n.next = end;
	}

	public void printNode(){
		System.out.println("The node data "+this.val);
	}
  }

class SwapPairWiseLinkedList{

	public static ListNode swapPairs(ListNode head){
		
		ListNode first = head;
		if(first == null)
			return head;
		
		ListNode second = first.next;
		if(second == null)
			return head;
		
		ListNode third = second.next;
		if (third == null){
			second.next = first;
			first.next = null;
			head = second;
			return head;
		}

		else if(third!=null){

			ListNode curr1 = head,temp;
			
			ListNode curr2 = curr1.next;
			ListNode curr3 = curr2.next;

			curr2.next = curr1;
			curr1.next = curr3;
			temp = curr1;

			ListNode newHead=curr2;
			curr1 = curr3;
			
			



			while(curr1!=null && curr1.next!=null){

			curr2 = curr1.next;
			curr3 = curr2.next;

			curr2.next = curr1;
			curr1.next = curr3;
			temp.next = curr2;

			temp = curr1;

			curr1 = curr3;
			


			}

			return newHead;
				
			}
			
		
		
		return head;
	}
		


	

	public static void printLinkedList(ListNode head){
		ListNode n = head;
		while(n != null){
			n.printNode();
			n = n.next;
		}
	}

	public static void main(String args[]) throws IOException{

		ListNode head = new ListNode(1);

		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		//head.appendToTail(7);
		//printLinkedList(head);
		ListNode head2 = swapPairs(head);

		printLinkedList(head2);


	}
}
 
