package binarySearchTree;

import binaryTree.Node;

public class BinarySearchTreeOrNotAlter {
	
	public static void main(String[] args) {
		
		
		//Bad Solution takes more time

		Node node=new Node(1);
		node.left=new Node(1);
	/*	node.right=new Node(5);
		
		node.left.left=new Node(0);
		node.left.right=new Node(2);
		
		node.left.right.right=new Node(8);
		node.right.left=new Node(4);
		node.right.right=new Node(6);
		
		node.left.right.right=new Node(8);*/

		boolean answer=recur(node);
		System.out.println("answer "+answer);
		
		//[2147483647]
	}
	
	
	public static boolean recur(Node root)
	{
		boolean x;
		boolean y;
		if(root.left!=null)
        {
			x=traverseLeft(root.left,root);
			if(x==false)
				return false;
           y= recur(root.left);
           if(y==false)
        	   return false;
            
         }
        
        if(root.right!=null)
        {
        	x=traverseRight(root.right,root);
        	if(x==false)
				return false;
        	  y= recur(root.right);
        	   if(y==false)
            	   return false;
        }
        
        return true;
        
	}
	public static boolean traverseLeft(Node root,Node parent)
	{
		System.out.println("here at "+root.data +" pa "+parent.data);
		if(root.data>=parent.data)
			return false;
		
		boolean x;
		if(root.left!=null)
        {
        
           x= traverseLeft(root.left,parent);
           if(x==false)
        	   return false;
         }
        
        if(root.right!=null)
        {
        	  x= traverseLeft(root.right,parent);
        	  if(x==false)
           	   return false;
        }
		return true;
	}
	public static boolean traverseRight(Node root,Node parent)
	{
		if(root.data<parent.data)
			return false;
		
		boolean x;
		if(root.left!=null)
        {
        
           x= traverseRight(root.left,parent);
           if(x==false)
        	   return false;
         }
        
        if(root.right!=null)
        {
        	  x= traverseRight(root.right,parent);
        }
		return true;
	}
	
}
