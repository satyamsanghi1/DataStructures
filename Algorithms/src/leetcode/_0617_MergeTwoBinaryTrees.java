package leetcode;

import binaryTree.Node;

public class _0617_MergeTwoBinaryTrees {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		//Node node=null;
		node.left=new Node(3);
		
		node.right=new Node(2);	
		node.left.left=new Node(5);
		
		/// 2nd Tree
		
		Node node1=new Node(2);
		
		node1.left=new Node(1);
		node1.right=new Node(3);
		
		node1.left.right=new Node(4);
		node.right.right=new Node(7);
		
		mergeTrees(node,node1);
		
		System.out.println();
		System.out.println("Traversing");
		traverse(node);
		
	}
	public static Node mergeTrees(Node t1,Node t2) {
		
		
		if(t1==null)
			return t2;
			
		if(t2==null)
			return t1;
		
			t1.data+=t2.data;
		
		// if null is returned then let left be null  ,  for right
		t1.left= mergeTrees(t1.left,t2.left);
		t1.right=mergeTrees(t1.right,t2.right);
		
		return t1;
	}
	public static Node Alter(Node t1,Node t2) {

			
		if(t1 ==null && t2==null)
			return null;
		
		if(t1!=null && t2==null)
		{	
			System.out.println("here");
			return null;
		}
		if(t1==null && t2!=null)
			return t2;
		
		
			System.out.println("t1 "+t1.data+" t2 "+t2.data);
			t1.data=t1.data+t2.data;
			
			Node n1,n2;
			
			n1=Alter(t1.left,t2.left);
			n2=Alter(t1.left,t2.left);
			if(n1!=null)
			{
				t1.left=t2.left;
				System.out.println("hehe");
			}
			
			n2=Alter(t1.right,t2.right);
			
			if(n2!=null)
			{
				t1.right=t2.right;
				System.out.println("hehe "+t1.right.data);
			}
		return null;
	}
	
	public static void traverse(Node n)
	{
		if(n==null)
			return ;
		
		System.out.println(n.data);
		traverse(n.left);
		traverse(n.right);
		
	}
	

}
