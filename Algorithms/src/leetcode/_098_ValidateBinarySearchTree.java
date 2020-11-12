package leetcode;

import binaryTree.Node;

public class _098_ValidateBinarySearchTree {
	
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
		boolean answer=isValidBST(node,null,null);
	//	boolean answer=recur(node);
		System.out.println("answer "+answer);
		
		//[2147483647]
	}
	
	
	public static boolean isValidBST(Node root,Node min,Node max)
	{
		//BEST SOLUTION SET MIN LIMIT AND MAX LIMIT FOR EACH NODE
		
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
		boolean x=isValidBST(root.left,min,root);
		
		if(x==false)
			return false;
		boolean y=isValidBST(root.right,root,max);
		
		if(y==false)
			return false;
      
		
        return true;
        
	}
	
	public static boolean recur(Node root)
	{
		///brute Force Solution 
		//checks for each node and its left subtree and rightsubtree
		// all the elements should be less than root vallue
		// all the ements should be greater than root value
		// repeats this processs for each node
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
