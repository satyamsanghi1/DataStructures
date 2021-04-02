package algoExpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import binaryTree.TreeNode;

public class FindNodesDistanceK2 {
	
	//AlgoExpert solution 2: 98%Fast LEetcode
	public static void main(String[] args) {

		
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);

		root.left.left=new TreeNode(4);
		
		root.left.right=new TreeNode(5);

		root.right.right=new TreeNode(6);
		root.right.right.left=new TreeNode(7);
		root.right.right.right=new TreeNode(8);

		 
//		TreeNode root=new TreeNode(1);
//		root.left=new TreeNode(2);
//		root.right=new TreeNode(3);
//
//		root.left.left=new TreeNode(4);
//		root.left.right=new TreeNode(5);
//	
//		root.right.left=new TreeNode(6);
//		root.right.right=new TreeNode(7);
	

		distanceK(root,1,2);
	}
	public static List<Integer> distanceK(TreeNode root, int target, int K) {
		/*
		 * Does not require to map of parent
		 * AlgoExpert solution 2: 98%Fast LEetcode
		 * Time (O)N ,Space -(O)N
		 * 
		 */

		List<Integer>nodesDistanceK=new ArrayList<>();
		findDistanceFromNodeToTarget(root, target,K, nodesDistanceK);
		
		System.out.println("ans "+nodesDistanceK);
		return nodesDistanceK;
	}
	
	public static int findDistanceFromNodeToTarget(TreeNode node,int target,int k,List<Integer>nodesDistanceK)
	{
		if(node==null)
			return -1;
		
		if(node.val==target)
		{
			//look for nodes down in this subtree at distance k
			addSubTreeNodeAtDistanceK(node,0,k,nodesDistanceK);
			return 1;
		}
		
		int leftDistance=findDistanceFromNodeToTarget(node.left, target, k, nodesDistanceK);
		int rightDistance=findDistanceFromNodeToTarget(node.right, target, k, nodesDistanceK);

		
		if(leftDistance==k || rightDistance==k)
			nodesDistanceK.add(node.val);
		
		if(leftDistance!=-1)
		{
			//target node is in left subtree
			addSubTreeNodeAtDistanceK(node.right,leftDistance+1, k, nodesDistanceK);
			return leftDistance+1;
		}
		
		if(rightDistance!=-1)
		{
			//target node is in right subtree
			addSubTreeNodeAtDistanceK(node.left,rightDistance+1, k, nodesDistanceK);
			return rightDistance+1;
		}
			
		return -1;
	}
	
	public static void addSubTreeNodeAtDistanceK(TreeNode node,int distance,int k,List<Integer>nodesDistanceK)
	{
		if(node==null)
			return ;
		
		if(distance==k)
		{
			nodesDistanceK.add(node.val);
		}
		else
		{
			addSubTreeNodeAtDistanceK(node.left,distance+1,k,nodesDistanceK);
			addSubTreeNodeAtDistanceK(node.right,distance+1,k,nodesDistanceK);
		}
		
	}
	


}
