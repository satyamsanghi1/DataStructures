package binarySearchTree;

import binaryTree.Node;

public class Searching_TraversalBST {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		
		System.out.println("1st Node "+node);
		node.left=new Node(5);
		
		System.out.println("2nd Node "+node.left);
		node.right=new Node(15);
		
		System.out.println("3rd Node "+node.right);
		node.left.left=new Node(2);
		System.out.println("3rd Node "+node.right);
		node.left.right=new Node(6);
		System.out.println("3rd Node "+node.right);
		
		node.right.left=new Node(13);
		node.right.right=new Node(17);
		
		System.out.println();
		System.out.println("TRAVERSING");
	//	traverse(node);

		search(node,13);
	}
	
	public static void search(Node node,int value)
	{
		if(node.data==value)
		{	
			System.out.println("Found "+node.data);
			return ;
		}
		
		System.out.println(node.data);
		
		if(value<node.data && node.left!=null)
			search(node.left,value);
		
		
		
		
		if(value >node.data && node.right!=null)
			search(node.right,value);
		
	}
	
	public static void traverse(Node node)
	{
		
		
	
		
		if(node.left!=null)
			traverse(node.left);
		System.out.println(node.data);
		
		if(node.right!=null)
			traverse(node.right);
	}
	
	

}
