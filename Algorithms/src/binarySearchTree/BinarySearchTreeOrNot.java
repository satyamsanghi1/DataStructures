package binarySearchTree;

import binaryTree.Node;

public class BinarySearchTreeOrNot {
	
	public static void main(String[] args) {
		
		

		Node node=new Node(1);
		node.left=new Node(1);
	/*	node.right=new Node(5);
		
		node.left.left=new Node(0);
		node.left.right=new Node(2);
		
		node.left.right.right=new Node(8);
		node.right.left=new Node(4);
		node.right.right=new Node(6);
		
		node.left.right.right=new Node(8);*/
		boolean answer=isValidBST(node);
	//	boolean answer=recur(node);
		System.out.println("answer "+answer);
		
		//[2147483647]
	}
	
	public static boolean isValidBST(Node node)
	{
		if(node==null)
			return true;
		
		if(node.data>Integer.MAX_VALUE || node.data<Integer.MIN_VALUE)
			return false;
		boolean x = false,y = false;
		if(node.left!=null)
			x=checkBSTL(node.left,Integer.MIN_VALUE,node.data);
		
		if(node.right!=null)
			y=checkBSTL(node.right,node.data,Integer.MAX_VALUE);
		
			
			if(!(y||x))
			return false;
			
			else
				 return true;
		 //return checkBSTL(node.left,Integer.MIN_VALUE,node.right.data) || checkBSTR(node.right,node.left.data,Integer.MAX_VALUE);
		
	
	}
	
		public  static boolean checkBSTL(Node node,int min,int max)
		{
			System.out.println("at node "+node.data+" min "+min+",max "+max);
			if(node.data>=max ||  node.data <=min)
				return false;
			
			boolean x;
			if(node.left!=null) {
				x=checkBSTL(node.left, min,node.data);
				if(x==false)
					return false;
			}
			if(node.right!=null)
			{
				x= checkBSTL(node.right,node.data,max);
				if(x==false)
					return false;
			}
			
			return true;
		}
		public  static boolean checkBSTR(Node node,int min,int max)
		{
			System.out.println("at node "+node.data+" min "+min+",max "+max);
			if(node.data>=max ||  node.data <=min)
				return false;
			
			boolean x;
			if(node.left!=null) {
				x=checkBSTR(node.left, min,node.data);
				if(x==false)
					return false;
			}
			if(node.right!=null)
			{
				x= checkBSTR(node.right,node.data,max);
				if(x==false)
					return false;
			}
			
			return true;
		}
	
	
	
	
}
