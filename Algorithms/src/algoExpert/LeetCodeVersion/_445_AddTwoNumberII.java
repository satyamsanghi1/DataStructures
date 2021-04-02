package algoExpert.LeetCodeVersion;

import java.util.Stack;

import leetcode.ListNode;

public class _445_AddTwoNumberII {
	//follow up of leetcode 2 and (algoexpert)

	public static void main(String[] args) {
		
		// add the number from behind
		//7243
		ListNode l1=new ListNode(7);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		l1.next.next.next=new ListNode(3);

		//564
		ListNode l2=new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next=new ListNode(4);
		//l1.next.next.next=new ListNode(1);

		ListNode ans=addTwoNumbers(l1, l2);
		print(ans);
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//63%Fast
		/*
		 * create a new node everytime 
		 * add the prev node to the next of this new node
		 * 
		 */
		Stack<Integer> s1=helper(l1);
		Stack<Integer> s2=helper(l2);
	
		ListNode head=new ListNode(0);
		ListNode cur=head;
		int carry=0;
		while(!s1.isEmpty() || !s2.isEmpty() || carry!=0)
		{
			int valueOne=s1.isEmpty()?0:s1.pop();
			int valueTwo=s2.isEmpty()?0:s2.pop();
			int num=valueOne+valueTwo+carry;

			int toAdd=num%10;
			carry=num/10;
			System.out.println("num "+num+" toAdd "+toAdd+" carry "+carry);
			head.val=toAdd;
			ListNode n=new ListNode(0);
			n.next=head;
			head=n;
		}
		
		return head.next;
	}
	public static Stack<Integer> helper(ListNode head)
	{
		Stack<Integer>stack=new Stack<>();
		ListNode cur=head;
		while(cur!=null)
		{
			stack.add(cur.val);
			cur=cur.next;
		}
		return stack;
	}
	
	public static void print(ListNode head)
	{
		ListNode cur=head;
		System.out.println();
		while(cur!=null)
		{
			System.out.print(cur.val+" ");
			cur=cur.next;
		}
		System.out.println();
	}

}
