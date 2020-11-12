package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionInTreeUsingQueue {
	
	
	
	public static void main(String[] args) {
		
	
		
		Node node=new Node(1);
		System.out.println("1st Node "+node);
		node.left=new Node(2);
		System.out.println("2nd Node "+node.left);
		node.right=new Node(3);
		System.out.println("3rd Node "+node.right);
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		System.out.println();
		System.out.println("Inserting ");
		System.out.println();
		
		Queue<Node>queue=new LinkedList<>();
		 insert(node,queue,10);
		 insert(node,queue,20);
		
			System.out.println();
			System.out.println("Traversing ");
			System.out.println();
			Queue<Node>queue1=new LinkedList<>();
			bredthTraverse(node,queue1);
		 
		//1 2 3 4 5 
		
	
		
	}
	
	public static void insert(Node node,Queue<Node> queue,int val)
	{
	
		if(queue.isEmpty())
		{
			queue.add(node);
		}
		
			while (!queue.isEmpty())
			{
			
				Node n=(Node) queue.poll();
				System.out.println(n.data);
		
				if(n.left==null)
				{
					System.out.println("called left "+n.data);
					n.left=new Node(val);
					break;
				}
				else
					queue.add(n.left);
				if(n.right==null)
				{
					System.out.println("called right "+n.data);
					n.right=new Node(val);
					break;
				}
				else
					queue.add(n.right);
			
			}
		
	
	}
	
	public static void bredthTraverse(Node node,Queue<Node> queue)
	{
		
		queue.add(node);
		int size=queue.size();
		while(!queue.isEmpty())
		{
			size=queue.size();
			
			for(int i=0;i<size;i++)
			{
			Node n=(Node)queue.poll();
			System.out.print(n.data+" ");
			if(n.left!=null)
			queue.add(n.left);
			
			if(n.right!=null)
			queue.add(n.right);
			}
			System.out.println();
		}
	}
	
	
}
