package binarySearchTree;

import binaryTree.Node;

public class BinarySearchTreeOrNotAlter2 {
	
	public static void main(String[] args) {
		
		//BEST SOLUTION maintains upper limit and lower limit at each node

		Node node=new Node(3);
		node.left=new Node(1);
		node.right=new Node(5);
		
		node.left.left=new Node(0);
		node.left.right=new Node(2);
		
		//node.left.right.right=new Node(8);
		node.right.left=new Node(4);
		node.right.right=new Node(6);
		
		//node.left.right.right=new Node(8);

		boolean answer=recur(node,null,null);
		System.out.println("answer "+answer);
		
		//[2147483647]
	}
	
	
	public static boolean recur(Node root,Node min,Node max)
	{
		
		
		if(root==null)
			return true;
		
		if(min!=null && root.data<=min.data)
		{
			System.out.println("here at "+root.data +"min "+min.data);
			return false;
		}
		if(max!=null && root.data>=max.data)
		{	
			System.out.println("here at "+root.data +"max "+max.data);
			return false;
		}
		boolean x=recur(root.left,min,root);
		
		if(x==false)
			return false;
		boolean y=recur(root.right,root,max);
		
		if(y==false)
			return false;
      
		
        return true;
        
	}
	
}
