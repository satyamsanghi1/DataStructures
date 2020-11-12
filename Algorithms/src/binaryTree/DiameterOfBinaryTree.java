package binaryTree;

import java.util.ArrayList;
import java.util.Collections;

import binaryTree.Node;

public class DiameterOfBinaryTree {
	
	static int ans;
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		node.left=new Node(5);
		node.right=new Node(15);
		
		node.left.left=new Node(0);
		node.left.right=new Node(2);
		
		//node.left.right.right=new Node(8);
		//node.right.left=new Node(4);
		//node.right.right=new Node(6);
		
		//node.left.right.right=new Node(8);
		  
    
		findDiameter(node);
		int diameter=ans;
     System.out.println("diamter "+diameter);
		
	}

	    public static int findDiameter(Node node)
	    {
	        /// best solution and fastest
	       
	    	if(node==null)
	    		return 0;
	    	
	        int a=0;
	        int b=0;
	        
	        
	            a=findDiameter(node.left);
	            
	       
	            b=findDiameter(node.right);
	        System.out.println("a "+a+" b "+b+" node "+node.data);
	        ans=Math.max(ans, a+b);
	        return (a>b?a:b)+1;
	        
	        
	        
	    }

}
