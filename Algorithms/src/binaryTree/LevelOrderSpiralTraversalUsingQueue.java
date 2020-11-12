package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderSpiralTraversalUsingQueue {
	
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
	
	
	

	bredthTraverse(node);
	
	///for this we need to know the height of the tree already 

}
	public static void bredthTraverse(Node node)
	{
	Queue<Node>queue=new LinkedList<>();
	int size=0;
	
	///will let alternate iteration of nodes from right to left 
	boolean RightToLeft=false;
	int count=0;
	if(queue.isEmpty())
	{
		queue.add(node);
	}
	while(!queue.isEmpty())
	{
		///used to count the level of tree
		count++;
		
		size=queue.size();
		Stack<Node>stack=new Stack<>();
		//iterating every level
		for(int i=0;i<size;i++) {
			
		Node n=queue.poll();
		if(!RightToLeft) {
		System.out.println(n.data);
		}
		else
		{
			stack.push(n);
		}
		if(n.left!=null)
		queue.add(n.left);
		if(n.right!=null)
		queue.add(n.right);
		}
		while(!stack.isEmpty())
		{
			Node n=(Node)stack.pop();
			System.out.println(n.data);
		}
		if(count==1)
		{
			RightToLeft=!RightToLeft;
			count=0;
		}
		
	}
	

	}
	
}
