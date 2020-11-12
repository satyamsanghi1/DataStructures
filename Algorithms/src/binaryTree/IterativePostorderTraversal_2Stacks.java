package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostorderTraversal_2Stacks {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		
		node.left=new Node(5);
		
		
		node.right=new Node(15);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(18);
		
		 
	        List<Integer>list=new ArrayList<Integer>();
	        
	        postOrder(node, list);
	       
	}
	
	  public static void postOrder(Node root,List<Integer>list)
	    {
		  Stack<Node>stack1=new Stack<Node>();
			 Stack<Node>stack2=new Stack<Node>();
			 
			 List<Integer>post=new ArrayList<>();
			 
		  stack1.push(root);
		  
	        while(!stack1.isEmpty())
	        {
	        	Node n=stack1.pop();
	                stack2.push(n);
	                System.out.println(n.data);
	               // System.out.println("stack 2"+stack2);
	               
	               if(n.left!=null)
	            	   stack1.push(n.left);
	               
	               if(n.right!=null)
	            	   stack1.push(n.right);
	            	   

	        }
	        while(!stack2.isEmpty())
	        {
	        	post.add(stack2.pop().data);
	        }
	        
	        System.out.println(post);
	    }

}
