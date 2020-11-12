package leetcode;



public class _160_InterSectionOfTwoLinkedList {
	
	public static void main(String[] args) {
		
		
		ListNode n1=new ListNode(8);
		ListNode n2=new ListNode(4);
		ListNode n3=new ListNode(5);
		
		
		//first list
		ListNode node1=new ListNode(4);
		
		node1.next=new ListNode(1);
		node1.next.next=n1;
		n1.next=n2;
		n2.next=n3;
		
		//second list
		ListNode node2=new ListNode(5);
		
		System.out.println("5 of 2nd "+node2);
		node2.next=new ListNode(0);
		node2.next.next=new ListNode(1);
		node2.next.next.next=n1;
		
		//getIntersectionNode(node1,node2);
		getIntersectionNodeAlter(node1,node2);
		
	}
	public static ListNode getIntersectionNodeAlter(ListNode headA, ListNode headB)
	{
		ListNode A=headA;
		
		ListNode B=headB;
		
		int countA=0;
		int countB=0;
		while(A.next!=null || B.next!=null)
		{
			if(A.next==null)
			{
				countA++;
			}
			else
			{
				A=A.next;
			}
			if(B.next==null)
			{
				countB++;
			}
			else
			B=B.next;
		}
		System.out.println("b "+B.val);
		System.out.println("count a "+countA);
		System.out.println("count b "+countB);
		
		
		if(countA!=0)
			while(countA>=0)
			{
				
				System.out.println("here"+B.val);
				if(B.next==null) {
					B=headB;
				countA--;
				}
				B=B.next;
				countA--;
			
					
			}
		if(countB!=0)
			while(countB>=0)
			{
				if(A.next==null) {
					A=headA;
				countB--;
				}
				A=A.next;
				countB--;
					
			}
		System.out.println("a "+A.val);
		System.out.println("b "+B.val);
		
		System.out.println("asdds");
		if(A.next==null)
		{
			A=headA;
		}
		if(B.next==null)
			B=headB;
		while(A!=null && B!=null)
		{

			
			  if(A.next==null) { A=headA; } 
			  if(B.next==null) { B=headB; }
			 
			System.out.println("a "+A.val);
			System.out.println("b "+B.val);
			
			System.out.println("Iterating");
			if(A==B)
			{
				System.out.println("found at "+A.val);
				break;
			}
			
			A=A.next;
			B=B.next;
		}
		System.out.println("after b "+B.val);
		
		System.out.println("count "+countA);
		
		
		return null;
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		//working
    
		if(headA==null || headB==null)
		{
			return null;
		}
		//traversing 1st linked list
		ListNode n=headA;
		
		while(n!=null)
		{
			System.out.println(n.val);
			if(n.next==null)
			{
				System.out.println("heare");
				break;
			}
			n=n.next;
			
		}
		n.next=headB;
		System.out.println("headA "+n.val);
		
	//Applying floyd and here	
		
		System.out.println("head A"+ headA.val);
		ListNode slow=headA;
		ListNode fast=headA;
		
		System.out.println();
		//traversing 2nd linked list
		
			while(fast!=null && fast.next!=null)
			{					
				slow=slow.next;
				fast=fast.next.next;
				
				if(slow==fast)
				{
					
					break;
				}
			}
			
			System.out.println("cycle exitst");
			System.out.println("slow "+slow.val);
			
			ListNode q=headA;
			System.out.println("q "+q.val);
			ListNode p=slow;
			while(q!=p)
			{
				q=q.next;
				p=p.next;
			}
			System.out.println("p "+p.val);
			
			n.next=null;
			while(headA!=null)
			{
				System.out.println(headA.val);
			
				headA=headA.next;
				
			}
		
		return null;
		
    }

}
