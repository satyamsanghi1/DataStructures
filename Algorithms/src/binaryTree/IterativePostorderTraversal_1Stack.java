package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostorderTraversal_1Stack {
	
	public static void main(String[] args) {
		
		
		Node node=new Node(10);
		
		node.left=new Node(5);
		
		
		node.right=new Node(15);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(18);
		
		 
	        postOrder(node);
	       
	}
	
	  public static void postOrder(Node root)
	    {
		  // not working 
		  Stack<Node>stack=new Stack<Node>();
			 Node current=root;
		  stack.push(root);
		  
	        while(!stack.isEmpty() || current!=null)
	        {
	        	if(current!=null)
	        	{
	        		stack.push(current);
	        		current=current.left;
	        	}
	        	else
	        	{
	        		Node temp=stack.peek().right;
	        		
	        		if(temp==null)
	        		{
	        			temp=stack.pop();
	        			System.out.println(temp.data);
	        			
	        			while(!stack.isEmpty() && temp==stack.peek().right)
	        			{
	        				temp=stack.pop();
	        				System.out.println(temp.data);
	        			}
	        		}
	        		else
	        		{
	        			current=temp;
	        		}
	        	}
	        	//System.out.println(current.data);

	        }
	       
	        //System.out.println(post);
	    }

}
