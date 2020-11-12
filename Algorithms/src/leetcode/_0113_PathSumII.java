package leetcode;

import java.util.ArrayList;
import java.util.List;

import binaryTree.Node;

public class _0113_PathSumII {
	
	/*
	 * 
	 * Given a binary tree and a sum, 
	 * find all root-to-leaf paths where each path's sum equals the given sum.
	 */

	public static void main(String[] args) {
		
		Node node=new Node(5);
		
		node.left=new Node(4);
		
		
		node.right=new Node(8);
		
		
		node.left.left=new Node(11);
		node.left.left.left=new Node(7);
		
		node.left.left.right=new Node(2);
		//node.left.right.left=new Node(8);
		
		node.right.left=new Node(13);
		node.right.right=new Node(4);
		
		node.right.right.right=new Node(1);
		node.right.right.left=new Node(5);
		
		pathSum(node,22);
	}
	public static List<List<Integer>> pathSum(Node root, int sum) {
        
		 List<List<Integer>>list=new ArrayList();
	        
	        List<Integer>l=new ArrayList<>();
	        String s="";
	        sum(root,sum,list,l,s);
	        System.out.println();
	        System.out.println("ans "+list);
	        return list;
	        
    }
	
	  public static void sum(Node root,int sum,List<List<Integer>>list,List<Integer>l,String s)
		{
	        
	        l.add(root.data);
	        s+=root.data+",";
	     //   System.out.println("sum "+sum);
	        System.out.println("data "+root.data);
	        System.out.println("l "+l);
	        if(root.left==null && root.right==null)
	        {
	            if(sum-root.data==0)
	            {
	            	System.out.println("adding to list");
	                list.add(new ArrayList<Integer>(l));
	                System.out.println("this "+list);
	                System.out.println(s);
	            }
	          //  else
	            //    l.remove((Integer)root.val);
	           // System.out.println("here "+sum);
	               
	        }
	        
	        if(root.left!=null)
	        {
	            sum(root.left,sum-root.data,list,l,s);
	           
	            
	                // l.remove((Integer)root.left.data);
	            //deleting root.left when coming back 
	            remove(l,root.left.data);
	                 System.out.println("leftback "+s+" size "+l+" data "+root.data);
	        }
	       
	       System.out.println();
	        if(root.right!=null)
	        {
	            sum(root.right,sum-root.data,list,l,s);
	            //l.remove((Integer)root.right.data);
	          //deleting root.left when coming back 
	            remove(l,root.right.data);
	           // System.out.println("rightback "+s+" size "+l+" data "+root.data);
	        }
	        
	    }
	  public static void remove(List<Integer>list,int i)
	    {
		  // deleting from last as in some case duplicate values are there 
		  // and remove() function always delete from starting hence we used this function 
	        for(int q=list.size()-1;q>=0;q--)
	        {
	            if(list.get(q)==i)
	            {
	                list.remove(q);
	                break;
	            }
	        }
	    }
}



















