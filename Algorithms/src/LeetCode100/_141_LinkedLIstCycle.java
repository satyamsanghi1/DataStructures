package LeetCode100;

import leetcode.ListNode;

/// TORTOISE AND HARE ALGORITHM TO FIND CYCLE IN LINKED LIST ///


public class _141_LinkedLIstCycle {
	
	public static void main(String[] args) {
		
		
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=null;
		
		
		
	ListNode x=	findCycle(node1);
	System.out.println();
		/*
		 * System.out.println(); System.out.println("x "+x.val);
		 */
	
		if(x!=null)
		{
			System.out.println("cycle exists");
		}
		else
			System.out.println("no cycle");
	
	}
	
	
	
	
	// alter : we add node in list and if that node comes again in list we return true;
	
	
	public static ListNode findCycle(ListNode root)
	{
		
		ListNode node=null;

		ListNode slow=root;
		ListNode fast=root;
		while( fast!=null && fast.next!=null)
		{
			System.out.println("slow "+slow.val);
			System.out.println("fast "+fast.val);
			//System.out.println();
			slow=slow.next;
			fast=fast.next.next;
		if(slow==fast)
		{
		
			node=fast;
			//System.out.println("node "+node.val);
			
			break;
		}
			
		}
		
		return node;
	}

}
