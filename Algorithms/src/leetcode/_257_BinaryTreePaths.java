package leetcode;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import binaryTree.Node;

public class _257_BinaryTreePaths {
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		//System.out.println("1st Node "+node);
		node.left=new Node(2);
		
		//System.out.println("2nd Node "+node.left);
		node.right=new Node(3);
		
		//System.out.println("3rd Node "+node.right);
		node.left.left=new Node(4);
		//System.out.println("3rd Node "+node.right);
		node.left.right=new Node(5);
		
		//node.right.left=new Node(6);
		//node.right.right=new Node(7);
		
		List list=binaryTreePaths(node);
		
		System.out.println(list);
		
	}
	 public static List<String> binaryTreePaths(Node root) {
	        
	        List<String>list=new ArrayList<String>();
	        traverse(root,"", list);
	        return list;
	    }
	 
	   public static List<String> traverse(Node node,String str,List<String>list)
	    {
	        str+=Integer.toString(node.data);
	        str+="->";
	        if(node.left==null && node.right==null )
	        {
	        	str=str.substring(0,str.length()-2);
	            list.add(str);
	        }
	        
	        if(node.left!=null)
	            traverse(node.left,str,list);
	        
	        if(node.right!=null)
	            traverse(node.right,str,list);
	        
	        return list;
	    }

}
