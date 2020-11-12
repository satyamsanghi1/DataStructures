import leetcode.ListNode;

public class AddOneInLinkedList {

	public static void main(String[] args) {
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(3);
		ListNode n3=new ListNode(8);
		
		n1.next=n2;
		n2.next=n3;
		
		int y=add(n1);
		ListNode n=null;
		ListNode head=null;
		if(y==1)
		{
			 n=new ListNode(1);
			n.next=n1;
			head=n;
		}
		else
			head=n1;
		
		System.out.println("return value "+y);
		System.out.println("traversing");
		traverse(head);
	}
	
	public static int add(ListNode head)
	{
		
		if(head.next!=null) {
		int x=add(head.next);
		if(x==0)
		{
			return 0;
		}	
		}
		if(head.val<9)
		{
			System.out.println("val "+head.val);
			++head.val;
			return 0;
		}
		else
		{
			head.val=0;
			return 1;
		}
		
	}
	
	public static void traverse(ListNode head)
	{
		if(head==null)
			return ;
		
		System.out.print(head.val+" ");
			traverse(head.next);
	
		
	}
}
