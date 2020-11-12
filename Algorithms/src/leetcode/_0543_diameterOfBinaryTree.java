package leetcode;

import java.util.ArrayList;
import java.util.Collections;

import binaryTree.Node;

public class _0543_diameterOfBinaryTree {
	
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
		  
     //int diameter=diameterOfBinaryTree(node);
		findDiameter(node);
		int diameter=ans;
     System.out.println("diamter "+diameter);
		
	}
	
	 public static int diameterOfBinaryTree(Node root) {
		 
		 //brute force nlogn  may be
		 
		 //calculating height at each note 
		   if(root==null)
	            return 0;

	        ArrayList<Integer>a=new ArrayList<>();
	        
	        
	       int height= findHeight(root,a);
	       System.out.println();
	        System.out.println("height "+height);
	        for(int i:a)
	            System.out.print(i+" ");
	 
	        return Collections.max(a);
		 
	 }

	 
	public static int findHeight(Node node,ArrayList<Integer>list)
	{	        
		      
		if(node==null)
			return 0;
		        int a=0;
		        int b=0;
		        
		    
		            a=findHeight(node.left,list);
		            b=findHeight(node.right,list);
		       
		        
		   System.out.println("node "+node.data+" a "+a+" b "+b);
		        list.add(a+b);
		        return (a>b?a:b)+1;
		        
		        
		        
		    
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
	        
	        ans=Math.max(ans, a+b);
	        return (a>b?a:b)+1;
	        
	        
	        
	    }

}
