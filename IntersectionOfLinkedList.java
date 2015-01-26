import java.io.*;

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

  class IntersectionOfLinkedList{

  	public static ListNode IntersectionOfLinkedList(ListNode headA, ListNode headB){

  		if(null == headA || null == headB) return null;
  		if(headA==headB) return headA;
        int lenA = getlength(headA);
        int lenB = getlength(headB);
        int d = lenA - lenB;
        if(d<0) d=(-1)*d;
                if(d==1){
            if(lenA > lenB){
                if(headA.next==headB)
                    return headB;
            }
            if(lenA < lenB){
                if(headB.next==headA)
                    return headA;
            }
        }
        if(lenA > lenB)
            return _getIntersectionNode(headA, headB, d);
        else if(lenB > lenA)
            return _getIntersectionNode(headB, headA, d);
        else
            return _getIntersectionNode(headA, headB, d);



  	}

  	public static int getlength(ListNode head){
        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }

  public static ListNode _getIntersectionNode(ListNode headA, ListNode headB, int d){
        int i;
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        ListNode tempHeadA = headA;
        for(i = 0 ; i < d ; i++){
            
            curr1 = curr1.next;
        }
        
        while(curr1!=null && curr2!=null){
            
            if(curr1==curr2)
                return curr2;
            curr1= curr1.next;
            curr2 = curr2.next;
        }
        return null;
    }

public static void main(String args[])throws IOException{
	ListNode headA = new ListNode(1);
	headA.appendToTail(3);
	headA.appendToTail(5);
	headA.appendToTail(7);
	headA.appendToTail(9);
	ListNode headB = headA.next.next;
	ListNode intersectingNode = IntersectionOfLinkedList(headA, headB);
	System.out.println("The intersecting node:"+intersectingNode.val);


}

}