package dynamcProgramming;

import java.util.HashSet;

import binaryTree.Node;

public class HouseRobberIII {
	
	//static int max=0;
	static int a=0;
	//static int first=0;
	//static int second=0;
	public static void main(String[] args) {
		
		//incomplete

		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(3);
		
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		
		node.right.left=new Node(6);
		HashSet<Integer>set=new HashSet<>();
		
		rob(node);
		//System.out.println("max "+max);   
		System.out.println("a "+a);
	}
	public static void rob(Node root) {
        
		if(root==null)
			return;

		helper(root);
    }
	 public static int[] helper(Node root)
	    {
	        if(root==null)
	        {
	            return new int[]{0,0};
	        }
	        
	        int left[]=helper(root.left);
	        int right[]=helper(root.right);
	        
	        
	        int robNode=root.data+left[1]+right[1];
	        
	       // int notRobNode=Math.max(left[0]+right[0],left[0]+right[1],left[1]+right[0],left[1]+right[1]);
	        
	        return null;
	    }

}
