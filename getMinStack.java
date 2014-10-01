/*
Implement stack operation getMin() in O(1). 
No extra data structures to be used other than stack.

We maintain two stacks - originalStack (which will contain the original elements)
					   - minimumStack (which will stores values which were ever minimum) 
Additionally the top element in the minimumStack will always point to the minimum element 
at that point of time.
*/

import java.io.*;
import java.util.*;

class minStack extends Stack<Integer>{

	Stack<Integer> originalStack;
	Stack<Integer> minimumStack;

	public minStack(){
		minimumStack = new Stack<Integer>();
		originalStack = new Stack<Integer>();
	}

	public void push(int value){

		originalStack.push(value);
		if(value <= min()){
			minimumStack.push(value);
		}
		
	}

	public Integer pop(){
		int value = originalStack.pop();
		if(value==min())
			minimumStack.pop();
		return value;
	}

	public int min(){
		if(minimumStack.isEmpty()){
			return Integer.MAX_VALUE; // Very important step. Used only at the beginning.
		} else {
			return minimumStack.peek();
		}
	}

}


class getMinStack {

	public static void main(String args[])throws IOException{

		minStack minStackObj = new minStack();
		minStackObj.push(13);
		minStackObj.push(20);
		minStackObj.push(10);
		minStackObj.push(11);
		minStackObj.push(22);

		int popElement = minStackObj.pop();
		int popElement2 = minStackObj.pop();

		System.out.println("1st Element poped out : "+popElement);
		System.out.println("2nd Element poped out : "+popElement2);

		int minElement = minStackObj.min();
		System.out.println("Minimum element : "+minElement);



	}
}
