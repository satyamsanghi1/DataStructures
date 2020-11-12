package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import binaryTree.Node;

public class _101_SymmetricTree {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(2);
		
		node.left.left=new Node(3);
		node.left.right=new Node(4);
		
		node.right.left=new Node(4);
		node.right.right=new Node(3);
		
		//node.left.right.left=new Node(8);
		//node.left.right.right=new Node(9);
		
		//isSymmetricAlter(node);
		boolean x=isSymmetric(node.left,node.right);
		System.out.println("ANs "+x);
	}
	 public static boolean isSymmetric(Node left,Node right) 
	 {
		 
		 if(left!=null && right!=null) {
			 System.out.println("nodeLeft "+left.data);
			 System.out.println("nodeRight"+right.data);
			 if(left.data!=right.data)
				 return false;
			 
		 }
		 if(left==null && right==null)
			 return true;
		 if(left==null || right==null)
		 {
			 System.out.println("here");
			 return false;
		 }
		 
		 boolean x=isSymmetric(left.left, right.right);
		 if(x==false)
			 return false;
		 
		
		 boolean y=isSymmetric(left.right, right.left);
		 if(y==false)
			 return false;
		 	 
		 	 return true;
		 
	 }
	 public static boolean isSymmetricAlter(Node node) {
		 //not working
		// System.out.println("node "+node.data);
		 ArrayList<Node>list=null;
	
		Queue<Node>queueLeft=new LinkedList<Node>();
		Queue<Node>queueRight=new LinkedList<Node>();
		Stack<Node>stack1=null;
		Stack<Node>stack2=new Stack<Node>();
		queueLeft.add(node.left);
		
		queueRight.add(node.right);
	
		while(!queueLeft.isEmpty())
		{	
			list=new ArrayList<Node>();
			stack1=new Stack<Node>();
			int size1=queueLeft.size();
			int size2=queueRight.size();
			System.out.println("size1 "+size1);
			System.out.println("size2 "+size2);
			
			
		for(int i=0;i<size1;i++)
		{
			Node n=queueLeft.poll();
			
			Node n1=queueRight.poll();
			list.add(n);
			stack1.push(n);
			System.out.print("QueueLeft "+n.data+" ");
			System.out.println("QueueRight "+n1.data);
			
			if(n.data!=n1.data) {
				System.out.println("not symmetric");
				return false;
			}
			if(n.left!=null)
				queueLeft.add(n.left);
			
			if(n.right!=null)
				queueLeft.add(n.right);
			
			
			if(n.right!=null)
				queueRight.add(n1.right);
			
			if(n.left!=null)
				queueRight.add(n1.left);
		}
		System.out.println();
		
		
		
	
	
		}
		 return false;
	        
	    }

}
