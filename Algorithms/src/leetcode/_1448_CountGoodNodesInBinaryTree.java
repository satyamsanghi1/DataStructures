package leetcode;

import binaryTree.Node;

public class _1448_CountGoodNodesInBinaryTree {
	
	static int good=0;
	public static void main(String[] args) {
		
		
		Node node=new Node(3);
		
		node.left=new Node(1);
		node.right=new Node(4);
		
		
		node.left.left=new Node(3);
		
		//node.left.right=new Node(5);
		node.right.left=new Node(1);
		node.right.right=new Node(5);
		
		
		//node.left.left.left=new Node(8);
		//node.left.left.right=new Node(9);
		
		goodNode(node);
	}
	
	public static int goodNode(Node root)
	{
		if(root==null)
			return 0;
		
		int a=helper(root,Integer.MIN_VALUE);
		System.out.println("Answer good "+a);
		return 0;
	}
	public static int helper(Node root,int max)
	{
		if(root==null)
			return 0;
		System.out.println("max "+max+"current "+root.data);
		if(root.data>=max)
		{
			System.out.println("good "+root.data);
			good++;
			max=root.data;
		}
		
		int a=helper(root.left,max);
		int b=helper(root.right,max);
		
		if(root.data>=max)
			return a+b+1;
		else
			return a+b;
	}

}
