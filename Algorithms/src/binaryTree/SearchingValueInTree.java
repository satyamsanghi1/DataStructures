package binaryTree;

import java.util.ArrayList;

public class SearchingValueInTree {
	
	static int count=0;
	
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
		System.out.println("Traversing ");
		System.out.println();
		//1 2 3 4 5 
		
	//	System.out.println(	node.left.right.data);
		boolean value=traverse(node,2);
		if(value){
			System.out.println("found");
		}
		else
			System.out.println("not found");
	}
	
	public static boolean traverse(Node node,int value)
	{
	
	
	System.out.println(node.data);
	if(node.data==value)
	{
		return true;
	}
	
		if(node.left!=null)
		{
			boolean val=traverse(node.left,value);
			if(val)
				return val;
			
		}

		if(node.right!=null)
		{
			boolean val=traverse(node.right,value);
				return val;
		}
		return false;
	
		
	}
	
	
}
