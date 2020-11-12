package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import binaryTree.Node;

public class _226_InvertBinaryTree {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		//System.out.println("1st Node "+node);
		node.left=new Node(2);
		
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(3);
		
		//System.out.println("3rd Node "+node.right);
	node.left.left=new Node(4);
		
	//	node.left.left.left=new Node(5);
		//System.out.println("3rd Node "+node.right);
		//node.left.right=new Node(5);
		
		//node.right.left=new Node(6);
		//node.right.right=new Node(7);
		
		//recurse(node.left,node.right);
		
		
		
		//System.out.println("data "+node.right.right.data);
		//Node image=new Node(node.data);
		//create(node,image);
		//recurse(node);
		InvertQueue(node);
		System.out.println("traversing orignal");
		bredthTraverse(node);
		//System.out.println("traversing image");
		//bredthTraverse(image);
		
		//System.out.println("data "+node.right.right.data);
		
		
	}
	  
	    
		public static void create(Node node,Node image)
		{
			// in this solution we are creating another tree with opposite childs of original
			System.out.println(node.data);
			if(node.left!=null)
			{
				image.right=new Node(node.left.data);
				create(node.left,image.right);
			}
			
			if(node.right!=null)
			{
				image.left=new Node(node.right.data);
				create(node.right,image.left);
			}
		}
	    public static void recurse(Node node)
	    {
	    	//best Solution 
	    	// in this solution we are reaching to the end and replacing both the
	    	// childs of each node 
	    	
	    	
	    	if(node==null)
	    		return ;
	    	
	    	recurse(node.left);
	    	recurse(node.right);
	      
	    	Node swap=node.left;
	    	node.left=node.right;
	    	node.right=swap;
	        
	    }
	    
	    public static void InvertQueue(Node node)
	    {
	    	Queue<Node>queue=new LinkedList<Node>();
	    	
	    	queue.add(node);
	    	int size=queue.size();
	    	Node swap=null;
	    	
	    	while(!queue.isEmpty())
	    	{
	    		for(int i=0;i<size;i++)
	    		{
	    			Node n=queue.poll();
	    			swap=n.left ;
	    			n.left=n.right;
	    			n.right=swap;
	    			
	    			if(n.left!=null)
	    			queue.add(n.left);
	    			if(n.right!=null)
	    			queue.add(n.right);
	    			
	    		}
	    	}
	    }
		public static void bredthTraverse(Node node)
		{
			Queue<Node>queue=new LinkedList<>();
			queue.add(node);
			int size=queue.size();
			while(!queue.isEmpty())
			{
				size=queue.size();
				
				for(int i=0;i<size;i++)
				{
				Node n=(Node)queue.poll();
				System.out.print(n.data+" ");
				if(n.left!=null)
				queue.add(n.left);
				
				if(n.right!=null)
				queue.add(n.right);
				}
				System.out.println();
			}
		}
	 
	    

}
