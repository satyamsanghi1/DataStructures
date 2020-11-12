package leetcode_alter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import binaryTree.DepthOfBinaryTree;
import binaryTree.Node;

public class _107_BinaryLevelOrderTraversal_II__Alter {
	 static List<List<Integer>>a=new ArrayList<>();
	 
	 static List<Integer>list=new ArrayList<>();
	
	///Also we  can add into the 0th index of parent list 
	// when we add the list in the parent list for next time to 0th index
	// it will automatically shift it backwards 
	
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
		
		
		level(node,0);
		Collections.reverse(a);
		for(List<Integer> s:a)
		{
			System.out.println(s);
		}
		
		
	}
	
	////in this solution we are keeping track of level at every layer of tree
	/*
		
		
		*/  public static void level(Node n,int level)
		  {

				if(level==a.size()) {
					a.add(new ArrayList<Integer>());
					System.out.println("size "+a.size());
					
				}
				
			System.out.println(n.data);
			a.get(level).add(n.data);
			if(n.left!=null)
				level(n.left,level+1);
				if(n.right!=null)
				level(n.right,level+1);
		
		  }
		  }
		
		 
