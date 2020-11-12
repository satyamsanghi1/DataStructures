package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CreatingTreeUsingArray {
	
	public static void main(String[] args) {
		
		int arr[]= {1,2,3};
		
		Node n=new Node();
		for(int i:arr)
		insert(n,i);
		
		System.out.println("TRAVERSING");
		
		bredthTraverse(n);
		
	}
	
	public static void insert(Node node,int val)
	{
	
		Queue<Node>queue=new LinkedList<>();
		
		
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
	public static void bredthTraverse(Node node)
	{
		Queue<Node>queue=new LinkedList<>();
		if(queue.peek()==null)
		{
			queue.add(node);
		}
		while(!queue.isEmpty())
		{
			Node n=(Node)queue.poll();
			System.out.println(n.data);
			if(n.left!=null)
			queue.add(n.left);
			
			if(n.right!=null)
			queue.add(n.right);
		}
	}

}
