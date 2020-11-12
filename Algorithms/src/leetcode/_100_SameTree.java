package leetcode;

import java.util.ArrayList;

import binaryTree.Node;

public class _100_SameTree {

	
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		node.left=new Node(5);
		node.right=new Node(15);
		
		Node node1=new Node(10);
		node1.left=new Node(5);
		//node1.right=new Node(15);
		
		
		boolean x=isSameTree(node,node1);
		System.out.println(" answer "+x);
	}
	 public static boolean isSameTreeAlter(Node p, Node q)
	 {
		 //better solutio
		 if(p==null &q==null)
			 return true;
		 
		 if(p==null || q==null)
			 return false;
		 
		 if(p.data!=q.data)
			 return false;
		 
		 boolean x=isSameTreeAlter(p.left, q.left);
		 
		 boolean y=isSameTreeAlter(p.right, q.right);
		 
		 if(x && y)
		 return true;
		 else return false;
	 }
	 public static boolean isSameTree(Node p, Node q)
	 {
		 System.out.println("p "+p.data+" , q "+q.data);
		 
		 if(p.data!=q.data)
		 {
			 return false;
		 }
		 else if(p.data==q.data)
		 {
		
			 if(p.left!=null && q.left!=null)
			 {
				 System.out.println("called");
				 boolean x=isSameTree(p.left,q.left);
				 if(x==false)
					 return false;
				 
			 }
			 else if(p.left!=null && q.left==null)
			 {
				 return false;
			 }
			 else if(p.left==null && q.left!=null)
			 {
				 return false;
			 }
		
			 if(p.right!=null && q.right!=null)
			 {
				 System.out.println("caled right");
				boolean x=isSameTree(p.right,q.right);
				if(x == false)
				{
					return false;
				}
				 
			 }
			 else if(p.right!=null && q.right==null)
			 {
				 return false;
			 }
			 else if(p.left==null && q.left!=null)
			 {
				 return false;
			 }
		
		 }			
			 return true;
	 }
	
}
