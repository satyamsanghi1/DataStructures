package algoExpert;

import java.util.Stack;

import binaryTree.Node;

public class NodeDepths {

	//write a function to calculate sum of tree node depths 
	public static void main(String[] args) {
		
		Node node=new Node(1);
		
		node.left=new Node(2);
		
		
		node.right=new Node(3);
		
		
		node.left.left=new Node(4);
		
		node.left.right=new Node(5);
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		
		node.left.left.left=new Node(8);
		node.left.left.right=new Node(9);
		
		//nodeDepths(node);
		iterative(node);
	}
	
	public static void iterative(Node root)
	{
		// space complexity is O(h)
		// becaouse at a time a max num of elements in stack will be roughly equal to its height
		
		// unless the tree is very skewed 	
		Level l=new Level(root,0);
		Stack<Level>stack=new Stack<>();
		stack.push(l);
		int currentSum=0;
		while(!stack.isEmpty())
		{	
			Level n=stack.pop();
			//
			
			if(n.node==null)
				continue;
			
			System.out.println(n.node.data+" depth "+n.depth);
			int depth=n.depth;
			currentSum+=depth;
			
			//if(n.node.left!=null)
			stack.push(new Level(n.node.left,depth+1));
			//if(n.node.right!=null)
			stack.push(new Level(n.node.right,depth+1));
			
			
			
		}
		System.out.println("node depth sum "+currentSum);
		
	}
	public static void nodeDepths(Node root)
	{
		int n=1;
		
		System.out.println(helper(root,0));
	}
	
	public static int helper(Node node,int height)
	{
		
		if(node==null)
			return 0;
		
		int a=helper(node.left,height+1);
		int b=helper(node.right,height+1);
		
		System.out.println("node "+node.data);
		return height+a+b;
	}
}
 class Level
{
	Node node;
	int depth;
	
	public Level(Node node,int depth)
	{
		this.node=node;
		this.depth=depth;
	}
}
