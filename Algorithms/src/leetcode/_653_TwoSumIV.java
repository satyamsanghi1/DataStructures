package leetcode;

import java.util.HashSet;

public class _653_TwoSumIV {

	
	public static void main(String[] args) {
		
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(6);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		
		root.right.right=new TreeNode(7);
		
		 boolean ans=findTarget(root,6);
		 System.out.println("ans "+ans);
	}
	 public static boolean findTarget(TreeNode root, int k) {
	        
		//SOLUTION 1 : traversing the whole BST with use of hashset
		 
		 /*If want to use property of BST : its inorder is sorted
		  * add in the list , then use two pointer approach to find the pair
		  * 
		  */
			 HashSet<Integer>set=new HashSet<>();
		return	 search(root, k, set);
		
	    }
	 
	 public static boolean search(TreeNode root,int searchValue,HashSet<Integer>set)
	 {
		 if(root==null)
			 return false;
		 System.out.println("root "+root.val);
		//int big= Math.max(root.val,searchValue);
		//int small=Math.min(root.val,searchValue);
		 
		//System.out.println("big "+big+" small "+small+" diff "+(big-small));
		int diff=searchValue-root.val;
		System.out.println("diff "+diff);
		if(set.contains(diff))
		{
			return true;
		}
		else
		{
			set.add(root.val);
		}
		 
		if(diff<=root.val)
		 if( search(root.left,searchValue,set))
			 return true;
		 
		if(diff>=root.val)
		 return search(root.right,searchValue,set);
		 
		 return false;
		
	 }
}
