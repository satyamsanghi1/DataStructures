package algoExpert;

import java.util.ArrayList;

import leetcode.ListNode;

//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
public class PalindromLinkedList2 {
	//Leetcode 234
	//my solution 95% fast using iteration
	
	public static void main(String[] args) {
		
		  ArrayList<Integer>list=new ArrayList<>();
		  
		
	}
	 public boolean isPalindrome(ListNode head) {
	        
		    if(head==null)
	            return true;
	        int size=findSize(head);
			int mid=size/2;
			boolean even=size%2==0;
			return reverse(head,mid,even);
	    }
	    
	 public boolean reverse(ListNode head,int val,boolean even)
		{
			ListNode prev=null;
			ListNode cur=head;
			ListNode temp=null;
			int count=1;
			while(cur!=null && count<=val)
			{
			temp=cur.next;
				cur.next=prev;
				prev=cur;
				cur=temp;
				count++;
			}
		
			if(!even && temp!=null)
				temp=temp.next;
			
			while(temp!=null && prev!=null)
			{
			if(temp.val!=prev.val)
				return false;
				
				temp=temp.next;
				prev=prev.next;
			}
			return true;
		}
		public int findSize(ListNode head)
		{
			int size=1;
			ListNode cur=head;
			while(cur.next!=null)
			{
			size++;
				cur=cur.next;
			}
			return size;
		}
}
