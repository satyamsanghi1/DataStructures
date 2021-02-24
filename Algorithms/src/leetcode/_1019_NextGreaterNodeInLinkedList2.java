package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class _1019_NextGreaterNodeInLinkedList2 {
	///96%Fast
	
	public static void main(String[] args) {

		ListNode head=new ListNode(2);
		head.next=new ListNode(7);
		head.next.next=new ListNode(4);
		head.next.next.next=new ListNode(3);
		head.next.next.next.next=new ListNode(5);
		
		
		nextLargerNodes(head);
	}
	public static int[] nextLargerNodes(ListNode head) {

		int size=1;
		int x=1;
		System.out.println("size "+size);
		Stack<ListNode>stack=new Stack<>();
	
		stack.push(head);

		ListNode cur=head.next;
		while(cur!=null)
		{
			size++;
			int	val=cur.val;
			while(!stack.isEmpty() && val>stack.peek().val)
			{
				ListNode n=stack.pop();
					n.val=val;
			}
			stack.push(cur);
			cur=cur.next;
		}
		System.out.println("x "+x);
		System.out.println("iterating stack ");
		while(!stack.isEmpty())
		{
			ListNode n=stack.pop();
			n.val=0;
			System.out.println(n.val);
		}
		cur=head;
		int i=0;
		int array[]=new int [size];
		while(cur!=null)
		{
			array[i]=cur.val;
			System.out.println("cur val "+cur.val );
			cur=cur.next;
			i++;
		}
		
		for(int z:array)
		{
			System.out.print(z+" ");
		}

		return array;
	}
	

}
