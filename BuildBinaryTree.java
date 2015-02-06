/*
Microsoft coding competition Q.

Input : Inorder and Postorder string.
Output : BFS of the binary tree which has the above Inorder and Postorder.


4,2,7,5,8,1,3,9,6,11,10 - Inorder 
4,7,8,5,2,9,11,10,6,3,1 - PostOrder

1,2,3,4,5,6,7,8,9,10,11, - BFS level order

Technique: 

Last node of PostOrder traversal is root
After finding the root in inorder , recurse such that the left forms the 
left subtree and right forms the right subtree

For BFS , its level order tranversal, use a Q!

*/


import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class BuildBinaryTree {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        
        int	inEnd = inorder.length-1;
        
        int postStart = 0;
        
        int	postEnd = postorder.length-1;
        
 
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
	public void LevelOrder(TreeNode root){
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			TreeNode temp = q.poll();
			System.out.print(temp.val+",");
			if(temp.left!=null)
				q.add(temp.left);
			if(temp.right!=null)
				q.add(temp.right);
			
		}
		
	}
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
    		if(inStart > inEnd || postStart > postEnd)
    				return null;

    			int rootValue = postorder[postEnd];
    			TreeNode root = new TreeNode(rootValue);

    			int k=0;
    			for(int i=0; i< inorder.length; i++){
    				if(inorder[i]==rootValue){
    					k = i;
    					break;
    				}
    			}

    			root.left = buildTree(inorder, inStart, k-1, postorder, postStart, postStart+k-(inStart+1));

    			root.right = buildTree(inorder, k+1, inEnd, postorder, postStart+k-inStart, postEnd-1);


    			return root;
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner a = new Scanner(System.in);


		
		String inOrder = a.nextLine();
		String postOrder = a.nextLine();
		
		String inOrderArr[] = inOrder.split(",");
		String postOrderArr[] = postOrder.split(",");

		int[] inArr = new int[inOrderArr.length];
		int[] posArr = new int[postOrderArr.length];

		for(int i = 0 ; i < inArr.length; i++){

			inArr[i] = Integer.parseInt(inOrderArr[i]);
			posArr[i] = Integer.parseInt(postOrderArr[i]);
		
		}
		
		


		BuildBinaryTree obj = new BuildBinaryTree();
		TreeNode root = obj.buildTree(inArr, posArr);
		
		if(root!=null)
			obj.LevelOrder(root);
		else
			System.out.println("InvalidInput");
		
		}
	}


