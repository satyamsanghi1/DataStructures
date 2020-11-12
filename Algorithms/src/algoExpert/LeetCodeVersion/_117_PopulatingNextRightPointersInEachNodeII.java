package algoExpert.LeetCodeVersion;

import java.util.LinkedList;
import java.util.Queue;


public class _117_PopulatingNextRightPointersInEachNodeII {
	// next variant 117
	public static void main(String[] args) {
		
		Node root=new Node(1);
		root.left=new Node(2);
		
	//	root.left.left=new Node(4);
		//root.left.right=new Node(9);
	
		//root.left.left.left=new Node(6);
	
		root.right=new Node(3);
		
		root.right.right=new Node(5);
		root.right.left=new Node(4);
	//	root.right.right.right=new Node(7);
		connect(root);
		//System.out.println(root.left.left.next.val);

	}
	 public  static Node connect(Node root) {
	        
		Node current=root;	//current node for current level
		Node head=null;	// head for the next level
		Node prev=null; //node to update its next pointer
		
		while(current!=null) //iterating the next level	// horizontally
		{
			while(current!=null)// iterating on the current level //vertically
			{
				if(current.left!=null)
				{
					if(prev!=null)
					{
						prev.next=current.left;
					}
					else
					{	//if our prev node is null and currents left node is not null
						// this means this is the first node in this level
						head=current.left;
					}
					//updating prev node  as left is not null 
					// this will act as prev for next node in this level
					prev=current.left;
				}
				if(current.right!=null)
				{
					if(prev!=null)
					{
						//if prev not null and current right is also not null
						// then we assign the next pointer of prev node to the current
						// nodes right node
						prev.next=current.right;
					}
					else
					{	
						//if prev is still null , this means this is the first head node
						head=current.right;
					}
					prev=current.right;
				}
				current=current.next ;// move to next node , means right in current level
			}
			//moving down the level by asssignning current as the head in the prev level
			// we traversed above
			current=head;
			head=null;
			prev=null;
		}
		
		
	      return root;
	    }
	 
	
	

}



