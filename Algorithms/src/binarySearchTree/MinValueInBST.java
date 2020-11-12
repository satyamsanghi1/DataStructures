package binarySearchTree;

import binaryTree.Node;

public class MinValueInBST {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		Node head=node;
		//System.out.println("1st Node "+node);
		node.left=new Node(5);
		
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(15);
		
		node.right.left=new Node(14);
		node.left.left=new Node(2);
		node.left.right=new Node(7);
		
		node.right.right=new Node(20);
		node.right.right.left=new Node(19);
		
		System.out.println(findMin(node));
	}
	
	public static int findMin(Node node)
	{
		while(node.left!=null)
		{
			node=node.left;
		}
		
		return node.data;
		
	}

}
