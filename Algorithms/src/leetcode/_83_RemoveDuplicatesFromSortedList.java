package leetcode;


public class _83_RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		
		////This solution works only when the linked list is sorted
		
		ListNode node=new ListNode(1);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(3);
		
		node.next=node1;
		node1.next=node2;
		//node2.next=null;
		node2.next=node3;
		node3.next=node4;
		node4.next=null;
		
		ListNode n=removeDuplicates(node);
		
		System.out.println("Traversing");
		traverse(n);
		
		
		
	}
	
	public static ListNode removeDuplicates(ListNode node)
	{
		boolean flag=false;
		ListNode node1=node;
		while(node1!=null)
		{
			System.out.println("a "+node1.val);
			if(node1.next!=null)
			System.out.println("b "+node1.next.val);
			if(node1.next!=null)
			if(node1.val==node1.next.val)
			{
				flag=true;
				System.out.println("called");
				node1.next=node1.next.next;
			}
			if(flag==false)
			node1=node1.next;
			else if(flag==true) {
				flag=false;
				//node1=node1;
			}
		}
		return node;
	}
	
	public static void traverse(ListNode node)
	{
		while(node!=null)
		{
			System.out.println(node.val);
		
			node=node.next;
		}
	}

}
