package leetcode;

import binaryTree.Node;

public class _110_BalancedBinaryTree {

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

		int height = BalancedTree(node);

		System.out.println("final " + height);

	}

	public static int  BalancedTree(Node node) {

		System.out.println("node " + node.data);

		if (node.left == null && node.right == null) {
			return 0;
		}

		int a = 0;
		int b = 0;
		
		 
		if (node.left != null) {
			System.out.println("left");
			a = BalancedTree(node.left);
			if(a==-1)
			{
				return -1;
			}

		}
		if (node.right != null) {
			b = BalancedTree(node.right);
			if(b==-1)
				return -1;
		}

		System.out.println("height difference (" + a + " - " + b + ") = " + Math.abs(a - b));

		if (Math.abs(a - b) == 0 || Math.abs(a - b) == 1) {
			return (a > b ? a : b) + 1;
		} else
			return -1;

	}
	

	

}
