package binarySearchTree;

import binaryTree.Node;

public class Deletion {
	
	public static void main(String[] args) {
		
		/*
		 * This code miss a major case when a bst has only root node 
		 * or root has only one child either left or right , in that case delettion is not working
		 * for this condition is implemented in alog expert section
		 * 
		 * 
		 */
		Node node=new Node(10);
		Node head=node;
		//System.out.println("1st Node "+node);
		node.left=new Node(5);
		/*
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(15);
		
		node.right.left=new Node(14);
		node.left.left=new Node(2);
		node.left.right=new Node(7);
		
		node.right.right=new Node(20);
		node.right.right.left=new Node(19);
		*/
		delete(node,10);
		
		System.out.println("TRAVERSING");
		//ystem.out.println(findMinValue(node));
		traverse(node);
		
		//System.out.println("SEARCHING ");
		//Searching_TraversalBST.search(head,19);
		
	}
	public static Node delete(Node node,int value)
	{
			
		System.out.println("data "+node.data);
	if(value==node.data)
	{
		System.out.println("found");
		if(node.left==null && node.right==null) {
		
		return null;
		}
		else if(node.left!=null && node.right!=null)
		{
			System.out.println("both the child not null");
			int n=findMinValue(node.right);
			System.out.println("min value "+n);
			System.out.println("deleting "+n);
			
			
			delete(node,n);
		node.data=n;
			return node;
			
		}
		else if(node.left==null)
		{
			System.out.println("in this");
			return node.right;
		}
		else if(node.right==null)
		{
			System.out.println("in this");
			return node.left;
		}
		
		
	}
		
		if(value<node.data && node.left!=null)
		{
			
			 node.left=delete(node.left,value);
		}
		else if(value>node.data && node.right!=null)
		{
			//assigning return value to node.right
			//to mark pointer to the new child
			 node.right=delete(node.right,value);
		}
		return node;
		
	}
	
	public static int findMinValue(Node node)
	{
		//System.out.println("left "+node.data);
		int min=0;
		if(node.left==null)
		{
			System.out.println("left "+node.data);
			return node.data;
		}
		else
		{
			
			min=findMinValue(node.left);
			System.out.println("asd " +min+" node "+node.data);
			//node.left=null;
		}
		System.out.println("node "+node.data);
		return min;
	}

	public static void traverse(Node node)
	{
		
		System.out.print (" "+node.data);
	 
		
		if(node.left!=null)
			traverse(node.left);
		
	
		
		if(node.right!=null)
			traverse(node.right);
	}

}
