package algoExpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algoExpert.MaxPathSumInBinaryTree.BinaryTree;

public class FlattenBinaryTree {
	
	public static void main(String[] args) {
		
		BinaryTree root=new BinaryTree(1);
		
		root.left=new BinaryTree(2);
		root.right=new BinaryTree(3);
		
		root.left.left=new BinaryTree(4);
		BinaryTree x=root.left.left;
		root.left.right=new BinaryTree(5);
		
		root.left.right.left=new BinaryTree(7);
		root.left.right.right=new BinaryTree(8);
		root.right.left=new BinaryTree(6);
		
	/*	// SOLUTION 1 : collecting all nodes in list of inorder traversal 
		// changing the left and right pointers 
		//easy solution
		List<BinaryTree>list=new ArrayList<>();
		inorderTraversal1(root,list);
		
		BinaryTree node=list.get(0);
		for(int i=0;i<list.size();i++)
		{
		
			BinaryTree current=list.get(i);
			System.out.println(current.value);
			BinaryTree next=null;
			if(i+1<list.size())
			{
			 next=list.get(i+1);
			System.out.println("next "+next.value);
			next.left=current;
			}
			
			current.right=next;
		}*/
		
		BinaryTree node=flattenBinaryTree(root);
		while(node!=null)
		{
		System.out.println(node.value);
		node=node.right;
		}
		
		
	}
	 public static BinaryTree flattenBinaryTree(BinaryTree root) {
		 
		BinaryTree n[]= inorderTraversal(root);
		 return n[0];
	 }
	public static BinaryTree[] inorderTraversal(BinaryTree root)
	{
		BinaryTree leftMostNode=null,rightMostNode=null;
		BinaryTree []leftSubTree=null,rightSubTree=null;
		if(root.left==null)
		{
		leftMostNode=root;
		}
		else
		{
			 leftSubTree=inorderTraversal(root.left);
			 leftMostNode=leftSubTree[0];
			 
			 BinaryTree leftSubTreeRightMostNode=leftSubTree[1];
			 
			 leftSubTreeRightMostNode.right=root;
			 root.left=leftSubTreeRightMostNode;
		}
		
		if(root.right==null)
		{
			rightMostNode=root;
		}
		else
		{
			rightSubTree=inorderTraversal(root.right);
			rightMostNode=rightSubTree[1];
			
			BinaryTree rightSubTreeLeftMostNode=rightSubTree[0];
			
			rightSubTreeLeftMostNode.left=root;
			root.right=rightSubTreeLeftMostNode;
		}
		
		System.out.println("current "+root.value);

		
		
		return new BinaryTree[] {leftMostNode,rightMostNode};
	}
	public static void inorderTraversal1(BinaryTree root,List<BinaryTree>list)
	{

		if(root.left!=null)
			inorderTraversal1(root.left,list);
		list.add(root);
			if(root.right!=null)
			inorderTraversal1(root.right,list);
		
		
	}

}
