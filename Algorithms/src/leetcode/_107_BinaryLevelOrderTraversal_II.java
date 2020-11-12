package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import binaryTree.DepthOfBinaryTree;
import binaryTree.Node;

public class _107_BinaryLevelOrderTraversal_II {
	
	
	///Also we  can add into the 0th index of parent list 
	// when we add the list in the parent list for next time to 0th index
	// it will automatically shift it backwards 
	
	public static void main(String[] args) {
		
		Node node=new Node(1);
		node.left=new Node(2);
		node.right=new Node(3);
		
		node.left.left=new Node(4);
		node.left.right=new Node(5);
		
		node.right.left=new Node(6);
		node.right.right=new Node(7);
		
		node.left.right.left=new Node(8);
		node.left.right.right=new Node(9);
		
		///alter solution 
		// much faster than the previous solution 
		levelOrderBottomAlter(node);
		
		//int depth=DepthOfBinaryTree.findHeight(node);
		//System.out.println("Depth "+depth);
		
		System.out.println("Traversing ");
		
		
		//levelOrderBottom(node);
		
	
		/*
		 * ArrayList<Integer> x= levelOrder(node,depth+1,new ArrayList<Integer>());
		 * 
		 * for(int a:x) { System.out.print(a+" "); }
		 */
	//System.out.println("x "+x);
	}
	
	

	
	 public static List<List<Integer>> levelOrderBottomAlter(Node node)
	 {
		 
		 /*
		  * In this solution we have used a queue and stack 
		  * we find elements of each level into the queue
		  * and then push them into the stack 
		  * after that we populate the list with stack
		  * 
		  * we used stack so that we could reverse the list 
		  * 
		  * 
		  */
		 
		 int depth=DepthOfBinaryTree.findHeight(node);

		 
		 System.out.println("Calculation ");
		 System.out.println();
		  List<List<Integer>>a=new ArrayList<>();
		  
		  Queue<Node>queue=new LinkedList<>();
		  queue.add(node);
		//  int size=queue.size();
		  Stack<List<Integer>>stack=new Stack<>();;
		 while(!queue.isEmpty())
		 {
			 int size=queue.size();
			 
			 List<Integer> x=null;
			 Node n=null;
			 
			 System.out.println("size "+size);
			 x=new ArrayList<>();
			 for(int i=0;i<size;i++) {
				
				 
				n=queue.poll();
			 System.out.print(n.data+" ");
			 x.add(n.data);
			 if(n.left!=null)
				 queue.add(n.left);
			 if(n.right!=null)
				 queue.add(n.right);
			 }
			 System.out.println();
		
			
			 System.out.print("list to be added  ");
			 for(int i:x)System.out.print(i+" ");
			 System.out.println();
			 stack.push(x);
			 System.out.println("stack "+stack);
			// a.add(k, x);
			// x=null;
			// System.out.println(a);
			// k++;
			 
			 
		 }
		 System.out.println();System.out.println("stack size "+stack.size());
		 for(List s:stack)
		 {
			System.out.println("value "+s); 
		 }
		 System.out.println();System.out.println();
		 int k=0;
		 List<List<Integer>>list=new ArrayList<>();
		 while(!stack.isEmpty())
		 {
			 list.add(stack.pop());
		 }
		 System.out.println("Final answer");
		 System.out.println(list);
		  
		  
		  
		  
		 
		  
		  return a;
	 }
	public static ArrayList<Integer> levelOrder(Node node,int level,ArrayList<Integer> list)
	{  
	    ArrayList<Integer>subarray=new ArrayList<>();
		if(level==1)
		{
			list.add(node.data);
			//System.out.println(node.data);
		}
		
		if(node.left!=null)
		levelOrder(node.left,level-1,list);
		if(node.right!=null)
		levelOrder(node.right,level-1,list);
		
		return list;
	}
	
	 public static List<List<Integer>> levelOrderBottom(Node node) {
		 int depth=DepthOfBinaryTree.findHeight(node);
		 depth++;
		 
	        List<List<Integer>>a=new ArrayList<>();

		 for(int i=depth;i>=1;i--)
		 {
			 System.out.println("creating list for depth "+i);
				ArrayList<Integer> x=	levelOrder(node,i,new ArrayList<Integer>());
				for(int q:x) { System.out.print(q+" "); }
				a.add(x);
		 }
		 
		 System.out.println("final answer");
		 System.out.println(a);
	        
	        return null;
	        
	        
	    }

}
