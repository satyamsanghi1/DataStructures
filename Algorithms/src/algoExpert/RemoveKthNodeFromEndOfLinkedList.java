package algoExpert;

import leetcode.ListNode;

public class RemoveKthNodeFromEndOfLinkedList {
	public static void main(String[] args) {
		
	ListNode head=new ListNode(1);
	head.next =new ListNode(2);
	head.next.next =new ListNode(3);
	head.next.next.next =new ListNode(4);
	head.next.next.next.next =new ListNode(5);
	
	removeNthFromEnd(head,2);
	}
	 public static ListNode removeNthFromEnd(ListNode head, int n) {
	   
		 /*
		  * We are using two pointer approach : first and second pointer 
		  * Step 1 : we will move second pointer n  nodes ahead of first pointer 
		  * Step 2 : After this we will iterate both the pointer , its obvious that second pointer will reach to null first 
		  * Step 3 : When second will reach end , first will be exactly n nodes behind the end
		  * Step 4 : There is a edge case : in step 1 : 
		  * 		-> if second pointer already reaches the end ,
		  * 		that means , the node to be removed is the first node ,
		  * 		and simply do head=head.next and return as there is nothing to do after it 
		  * 
		  *  Step 5 : as we know first will be the node to be deleted ,
		  *  		but we need its previous node so that we can make the pointer changes 
		  * 		Hence we will iterate till the second.next != null 
		  * 		In this way , first will be one node behind the node to be deleted  
		  * 
		  * 
		  * Step 6 : update the first to its next to next .
		  * 
		  * 
		  * 
		  */
		 ListNode first=head;
		 ListNode second=head;
		 //step 1 
		 for(int i=1;i<=n;i++)
		 {
			 second=second.next;
		 }
		 	//edge case 
		 if(second==null)
		 {
			 head=head.next;
			 return head;
		 }
		 System.out.println("second "+second.val);
		 while( second.next!=null)
		 {
			 second=second.next;
			 first=first.next;	 	
		 }	 
		 first.next=first.next.next;
		 System.out.println("first "+first.val);
		 traverse(head);
		 return null;
	    }
	 public static void traverse(ListNode head)
	 {
		 ListNode current=head;
		 while(current!=null)
		 {
			 System.out.println("current "+current.val);
			 current=current.next;
		 }
	 }
	 

}
