//Check if a binary tree is a binary search tree or not

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

	public boolean isBST(Node root){
		return isBST(root, null, null);

	}

	public boolean isBST(Node root, Integer min, Integer max){

		if(root == null)
			return true;

		if((min!=null && min > root.data) || (max!=null && max < root.data))
			return false;

		else
			return ( (isBST(root.leftchild, min, root.data)) && (isBST(root.rightchild, root.data, max)) );

	}
}

class CheckForBST{

	public static void main(String args[])throws IOException{

		//Commented part testing for a valid BST
		/*Node root = new Node(5);
		Tree obj = new Tree(root);

		obj.insert(3);
		obj.insert(8);
		obj.insert(9);
		obj.insert(2);
		obj.insert(1);
		obj.insert(4);
		obj.insert(6);*/

		// Now, testing for an invalid BST

		Node root = new Node(5);
		Tree obj = new Tree(root);

		obj.insert(5);
		obj.insert(1);
		obj.insert(4);

		Node wrongNode = new Node(6);
		root.leftchild.rightchild = wrongNode;

		boolean isBST = obj.isBST(root);
		if(isBST)
		System.out.println("Its BST");
		else
		System.out.println("Its not BST");

	}
}