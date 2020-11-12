package leetcode;

import binaryTree.Node;

public class _0437_PathSumIII {
	
	 static int path=0;
	public static void main(String[] args) {
		
	Node node=new Node(10);
		
		node.left=new Node(5);
		
		node.right=new Node(-3);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(2);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(11);
		
		
		node.left.left.left=new Node(3);
		node.left.left.right=new Node(-2);
		
		//node.left.right.left=new Node(10);
		node.left.right.right=new Node(1);
		
	/*	node.right.left.left=new Node(2);
		node.right.left.right=new Node(12);
		
		node.right.right.left=new Node(8);
		node.right.right.right=new Node(9);
		*/
		System.out.println(~2);
		pathSum(node,8,0);
		System.out.println("paths "+path);
	
	}
	public static int pathSum(Node root, int sum,int x) 
	{

		System.out.println(root.data+" sum "+sum);
		System.out.println("diff "+(sum-root.data));
		int diff=sum-root.data;
		//if(diff>=0)
		//{
		if(x+root.data<=sum)
			x+=root.data;
		else
			x=0;
		
		if(x==sum)
			path++;
		//}
		System.out.println(" x "+x);
		System.out.println();
		if(root.left!=null)
		{
			
			pathSum(root.left,sum,x);
		}
		if(root.right!=null)
			pathSum(root.right,sum,x);
		
		return 0;
	}

}
