package LeetCode100;

import java.util.Stack;

import leetcode.ListNode;

public class _206_ReverseLinkedList {

	static	ListNode head1=null;
	
	public static void main(String[] args) 
	{
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=null;
		
	//	ListNode newlist=new ListNode(1);
			//newlist=reverse(n1);
				//ListNode newlist=null;
		
			reverseList(n1);
			
			traverse(head1);
		
	}
	
		public static ListNode reverse(ListNode head)
		{
			ListNode prev=null;
			ListNode temp=null;
			
			
			ListNode node=head;
			while(node!=null)
			{
				System.out.println("node "+node.val);
				
				
				
				if(prev!=null)
					System.out.println("prev "+prev.val);
				
				temp=node.next;
				node.next=prev;
				
				prev=node;
				
				node=temp;
			}
		
			return prev;
			
			
		}
	 public static void reverseList(ListNode head)
	 {
		 
		//using recursion
		 if(head.next==null)
		 {
		System.out.println("null");
		 head1=head;
		return;
		 
		 }
		 
		 reverseList(head.next);
		 
		 System.out.println("val "+head.val);
		 
		//ListNode temp=head;
		head.next.next=head;
		head.next=null;
		
		 System.out.println();
		
	 }
	 
	 public static void traverse(ListNode head)
	 {
		 System.out.println("traversing");
		 while(head!=null)
		 {
			 System.out.println(head.val);
			 head=head.next;
		 }
	 }
}
