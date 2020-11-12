package algoExpert.LeetCodeVersion;

import java.util.LinkedList;
import java.util.Queue;


public class _116_PopulatingNextRightPointersInEachNode {
	// next variant 117
	public static void main(String[] args) {
		
		Node root=new Node(1);
		root.left=new Node(2);
		
		root.left.left=new Node(4);
		root.left.right=new Node(5);
	
		root.left.left.left=new Node(8);
		root.left.left.right=new Node(9);
		
		root.left.right.right=new Node(11);
		root.left.right.left=new Node(10);
		
		root.right=new Node(3);
		
		root.right.right=new Node(7);
		root.right.left=new Node(6);
		
		root.right.left.left=new Node(12);
		root.right.left.right=new Node(13);
		
		root.right.right.left=new Node(14);
		root.right.right.right=new Node(15);
		
		mutate(root,false,null);
		
	
	}
	 public static void mutateAlter(Node root,boolean isleftNode,Node parent) {
		  // 100% 
		 // works because we dont have to change the right pointer 
		 // we just have to update the next pointer of every node 
		 // for that we just pass the parent node to every node
			if(root==null)
				return ;
			
			if(parent==null)
			{
				System.out.println("root "+root.val);
				root.next=null;
			}
			else if(isleftNode)
			{
				System.out.println("left ");
				System.out.println("root "+root.val+" parent "+parent.val);
				root.next=parent.right;
			}
			else
			{
				System.out.println("right node "+root.val);
				if(parent.next!=null)
				{
					System.out.println("parent next "+parent.next.val);
					root.next=parent.next.left;
					System.out.println("root next "+root.next.val);
				}
				else
				{
					System.out.println("parent next is null");
					root.next=null;
				}
			}
			System.out.println("-------------------------");
			mutateAlter(root.left,true,root);
			mutateAlter(root.right,false,root);
			
		}
	  public static Node mutate(Node root,boolean isleftNode,Node parent) {
		  //Algo expert solution 
		  
			//depth first search
			if(root==null)
				return null;
		
		
			Node left=root.left;
			Node right=root.right;
			
			mutate(left,true,root);
			
			if(parent==null)
			{
				root.next=null;
			}
			else if(isleftNode==true)
			{
				root.next=parent.right;
			}
			else
			{
				if(parent.next!=null)
				{
					root.next=parent.next.left;
				}
				else
				{
					root.next=null;
				}
			System.out.println("root "+root.val+" parent "+parent.val);
			System.out.println("left "+isleftNode);
			System.out.println("------------------------");
			}
			mutate(right,false,root);
			return root;
			
		}
	

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
