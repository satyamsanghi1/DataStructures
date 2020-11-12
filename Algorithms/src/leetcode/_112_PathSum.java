package leetcode;

import binaryTree.Node;

public class _112_PathSum {
	
	public static void main(String[] args) {
		
		

		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(3);
		
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		node.left.right.left=new Node(8);
		node.left.right.right=new Node(9);
		
		//boolean ans=findSum(node,12,0);
		
	//	System.out.println("final ans "+ans);
		
		System.out.println(findSumAlter(node,13));
	}


	public static boolean findSumAlter(Node node,int sum)
	{
		
		System.out.println(node.data);
	
		
		
		if(node.left==null && node.right==null)
		{
			System.out.println("sum "+(sum-node.data));
			if(sum-node.data==0)
				return true;
			else
				return false;
		}
		return findSumAlter(node.left,sum-node.data) || findSumAlter(node.right,sum-node.data);
		
		
		
		
		
	}
		public static boolean findSum(Node node,int sum,int a)
		{
			
			a+=node.data;
			System.out.println(node.data);
			System.out.println("a "+a);
			if(node.left==null && node.right==null)
			{
				if(a==sum)
				{
					System.out.println("found at leaf node "+node.data);
					return true;
				}
			}
			
			
			if(node.left!=null)
			{
				boolean x=findSum(node.left,sum,a);
				if(x==true)return true;
			}
			if(node.right!=null)
			{
			boolean y=	findSum(node.right,sum,a);
			return y;
			}
			
			
			return false;
			
			
		}
}