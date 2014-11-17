/*Lowest ancestor finding in a BST.
The point to remember, the lowest common ancestor between 
two nodes has a special property.
Its the only node that is smaller than the one of the values and
greater than the other value.
In short, it lies between the two given input values.
For example, if the tree is below:

     5
   3    8
  2 4  6 9
 1

The lowest common ancestor of 1 and 4 is 3 which lies between 1 and 4 numerically. 

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


public Node findLowestAncestor(Node root,int val1, int val2){

	if(root == null)
		return null;

	else if((root.data < val1) && (root.data < val2))
		return findLowestAncestor(root.rightchild, val1, val2);

	else if((root.data > val1) && (root.data > val2))
		return findLowestAncestor(root.leftchild, val1, val2);

	else
		return root;
}


}

class LowestAncestor{

	public static void main(String args[])throws IOException{

		Node root = new Node(5);
		Tree obj = new Tree(root);

		obj.insert(3);
		obj.insert(8);
		obj.insert(9);
		obj.insert(2);
		obj.insert(1);
		obj.insert(4);
		obj.insert(6);

		Node ancestor = obj.findLowestAncestor(root,1,9);
		System.out.println("The common ancestor: "+ancestor.data);

	}
}