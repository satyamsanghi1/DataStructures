package avlTree;

import binaryTree.Node;

public class ToCheckAVLTreeOrNot {
	
	public static void main(String[] args) {
		

		Node node=new Node(10);
		node.left=new Node(5);
		node.right=new Node(15);
		
		node.left.left=new Node(2);
		node.left.right=new Node(7);
		
	//	node.right.left=new Node(14);
	//	node.right.right=new Node(20);
	
		//new 
	//	node.right.right.right=new Node(25);
	//	node.right.right.right.right=new Node(30);
		
	
		
		node.left.left.left=new Node(1);
		//node.left.left.right=new Node(9);
		
		int x=check(node);
		System.out.println("x "+x);
	}
	
	public static int check(Node node)
	{
		if(node.left==null && node.right==null)
			return 0;
		
		//condition for binary search tree 
		
		if(node.left!=null)
		if(node.left.data>node.data)
			return -1;
		
		//condition for binary search tree
		if(node.right!=null)
		if( node.right.data<=node.data)
		{
			return -1;
		}
		
		
		int a=0;
		int b=0;
		if(node.left!=null)
		{
			a=check(node.left);
			if(a==-1)
			{
				return -1;
			}
		}
		else
			a=-1;
		if(node.right!=null)
		{
			b=check(node.right);
			if(b==-1)
				return -1;
		}
		else
			b=-1;
		
		if(Math.abs(a-b)>1)
		{
			System.out.println("inbalance at node "+node.data);
			System.out.println("LST "+a);
			System.out.println("RST "+b);
			return -1;
		}
		else
			return (a>b?a:b)+1;
		
	}

}
