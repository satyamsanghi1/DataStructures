package leetcode;

import java.util.HashSet;

import javax.swing.tree.TreeNode;

import binaryTree.Node;

public class _0404_SumOfLeftLeaves {
	static int a=0;
	public static void main(String[] args) {
		
		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(3);
		
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		int sum=sumOfLeftLeaves(node);
		int q=a;
		a=0;
		
		System.out.println("sum "+q);
	}
	
	  public static int sumOfLeftLeaves(Node root) {
	        
	        if(root==null)
	            return 0;
	        
	        int s=sum(root);
	        return s;
	        
	    }
	  
	 public static int sum(Node node)
	    {
	        if(node.left==null && node.right==null)
	        {
	          
	                return node.data;
	      
	        }
	        
	        int x=0;
	        if(node.left!=null)
	        {   
	          x=  sum(node.left);
	         if(x!=0)
	        	 a+=x;
	          System.out.println("left leaf "+x);
	        }
	        if(node.right!=null)
	        	sum(node.right);
	        
	        return 0;
	        
	    }

}
