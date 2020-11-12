package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.Node;

public class Insertion {
	
	public static void main(String[] args) {
		
		
Node node=new Node(10);
		
		//System.out.println("1st Node "+node);
		node.left=new Node(5);
		
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(15);
		
		
		/*
		 * System.out.println("3rd Node "+node.right); node.left.left=new Node(2);
		 * System.out.println("3rd Node "+node.right); node.left.right=new Node(6);
		 * System.out.println("3rd Node "+node.right);
		 * 
		 * 
		 * node.right.left=new Node(13); node.right.right=new Node(17);
		 */
		
		Node n1=insert(node,7);
		System.out.println("returned "+n1.data);
		//insert(node,8);
		//insert(node,11);
		
		//Node node1=null;
		//node1=insert(node1,10);
		
		System.out.println("TRAVERSING");
		traverse(node);
		
		
		
	}
	
	public static Node insert(Node node,int value)
	{
		if(node!=null)
		System.out.println(node.data);
		
		if(node==null)
		{
			System.out.println("called");
			node=new Node(value);
			return node;
		}

		if(value<node.data)
		{
			
			//assigning return value to node.left
			//to mark pointer to the new child
			 node.left=insert(node.left,value);
		}
		else if(value>node.data)
		{
			//assigning return value to node.right
			//to mark pointer to the new child
			 node.right=insert(node.right,value);
		}
		return node;
		
	}

	public static void traverse(Node node)
	{
		
		System.out.println(node.data);
	
		
		if(node.left!=null)
			traverse(node.left);
		
	
		
		if(node.right!=null)
			traverse(node.right);
	}

}
