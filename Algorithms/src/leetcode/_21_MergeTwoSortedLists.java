package leetcode;

public class _21_MergeTwoSortedLists {
	static int x=0;
	public static void main(String[] args) {
		
		ListNode l1=new ListNode(2);
		l1.next=new ListNode(6);
		l1.next.next=new ListNode(7);
		l1.next.next.next=new ListNode(8);
		
		ListNode l2=new ListNode(1);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(4);
		l2.next.next.next=new ListNode(5);
		l2.next.next.next.next=new ListNode(9);
		l2.next.next.next.next.next=new ListNode(10);
		
		
		ListNode head=mergeTwoLists2(l1, l2);
		traverse(head);
		
	}
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		//recursion
		System.out.println((-8%6));
		ListNode h1=l1;
		ListNode h2=l2;
		recurse(l1, l2,null);
		return h1.val<h2.val?h1:h2;
	}
	public static void recurse(ListNode l1, ListNode l2,ListNode prev) {
		//time -(O)N+M space -> (O)N+M because of space on the function call stack
		if(l1==null )
		{
			System.out.println("prev "+prev.val);
			prev.next=l2;
			return ;
		}
		if(l2==null)
			return ;
		
		
		System.out.println("l1 "+l1.val+" l2 "+l2.val);
		if(l1.val<l2.val)
		{
			recurse(l1.next,l2,l1);
		}
		else
		{
			if(prev!=null)
			prev.next=l2;
			
			prev=l2;
			ListNode temp=l2.next;
			prev.next=l1;
			recurse(l1,temp,l2);
		
		}
		
	}
	
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
       // time (O)N+M , space-. (O)1
		/*Approach : In order to solve this : we will consider l1 as our list 
		 * which we will be going to return . 
		 * we will require a prev pointer so as to point it to the current appropriate node
		 * 
		 */
		ListNode h1=l1;
		ListNode h2=l2;
		ListNode prev=null;
		ListNode head=l1;
		while(l1!=null && l2!=null)
		{
			
		
			if(l1.val<l2.val)
			{
				// if l1 is smaller , then continue , and update prev pointer
				System.out.println("if");
				prev=l1;
			l1=l1.next;
			}
			else
			{
				//edge case
				
				/*
				 * if(prev==null)
				
				 l1 2->6->
					l2 1->3
			 for first node if l2 is smaller then:
				
			point prev to l2   as it is going to be prev node ,
			prev =1 :  we have to make 1->2 also we have to move l2 to 3
			if we point prev.next to 2 , we will lose 3 hence  before it 
			we move l2=l2.next
			now l2 =3 ;
			prev=1 
			l1=2 
			now prev.next=l1;
			we successfly made the pointer changes
			1------->2------>3
			prev	l1       l2
			the next pointer of prev has to be pointed to l1 
			 * 
			 * we will not increase l1 as we may find value in l2 less than 2 
			 */
				
				
				//when prev is not null;
				/*We perform the same operations above : just here our prev is not null
				 * 
				 * eg : L1 :1-> 2---->6
				 * 				prev  l1
				 * 		
				 * 		L2:3 ---->4
				 * 			L2
				 * 
				 * we have to point our prev 2 to 3 ;
				 * and do similar above steps
				*/
				
					if(prev!=null)
					prev.next=l2;
					
					prev=l2;
					l2=l2.next;
					prev.next=l1;
				
				
				
			}
			
			//System.out.println("prev "+prev.val+" l1 "+l1.val+" l2 "+l2.val);
			System.out.println("------------------------------");
			
		}
		System.out.println("prev "+prev.val);
		if(l2!=null)
		{
			System.out.println("l2 "+l2.val);
			prev.next=l2;
		}
		//return the right head
		return h1.val<h2.val?h1:h2;
	}
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        //my solution
		 if(l1==null && l2==null)
	            return null;
	        if(l1!=null && l2==null)
	            return l1;
	        if(l1==null && l2!=null)
	            return l2;
	        
		 ListNode h1=null;
		 ListNode h2=null;
		 h1=l1.val<l2.val?l1:l2;
		 h2=l2.val>l1.val?l2:l1;
		 
		 ListNode pointTo=null;
		 ListNode head=null;
		 while(h1!=null && h2!=null)
		 {
			 System.out.println("h1 "+h1.val+" h2 "+h2.val);
			 if(h1.val<=h2.val)
			 {
			
				System.out.println("ehre");
				
				 if(pointTo==null)
				 {
					 head=h1;
					 pointTo=h1;
					
				 }
				 else
				 {
					 System.out.println("in "+pointTo.val);
					 pointTo.next=h1;
					 pointTo=h1;
				
				 }
				 h1=h1.next;
			 }
			 else if(h1.val>h2.val)
			 {
				 pointTo.next=h2;
				// h1.next=h2;
				 pointTo=h2;
				 h2=h2.next;
			 }
			 System.out.println("pointTo "+pointTo.val);
			 System.out.println("-------------------------");
		 }
		 if(h2!=null)
			{
				System.out.println("point to "+pointTo.val);
				System.out.println("h2 "+h2.val);
				pointTo.next=h2;
			}
		if(h1!=null)
		{
			System.out.println("point to "+pointTo.val);
			System.out.println("h1 "+h1.val);
			pointTo.next=h1;
		}
		 return head;
	    }
	 public static void traverse(ListNode head)
	 {
		 System.out.println();
		 while(head!=null)
		 {
			 System.out.print(head.val+" ");
			 head=head.next;
		 }
		 System.out.println();
	 }

}
