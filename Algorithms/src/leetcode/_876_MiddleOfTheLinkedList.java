package leetcode;

public class _876_MiddleOfTheLinkedList {

	static ListNode h=null;
	
	public static void main(String[] args) {
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		ListNode n5=new ListNode(5);
		//ListNode n6=new ListNode(6);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		//n5.next=n6;
		
		middleNode(n1);
		System.out.println(Integer.parseInt("101",2));
		//System.out.println("miidlle is "+h.val);
	}
	
	
	public static ListNode middleNode(ListNode head) {

		
		//middle(head,1);
		middleAlter(head);
		return null;
	}
	public static ListNode middleAlter(ListNode head)
	{
		ListNode slow=head;
		ListNode fast=head;
		
		
		while(fast!=null && fast.next!=null)
		{
			
			slow=slow.next;
			fast=fast.next.next;
			
			
		}
		System.out.println(slow.val);
		
		return null;
	}
		public static double middle(ListNode head,int val)
		{
			System.out.println("val "+head.val+" "+val);
			double x=0;
			if(head.next!=null) {
				 x=middle(head.next,val+1);
			
			System.out.println("x "+x +"val "+val);
				if(x==0)
					return 0;
				/* if(x*10%10==5)
				{
					System.out.println("here"+val);
					 x+=.5;
				}
				 */
				 if(x==val)
				{
					System.out.println("middle "+head.val);
					 h=head;
					return 0;
				}
				
				else
					return x;
				
			}
			System.out.println("ret "+(((double)val/2)*10%10==0));
			return (double)val/2*10%10==0?((double)val/2)+1:((double)val/2)+0.5;
		}
}
