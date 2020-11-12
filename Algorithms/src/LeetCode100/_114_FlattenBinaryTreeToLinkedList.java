package LeetCode100;

import java.util.Stack;

import binaryTree.TreeNode;

public class _114_FlattenBinaryTreeToLinkedList {
	
	//LINK -https://www.youtube.com/watch?v=vssbwPkarPQ
	public static void main(String[] args) {
		
			TreeNode root=new TreeNode(1);
			root.left=new TreeNode(2);
			root.right=new TreeNode(5);
			
			//root.left.left=new TreeNode(3);
			//root.left.right=new TreeNode(4);
			
			//root.right.left=new TreeNode(3);
			
			//root.right.right=new TreeNode(6);
			
			//traverse(root);
				flatten1(root);
				 System.out.println("--------------");
				 traverse(root);

	}
	 public static void flatten(TreeNode root) {
	        
		 Stack<TreeNode>stack=new Stack<>();
		// TreeNode current=root;
	
		 //TreeNode node=helper(root, stack);
		 helper1(root);
		 System.out.println("--------------");
		 traverse(root);
	    }
	 
	 public static void flatten1(TreeNode root) {
		 //SOLUTION 3
		 Stack<TreeNode>stack=new Stack<>();
		 
		 stack.push(root);
		 
		 while(!stack.isEmpty())
			 
		 {
			 TreeNode current=stack.pop();
			 System.out.println("current "+current.val);
			
			 
			 if(current.right!=null)
				 stack.push(current.right);
			 
			 if(current.left!=null)
				 stack.push(current.left);
			if(!stack.isEmpty())
			 current.right=stack.peek();
			
			current.left=null;
		 }
	 }
	 
	 public static TreeNode helper1(TreeNode root )
	 {//SOLUTION 2
		//50%Fast , 90% Space
		 System.out.println("current "+root.val);
		 
		 if(root.left==null && root.right==null)
			 return root;
		 
		
		 TreeNode a=null,b=null;
		 if(root.left!=null)
		 {
			 a=helper1(root.left);
		 }
		 if(root.right!=null)
		 {
			 b=helper1(root.right);
			 
			
		 }
		
		if(a!=null)
			System.out.println("a "+a.val);
		else
			System.out.println("a null");
		if(b!=null)
			System.out.println("b "+b.val);
		else
		System.out.println("b null");
		System.out.println("root "+root.val);
		
		 root.left=null;
		 if(a!=null)
		 {
			 root.right=a;
			 
		 while(a.right!=null)
		 {
			 a=a.right;
			 System.out.println("ajssd");
		 }
		 if(a.right!=null)
		 System.out.println("a.right "+a.right.val);
		 a.right=b;
		 }

		 return root;
	 }
	 
	 public static TreeNode helper(TreeNode root, Stack<TreeNode>stack )
	 {	//SOLUTION 1
		 //5% ,5%
		 System.out.println("current "+root.val);
		 if(root.left!=null)
		 {
			if(root.right!=null)
			{
				System.out.println("here");
			 stack.push(root.right);
			}
			
			root.right=root.left;
			 helper(root.right,stack);
			 root.left=null; 
		 }
		 if(root.right!=null)
		 {
			 helper(root.right,stack);
		 }
		 while(!stack.isEmpty())
		 {
			 TreeNode node=stack.pop();
			 System.out.println("here "+node.val+"root "+root.val);
			 root.right=helper(node,stack);
		 }
		 
		 return root;
	 }
	 
	 public static void traverse(TreeNode root)
	 {
		 if(root==null)
			 return ;
		 System.out.println(root.val);
		 
		 if(root.left!=null)
		 {
			 System.out.println("left");
		 traverse(root.left);
		 }
		 if(root.right!=null)
		 {
			 System.out.println("right");
		 traverse(root.right);
		 }
	 }

}
