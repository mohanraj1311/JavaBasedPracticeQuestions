import java.io.*;
import java.util.*;

class Queue{

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public Queue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void enqueue(int elem){
		
		stack1.push(elem);
		
	}

	public int dequeue(){

		if(stack2.isEmpty()){

			if(!stack1.isEmpty()){

				while(!stack1.isEmpty()){
				int i = stack1.pop();
				stack2.push(i);
				}
			return stack2.pop();
			}
			else return -1;
		}
		else if(!stack2.isEmpty())
			return stack2.pop();
		else
			return -1;
	}
}


class QueueUsingStack{

	public static void main(String args[])throws IOException{
	Queue QueueObj = new Queue();
	QueueObj.enqueue(1);
	QueueObj.enqueue(2);
	QueueObj.enqueue(3);
	int dequeuedElem = QueueObj.dequeue();
	QueueObj.enqueue(4);
	QueueObj.enqueue(5);
	dequeuedElem = QueueObj.dequeue();
	dequeuedElem = QueueObj.dequeue();
	System.out.println("The dequeued element :"+dequeuedElem);
	}

}