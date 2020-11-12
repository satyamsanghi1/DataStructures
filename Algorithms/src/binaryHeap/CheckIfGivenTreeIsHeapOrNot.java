package binaryHeap;

import binaryTree.Node;

public class CheckIfGivenTreeIsHeapOrNot {
	
	public static void main(String[] args) {
		
		Node node=new Node(97);
		
		node.left=new Node(46);
		
	
		node.right=new Node(37);
		
		
		node.left.left=new Node(12);
		
		node.left.right=new Node(3);
		
		
		node.right.left=new Node(7);
		node.right.right=new Node(31);
		
		node.left.right.left=new Node(1);
		node.left.right.right=new Node(2);
		
		
		int count=countNodes(node);
		
		System.out.println();
		System.out.println();
		System.out.println(checkHeap(node,count,1));
	}

	
	public static boolean checkHeap(Node root,int count,int i)
	{
		System.out.println(root.data);
		if(root.left==null && root.right==null)
		{
			System.out.println("Leaf node ");
			
		}

		else if(root.left==null && root.right!=null)
			return false;
		
		else if(root.data<root.left.data || root.data<root.right.data )
		{		
			return false;
		}
		if(i>count)
			return false;
		
		
	
		
		
		if(root.left!=null) {
		boolean x = checkHeap(root.left,count,2*i);
		if(x==false)
			return false;
		}
		if(root.right!=null)
		{
		 boolean y=checkHeap(root.right,count,2*i+1);
		 return y;
		}
	
		return true;
	}
	
	public static int countNodes(Node node)
	{
		System.out.println(node.data);
		
		if(node.left==null && node.right==null)
			return 1;
		
		int a=0;
		int b=0;
		if(node.left!=null)
		{
			a=countNodes(node.left);
		}
		if(node.right!=null)
		{
			b=countNodes(node.right);
		}
		System.out.println("a "+a);
		System.out.println("b "+b);
		System.out.println("no "+node.data);
		
		return (a+b)+1;
		
	}

}
