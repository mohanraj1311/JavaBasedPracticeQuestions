/*
This program implements binary search tree
*/

import java.io.*;


class Node{

	int data;
	Node leftchild;
	Node rightchild;

	public Node(int data){
		this.data = data;
		this.leftchild = null;
		this.rightchild = null;
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

	public void inOrder(Node localroot){
		if (localroot!=null) {
			inOrder(localroot.leftchild);
			System.out.print(localroot.data);
			inOrder(localroot.rightchild);
			
		}
	}

	public Node find(int key){
		Node current = root;
		while(current.data!=key){
			if(key < current.data)
				current = current.leftchild;
			else
				current = current.rightchild;
			if(current == null)
				return null;
		}
		return current;
	}

	public boolean delete(int key){
		return true;
	}
}

public class BST{

	public static void main(String args[])throws IOException{

		Node root = new Node(1);
		Tree obj = new Tree(root);

		obj.insert(2);
		obj.insert(5);
		obj.insert(3);
		obj.inOrder(root);
	}

}