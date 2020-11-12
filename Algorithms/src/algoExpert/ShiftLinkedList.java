package algoExpert;

import algoExpert.ShiftLinkedList.LinkedList;

public class ShiftLinkedList {
	
	public static void main(String[] args) {
		
		LinkedList head=new LinkedList(0);
		head.next=new LinkedList(1);
		head.next.next=new LinkedList(2);
		head.next.next.next=new LinkedList(3);
		head.next.next.next.next=new LinkedList(4);
		head.next.next.next.next.next=new LinkedList(5);
		
		LinkedList newHead=shiftLinkedList(head,2);
		traverse(newHead);
	}
	 public static LinkedList shiftLinkedList(LinkedList head, int k) {
		 
		 int size=1;
		 LinkedList temp=head;
		 
		 while(temp.next!=null)
		 {	 
			 size++;
			 temp=temp.next;
			
			 
		 }
		 System.out.println("temp "+temp.value);
		 System.out.println("size "+size);
		 k=k%(size);
		 if(k==0)
			 return head;
		 int listLength=0;
		 if(k>0)
			 listLength=size-k;
		 else
			 listLength=-k;
		 LinkedList newTail=head;
		
		 System.out.println("list length "+listLength);
		//here we are dealing with linked list not array 
		 //hence starting with 1 
		 for(int i=1;i<listLength;i++)
		 {
			 newTail=newTail.next;
		 }
		 System.out.println("new Tail "+newTail.value);
		 LinkedList newHead=newTail.next;
		 newTail.next=null;
		 temp.next=head;
		 
		 return newHead;
	 }
	
	 public static LinkedList shiftLinkedList1(LinkedList head, int k) {
		    //my solution using two pointers
		
			int size=0;
			LinkedList a=head;
			while(a!=null)
			{
			size++;
				a=a.next;
			}
			System.out.println("size "+size);
			if(k>size)
			{
				k=k%size;
			}
			 if (k<0)
			{
				 if(k<-size)
				 {
					k=k%size	;
				 }
				k=size+k;
			}
			if(k==size)
				return head;
			System.out.println("k "+k);
			 /*moving for k times ahead 
			  * then moving prev and forward to the end
			  * 
			  */
			LinkedList prev=head;
			LinkedList forward=head;
			int z=0;
			while(forward.next!=null && z<k)
			{
			forward=forward.next;
				z++;
			}
			System.out.println("forward "+forward.value);
			while(forward.next!=null && prev.next!=null)
		{
		forward=forward.next;
		prev=prev.next;
		}
			System.out.println("prev "+prev.value);
			System.out.println("forward "+forward.value);
			forward.next=head;
	    LinkedList b=prev.next;
			prev.next=null;
			return b;
	  }
	 public static void traverse(LinkedList head)
	 {
		 System.out.println();
		 while(head!=null)
		 {
			 System.out.print(head.value+" ");
			 head=head.next;
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
