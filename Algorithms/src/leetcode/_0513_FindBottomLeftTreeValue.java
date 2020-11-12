package leetcode;

import java.util.HashSet;

import binaryTree.Node;

public class _0513_FindBottomLeftTreeValue {
	
	// or we can use queue level order traversal and save the first element everytime
	
	static int x=0;
	static int h=0;
	public static void main(String[] args) {
		
		Node node=new Node(10);
		
		node.left=new Node(5);
		
		
		node.right=new Node(15);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(18);
		
		//System.out.println(findBottomLeftValue(node));
		
		alter(node,1);
		System.out.println("ans "+x);
	}
	 public static void alter(Node root,int dist) {
		//100 % faster 
		 if(root==null)
			 return ;
		 
		 
		 if(dist>h)
		 {
			 x=root.data;
			 //for left side view // System.out.println(root.data);
			 h=dist;
		 }
		 
		 alter(root.left,dist+1);
		 alter(root.right,dist+1);
		 
		 
	 }
	
	 
	 public static int findBottomLeftValue(Node root) {
	        
	        if(root==null)
	            return 0;
	        HashSet<Integer>set=new HashSet<Integer>();
	        find(root,set,0);
	        int a=x;
	        x=0;
	        return a;
	        
	    }
	 public static void find(Node node,HashSet<Integer>set,int height)
	    {
	        if(node==null)
	            return ;
	        
	            if(set.add(height))
	                x=node.data;
	             
	    
	        
	        find(node.left,set,height+1);
	        find(node.right,set,height+1);
	    }

}
