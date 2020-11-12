package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {
	
	public static void main(String[] args) {
		
		Node node=new Node(10);
		
		node.left=new Node(5);
		
		
		node.right=new Node(15);
		
		
		node.left.left=new Node(3);
		
		node.left.right=new Node(7);
		//node.left.right.left=new Node(8);
		
		//node.right.left=new Node(5);
		node.right.right=new Node(18);
		
		 Stack<Node>stack=new Stack<Node>();
	        List<Integer>list=new ArrayList<Integer>();
	        
	      //  traverse(node,stack,list);
	        traversePreOrder(node, stack, list);
	}
	
	public static void traversePreOrder(Node root,Stack<Node>stack,List<Integer>list)
	{
		while(true)
		{
			while(root!=null)
			{
				//print root and push
				
				System.out.println(root.data);
				stack.push(root);
				root=root.left;
			}
			
			if(stack.isEmpty())
				break;
			
			Node n=stack.pop();
			root=n.right;
		}
		
	}
	public static void traverse(Node root,Stack<Node>stack,List<Integer>list)
	{
		while(true)
		{
			
			 	if(root!=null)
			 	{
			 		 System.out.println(root.data);
			 	if(root.right!=null)
			 	{
				 stack.push(root.right);
				
			 	}
			 	else
			 	{
			 		//System.out.println("ere");
			 	}
			 	 root=root.left;
			 	}
			 	else
			 	{
			 		if(stack.isEmpty())
			 			break;
			 	
			 		root=stack.pop();
			 	}
			// System.out.println(stack.size());
			 //break;
		}
	}

}
