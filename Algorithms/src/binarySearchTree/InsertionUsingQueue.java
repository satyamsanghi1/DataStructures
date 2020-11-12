package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.Node;

public class InsertionUsingQueue {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		
		//System.out.println("1st Node "+node);
		node.left=new Node(5);
		
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(15);
		
		//System.out.println("3rd Node "+node.right);
		node.left.left=new Node(2);
		//System.out.println("3rd Node "+node.right);
		node.left.right=new Node(6);
		//System.out.println("3rd Node "+node.right);
		
		node.right.left=new Node(13);
		node.right.right=new Node(17);
		
		Node node1=new Node(10);
		node1.left=new Node(5);
		node1.right=new Node(15);
		
		node.right.left=new Node(11);
		
		
	//	insert(node1,2);
		//insert(node1,1);
		insert(node1,17);
		insert(node1,30);
		insert(node1,34);
		
		System.out.println("TRAVERSING");
		traverse(node1);
		
		
		
	}
	
	public static Node insert(Node node,int value)
	{
		Queue<Node>queue=new LinkedList<>();
		
		if(node==null)
		{
			System.out.println("called");
			node=new Node(value);
			return node;
		}
		queue.add(node);
		while(!queue.isEmpty())
		{
			Node node1=queue.poll();
			System.out.println(node1.data);
			
			if(value<node1.data && node1.left!=null)
			{
				queue.add(node1.left);
			}
			else if(value<node1.data)
			{
				System.out.println("Creating left child of "+node1.data);
				node1.left=new Node(value);
			
			}
			 if(value>node1.data && node1.right!=null)
			{
				queue.add(node1.right);
			}
			 else if(value>node1.data)
			{
				 System.out.println("Creating right child of "+node1.data);
				 node1.right=new Node(value);
			}
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
