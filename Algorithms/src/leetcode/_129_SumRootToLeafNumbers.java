package leetcode;

import binaryTree.Node;

public class _129_SumRootToLeafNumbers {
	static int sum=0;
	public static void main(String[] args) {
		
		Node root =new Node(4);
		root.left=new Node(9);
		root.right=new Node(0);
		
		root.left.left=new Node(5);
		root.left.right=new Node(1);
		
		int ans= sumNumbers(root);
		System.out.println("ans "+ans);
				
	}
	 public static int sumNumbers(Node root) {
	        
		  StringBuilder sb=new StringBuilder();
		 int z= helper(root,0);
		 System.out.println("return value "+z);
		return z;
	    }
	 public static int helper(Node root,int val)
	    {   
	      	val=val*10+root.data;  
	      	System.out.println("val "+val);
	       if(root.left==null && root.right==null)
	       {
	    	   System.out.println("sb "+val);
	    	//returning val when we reach leaf node of tree
	    	   return val;
	       }
	       int a=0,b=0;
	       
	         if(root.left!=null)
	        {
	        a=helper(root.left,val);  
	        }
	       
	        if(root.right!=null)
	        {
	        b=helper(root.right,val);
	        }
	   System.out.println("() "+(val+a+b));
	        return a+b;
	    }
	 
	 public static void helper(Node root,StringBuilder sb)
	    {
		 //5%fast
	        sb.append(root.data+"");
	      //  System.out.println("sb "+sb.toString());
	       if(root.left==null && root.right==null)
	       {
	       //   System.out.println("sball "+sb.toString());
	            sum+=Integer.parseInt(sb.toString());
	       }
	         if(root.left!=null)
	        {
	        helper(root.left,sb);
	           //  sum+=Integer.parseInt(sb.toString());
	            //System.out.println("sb1 "+sb.toString());
	            sb.deleteCharAt(sb.length()-1);
	               
	            
	        }
	       
	        if(root.right!=null)
	        {
	        helper(root.right,sb);
	          //   sum+=Integer.parseInt(sb.toString());
	            //System.out.println("sb2 "+sb.toString());
	            sb.deleteCharAt(sb.length()-1);
	        }
	     //    System.out.println("sb2 "+sb.toString());
	         //sum+=Integer.parseInt(sb.toString());
	        
	    }

}
