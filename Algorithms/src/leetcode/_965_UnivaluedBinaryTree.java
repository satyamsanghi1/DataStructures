package leetcode;

import binaryTree.Node;

public class _965_UnivaluedBinaryTree {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		node.left=new Node(1);
		node.right=new Node(1);
		
		node.left.left=new Node(1);
		node.left.right=new Node(1);
		
		node.right.left=new Node(7);
		//node.right.right=new Node(7);
		
		//node.left.right.left=new Node(8);
		//node.left.right.right=new Node(9);
		
		System.out.println(isUnivalTree(node));
		
	}
	 public static boolean isUnivalTree(Node root) {
	        
		System.out.println(root.data);
		 if(root.left!=null && root.right!=null)
		 {
			if(!(root.left.data==root.right.data))
				return false;
		 }
		 else if(root.left==null && root.right!=null)
		 {
			 if(!(root.data==root.right.data))
				 return false;
		 }
		 else if(root.left!=null && root.right==null)
		 {
			 if(!(root.left.data==root.data))
			 {
				 return false;
			 }
		 }
		 	if(root.left!=null) {
	           boolean x= isUnivalTree(root.left);
	            if(x==false)
	                return false;
		 	}
	        if(root.right!=null)
	        {
	          boolean y=isUnivalTree(root.right);   
	        if(y==false)
	        	return y;
	        }
	         
	        return true;
	    }

}
