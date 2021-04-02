package algoExpert;

import leetcode.ListNode;

public class SumOfLinkedLists {
	//Leetcode 2 AddTwoNumbers


	public static void main(String[] args) {
		//1742
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next=new ListNode(7);
		l1.next.next.next=new ListNode(1);

		//549
		ListNode l2=new ListNode(9);
		l2.next=new ListNode(4);
		l2.next.next=new ListNode(5);
		//l1.next.next.next=new ListNode(1);
		
	ListNode ans=IterativeSolution(l1, l2);
	print(ans);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//print(l1);
		ListNode head=new ListNode(0);
		helper(l1,l2,0,head);
		return head.next;
	}
	public static ListNode IterativeSolution(ListNode l1, ListNode l2)
	{
		//Leetcode version
		ListNode a=l1;//pointer for l1
		ListNode b=l2;//pointer for l2
		ListNode ans=new ListNode(0);
		ListNode cur=ans;
		int carry=0;
		
		//carry condition because of l1->2 , l2-> 9 , at the end last digit be carry
		while(a!=null || b!=null || carry!=0)
		{
			int valueOne=a!=null?a.val:0;
			int valueTwo=b!=null?b.val:0;
			int num=carry+valueOne+valueTwo;
			
			System.out.println("value1 "+ valueOne+" value2 "+valueTwo);
			int toAdd=num%10;
			carry=num/10;
			System.out.println("to add "+toAdd+" carry "+carry);
			ans.next=new ListNode(toAdd);
			ans=ans.next;
			if(a!=null)
				a=a.next;
			
			if(b!=null)
				b=b.next;
			
			System.out.println("-------------");
		}
		return cur.next;
	}
	public static void helper(ListNode l1,ListNode l2,int carry,ListNode head )
	{
		//my solution (Leetcode 100%Fast)(Recursive)
		
		if(l1==null && l2==null)
		{
			if(carry>0)
			{
				head.next=new ListNode(carry);
			}
			return ;
		}
		
		int num=carry;
		ListNode next1=null;
		ListNode next2=null;

		if(l1!=null)
		{
			num+=l1.val;
			next1=l1.next;
		}
		if(l2!=null){
			next2=l2.next;
			num+=l2.val;
		}
		int toAdd=num%10;
		int nextCarry=num=num/10;
		System.out.println("to add "+toAdd+" carry "+nextCarry);

		head.next=new ListNode(toAdd);
		helper(next1,next2,nextCarry,head.next);
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
