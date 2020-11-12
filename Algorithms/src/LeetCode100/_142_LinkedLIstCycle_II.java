package LeetCode100;

import leetcode.ListNode;

////FLOYD CYCLE DETECTION ALGORITHM  TO FIND POINT OF CYCLE ///////


public class _142_LinkedLIstCycle_II {
	
	public static void main(String[] args) {
		
		
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node2;
		
		
		
	ListNode x=	findCycle(node1);
	
	ListNode cyclePoint=findCyclePoint(node1,x);
//	removeCycle(x,node1);

	System.out.println("cyclePoint "+cyclePoint.val);
	
	System.out.println("removing cycle");
	removeCycle(cyclePoint,x);
	
	traverse(node1);

	
	}
	
	
	
	
	
	
	
	// alter : we add node in list and if that node comes again in list we return true;
	
	
	public static ListNode findCycle(ListNode root)
	{
		
		ListNode node=null;

		ListNode slow=root;
		ListNode fast=root;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			//System.out.println("slow "+slow.val);
			//System.out.println("fast "+fast.val);
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
	
	public static ListNode findCyclePoint(ListNode head,ListNode p)
	{
		
		ListNode q=head;
		
		while(q!=p)
		{
		
			q=q.next;
				p=p.next;
		}
		return p;
	}
	
	public static void removeCycle(ListNode cyclePoint,ListNode x)
	{
		ListNode p=x;
		ListNode q=cyclePoint;
		while(p.next!=q)
		{
			System.out.println("q "+q.val+" ,p "+p.val);
			p=p.next;
			
		}
		System.out.println("outside while "+p.val);
		p.next=null;
	
	}
	
	public static void traverse(ListNode head)
	{
		System.out.println("Traversing");
		while(head!=null)
		{
			System.out.print(head.val+ " ");
			head=head.next;
		}
	}

}
