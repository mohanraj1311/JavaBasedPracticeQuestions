/*
The programs recursively counts the no. of Nodes in BST.
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



	int countNodesfn(Node root){
	if(root == null)
		return 0;
	else 
		return 1 + countNodesfn(root.leftchild) + countNodesfn(root.rightchild);
	}

}

class CountNodes{
	public static void main(String args[])throws IOException{
		Node root = new Node(1);

		Tree treeObj = new Tree(root);
		treeObj.insert(2);
		treeObj.insert(3);
		treeObj.insert(0);
		treeObj.insert(0);
		int c = treeObj.countNodesfn(root);
		System.out.println(c);
	}
}