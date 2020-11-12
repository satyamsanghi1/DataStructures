package leetcode;

import binaryTree.Node;

public class _235_LowestCommonAncestorAncestorInBinarySearchTree {

	public static void main(String[] args) {
		
		

		Node node=new Node(6);
		
		node.left=new Node(2);
		
		node.right=new Node(8);
	
		node.left.left=new Node(0);
		node.left.right=new Node(4);
		
		node.right.left=new Node(7);
		node.right.right=new Node(9);
		
		node.left.right.left=new Node(3);
		node.left.right.right=new Node(5);
		
		
		Node p=new Node(0);
		Node q=new Node(9);
		
		//Node ancestor=LCS(node,p,q);
		
		Node ancestor=LCSAlter(node,p,q);
		System.out.println("ANCESTOR "+ancestor.data);
	}
	
	public static Node LCSAlter(Node root, Node p, Node q) 
	{
		// best solution 
		  if(p.data<root.data && q.data<root.data)
	            return LCSAlter(root.left,p,q); // traversing left subtree if both are in smaller than root
	        
		  //traversing right subtree of root , if both p and q are greater than root value
	        else if(p.data>root.data && q.data >root.data)
	            return LCSAlter(root.right,p,q);
	        
	        else
	            return root;
	        
		
	}
	 	
	public static Node LCS(Node root, Node p, Node q) 
	{
		// my solution 
		if(root==null)
			return null;
		
		System.out.println(root.data);
		
			if(p.data<=root.data && q.data>=root.data)
				return root;
			else if(q.data<=root.data && p.data>=root.data)
				return root;

		
		Node n1=null;
		Node n2=null;

		  
              n1= LCS(root.left,p,q);
              if(n1!=null)
                  return n1;
 
				  n2=LCS(root.right,p,q);
				     if(n2!=null)
		                  return n2;
	
        return null;
	}
	
	
}
