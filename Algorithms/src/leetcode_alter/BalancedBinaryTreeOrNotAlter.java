package leetcode_alter;

import binaryTree.Node;

public class BalancedBinaryTreeOrNotAlter {

	public static void main(String[] args) {

		Node node = new Node(1);
		//node.left = new Node(2);

		node.right=new Node(3);

	//	node.left.left = new Node(4);
		node.right.right=new Node(5);

		// node.left.right=new Node(5);

		 //node.left.left.left=new Node(6);
		node.right.right.right=new Node(7);

		 //node.right.left=new Node(6);
		 //node.right.right=new Node(7);

		boolean flag=BalancedTree(node);

		System.out.println("final " + flag);

	}

	public static boolean  BalancedTree(Node node) {


		
		int num=findHeight(node);
		
		System.out.println("num "+num);
		
		if(num==-1)
			return false;
		return true;
		
		


		
	}
	
	public static int findHeight(Node node)
	{
		
		
		if(node==null)
			return 0;
		
		System.out.println("node "+node.data);
		
		int left=findHeight(node.left);
		if(left==-1)
			return -1;
		int right=findHeight(node.right);
		if(right==-1)
			return -1;
		System.out.println("height difference (" + left + " - " + right + ") = " + Math.abs(left - right));

		
		if(Math.abs(left-right)>1)
			return -1;
					
		return (left>right?left:right)+1;
		

	}
	
	
	
}




























