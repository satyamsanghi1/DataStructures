package algoExpert;

import algoExpert.BSTConstructionRecursive.BST;
import binaryTree.Node;

public class MinHeightBST {
	
	//Leetcode 108 ,COnvert sorted array to BST with minimum height
	
	public static void main(String[] args) {
		
		/*
		 * The sorted property of array insures that we have exactly n smaller nodes to its left
		 * and right
		 * 
		 * 
		 * The values in the array should be distinct otherwise they 
		 * will become skewed if used external insert method which will make tree skwiwed
		 */
		int a[]= {1,2,10,10,10,13,14,15,22};
		
		Node n=createBST(a, 0,a.length-1,null);
		
		iterate(n);
	}
	
	
	public static Node createBST(int a[],int i,int j,Node node)
	{
		if(i<=j)
		{
		int mid=(i+j)/2;
			System.out.println("mid "+mid+" i "+i+" j "+j);
		if(node==null)
		{
			node=new Node(a[mid]);
		}
		node.left=createBST(a,i, mid-1, node.left);
		
		node.right=createBST(a,mid+1,j,node.right);
		}
		
		return node;
		
	}
	 public static void iterate(Node root)
	    {
		
	    	if(root.left!=null)
	    	{
	    		System.out.println("left"+root.left.data+" p "+root.data);
	    		iterate(root.left);
	    	}
	    	
	    	if(root.right!=null)
	    	{	
	    		System.out.println("right"+root.right.data+" p "+root.data);
	    		iterate(root.right);
	    	}
	    }

}
