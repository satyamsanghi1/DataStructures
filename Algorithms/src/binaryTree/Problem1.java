package binaryTree;

import java.util.ArrayList;

public class Problem1 {
	
	static int count=0;
	static ArrayList<Integer>a=new ArrayList<>();
	static String s="";
	
	public static void main(String[] args) {
		
	
		
		Node node=new Node(1);
		//System.out.println("1st Node "+node);
		node.left=new Node(2);
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(3);
		//System.out.println("3rd Node "+node.right);
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		//System.out.println();
		//System.out.println("Traversing ");
		System.out.println();
		//1 2 3 4 5 
		
	//	System.out.println(	node.left.right.data);
		traverse(node,0);
		System.out.println("String "+s);
		
		System.out.println("traversing array list");
		for(int s:a)System.out.println(s);
	}
	
/*	public static void traverse(Node node,int value)
	{
		System.out.println("data "+node.data);
		
		value=value*10+node.data;
		System.out.println(value);
		
		if(node.left!=null)
		{
			traverse(node.left,value);
	
			
		}
		else
		{
			a.add(value);
			System.out.println("value added "+value);
		}

		if(node.right!=null)
		{
			traverse(node.right, value);
		}
		
	}*/
	////ALTER ////
	public static int traverse(Node node,int value)
	{
		System.out.println("data "+node.data);
		
		value=value*10+node.data;
		System.out.println(value);
		
		if(node.left==null && node.left==null) {
			System.out.println(value);
			return Integer.parseInt(String.valueOf(value),10);
			
		}
		if(node.left!=null)
		{
			traverse(node.left,value);

		}
		if(node.right!=null)
		{
			traverse(node.right, value);
		}
		return 0;
	}
	
}
