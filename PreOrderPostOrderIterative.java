/*
Implement the preorder and postorder tranversal iteratively.
Preorder Function begins at Line 72.
PostOrder at Line 107

It uses stack.
Algo:
	a. Create a stack
	b. Push the root node into the stack
	c. While the stack is not empty
		{
		pop a node
		print the data of the popped node
		if it has a right child push the right child
		if it has a left child push the left child
		}
*/

import java.io.*;
import java.util.*;

class Node{

	int data;
	Node leftchild;
	Node rightchild;

	public Node(int data){
		this.data = data;
		this.leftchild = null;
		this.rightchild = null;
	}

	public void printNode(){
		System.out.println(this.data);
	}
}

class Tree {


	Node root;

	public Tree(Node root){
		this.root = root;
	}

	public void insert(int data){

		Node newNode = new Node(data);

		if(root==null)
			root = newNode;

		else {

			Node current = root;
			Node parent;

			while(true){
				parent = current;

				if(data < current.data){
					current = current.leftchild;
					if(current==null){
						parent.leftchild = newNode;
						return;
					}

				}
				else {
					current = current.rightchild;
					if(current==null){
						parent.rightchild = newNode;
						return;
					}
				}

			}
		}

	}

	public void preOrderIterative(Node root){

		Stack<Node> stackx = new Stack<Node>();
		stackx.push(root);

		while(stackx.size()>0){
			Node curr = stackx.pop();
			curr.printNode();
			Node n = curr.rightchild;
			if(n!=null)
				stackx.push(n);
			n = curr.leftchild;
			if(n!=null)
				stackx.push(n);

		}
	}

	public void postOrderIterative(Node root){

		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		

		while(stack1.size() > 0){
			Node curr = stack1.peek();
			stack2.push(curr);
			stack1.pop();
			if(curr.leftchild!=null)
				stack1.push(curr.leftchild);
			if(curr.rightchild!=null)
				stack1.push(curr.rightchild);
		}
		while(stack2.size() > 0){
			Node curr = stack2.pop();
			curr.printNode();
		}
	}
}


class PreOrderPostOrderIterative{


	


	public static void main(String args[])throws IOException{

		Node root = new Node(3);
		Tree obj = new Tree(root);
		obj.insert(1);
		obj.insert(5);
		obj.insert(4);
		obj.insert(6);
		obj.insert(2);

		System.out.println("--PREORDER--");
		obj.preOrderIterative(root);
		System.out.println("--POSTORDER--");
		obj.postOrderIterative(root);



	}
}