package leetcode;

import binaryTree.Node;

public class _0606_ConstructStringFromBinaryTree {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(1);
		
		node.left=new Node(2);
		
		
		node.right=new Node(3);
		
		
		node.left.left=new Node(4);
		
		node.left.right=new Node(5);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		//node.right.right=new Node(15);
		
		
		String x=tree2str(node);
		System.out.println(x);
	}
	  public static String tree2str(Node t) {
/*		  
		  if(t==null)
			  return "";
		  
		  if(t.left==null && t.right==null)
			  return t.data+"";
		  
		  if(t.right==null)
		 return t.data+"("+tree2str(t.left);
		  tree2str(t.right);
		  
		  */
		  return null;
	  }

}
