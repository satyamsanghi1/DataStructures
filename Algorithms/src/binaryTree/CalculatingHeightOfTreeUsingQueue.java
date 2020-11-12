package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CalculatingHeightOfTreeUsingQueue {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		System.out.println("1st Node "+node);
		node.left=new Node(2);
		
		System.out.println("2nd Node "+node.left);
		node.right=new Node(3);
		
		System.out.println("3rd Node "+node.right);
		node.left.left=new Node(4);
		System.out.println("3rd Node "+node.right);
		node.left.right=new Node(5);
		System.out.println("3rd Node "+node.right);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		System.out.println("HEIGHT "+calculateHeight(node));
		
	}
	
	public static int calculateHeight(Node node)
	{
		Queue<Node>queue=new LinkedList<>();
		
		int count=0;
		queue.add(node);
		
		
		
		while(!queue.isEmpty())
		{
			count++;
			int size=queue.size();
		System.out.println("size "+size);
			for(int i=1;i<=size;i++)
			{	
				Node n=	queue.poll();
				System.out.println("called " +n.data);
				if(n.left!=null)
					queue.add(n.left);
					
					if(n.right!=null)
					queue.add(n.right);
			}
			System.out.println();
			
		
			
		}
	return count;
	}

}
