package binarySearchTree;

import java.util.Stack;

import binaryTree.Node;

public class BinarySearchTreeOrNotAlterUsingInOrder {
	
	public static void main(String[] args) {
		
		

		Node node=new Node(3);
		node.left=new Node(1);
		node.right=new Node(5);
		
		node.left.left=new Node(0);
		node.left.right=new Node(2);
		
		//node.left.right.right=new Node(8);
		node.right.left=new Node(4);
		node.right.right=new Node(3);
		
		//node.left.right.right=new Node(8);
		
		//node.left.right.right=new Node(8);

		Stack<Node>stack=new Stack<>();
		boolean answer=recur(node,stack);
		System.out.println("answer "+answer);
		
		
		
	}
	
	
	public static boolean recur(Node root,Stack<Node>stack)
	{
	
		
		if(root==null)
			return true;
		
		boolean x=true;
		if(root.left!=null)
			x=recur(root.left,stack);
		
		if(x==false)
			return false;
		System.out.println(root.data);
		
		if(!stack.isEmpty())
		{
		if(stack.peek().data>=root.data)
		{
			System.out.println("stack top "+stack.peek().data+" , root "+root.data);
			return false;
		}
		}
		stack.push(root);
		
		if(root.right!=null)
			x=recur(root.right,stack);
			return x;
       // return true;
        
	}
	
}
