package interview;

import java.util.LinkedList;

public class RotateLinkedList {


	public static void main(String[] args) {


		LinkedList head=new LinkedList(0);
		head.next=new LinkedList(1);
		head.next.next=new LinkedList(2);
		head.next.next.next=new LinkedList(3);
		head.next.next.next.next=new LinkedList(4);
		head.next.next.next.next.next=new LinkedList(5);
		
		LinkedList n=shiftLinkedList(head,-3);
		traverse(n);
	}
	public static LinkedList shiftLinkedList(LinkedList head, int k) {

		int size=getSize(head);
		System.out.println("size "+size);
		k=k%size;
		System.out.println("k "+k);
		if(k==0)
			return head;

		if(k<0)
		{
			k=size+k;
		}
		System.out.println("k "+k);

		LinkedList current=head;
		int count=0;
		while(current!=null && count<k)
		{
			current=current.next;
			count++;
		}
		if(current==null)
			return head;

		LinkedList h=head;
		while(current.next!=null && h!=null)
		{
			h=h.next;
			current=current.next;
		}
		LinkedList newHead=h.next;
		h.next=null;
		current.next=head;

		return newHead;
	}
	public static int getSize(LinkedList head)
	{
		int count=0;
		LinkedList cur=head;
		while(cur!=null)
		{
			cur=cur.next;
			count++;
		}
		return count;
	}
	
	public static void traverse(LinkedList head)
	{
		LinkedList c=head;
		while(c!=null)
		{
			System.out.print(c.value+" ");
			c=c.next;
		}
		System.out.println();
	}
	static class LinkedList {
		public int value;
		public LinkedList next;

		public LinkedList(int value) {
			this.value = value;
			next = null;
		}
	}
}
