package leetcode;

public class _0328_OddEvenLinkedList {
	
	public static void main(String[] args) {
		
	// when come to even index  at node n do this
		//1 . swap its next pointer to its next to next ,store n's next in temp;
		//2 . maintain a pointer for odd like t 
		// 3.  put n in temp next pointer
		// 4.  put temp in t.next 
		
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		//ListNode n5=new ListNode(5);
		//ListNode n6=new ListNode(6);
		//ListNode n7=new ListNode(7);
		//ListNode n8=new ListNode(8);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		//n4.next=n5;
		/*n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		*/
		
		//oddEvenList(n1);
		System.out.println();
		alter(n1);
		traverse(n1);
	}
	 public static ListNode alter(ListNode head) {
		 
		 ListNode t=head;

		 ListNode n=head;
	
		 boolean flag=false;
		 
		 ListNode x=head;
		 while(x!=null)
		 {	
			// n=x;
			 System.out.println("val "+x.val);
			
			 System.out.println("flag "+flag);
			 if(flag==true && x.next!=null)
			 {

				 System.out.println("here ");
				 ListNode temp=x.next;
				 x.next=temp.next;
				 System.out.println("t "+t.val);
				 temp.next=t.next;
				 t.next=temp;
				 t=temp;

				//x=n;
				 traverse(head);
				 flag=false;
				
			 }
			 else if(flag==false)
			 {
		
				 x=x.next;
				 flag=true;
			 }
			 else
				 break;
			 
			
			 System.out.println();
		

	 }
		 System.out.println("n "+n.val);
		 return null;
		
	 }
	 public static ListNode oddEvenList(ListNode head) {
	        
		 ListNode t=head;
		 
		 ListNode n=head;
		 int count=1;
		 boolean flag=false;
		 while(n!=null)
		 {	
			 System.out.println(n.val);
			 System.out.println("count "+count);
			 // if even is last then check its next is null or not 
			 if(count%2==0 && n.next!=null)
			 {
				
				 System.out.println("here ");
				ListNode temp=n.next;
				n.next=temp.next;
				System.out.println("t "+t.val);
				temp.next=t.next;
				t.next=temp;
				t=temp;
				n=n.next;
				count++;
				// because we are skipping a index here 
				// System.out.println("inside "+n.val);
				//break;
				 traverse(head);
			 }
			 else
			 {
				 n=n.next;
			 }
			 count++;
			 System.out.println();
			
		 }
	
		 //System.out.println("n "+n.val);
		// System.out.println("t "+t.val);
		 return null;
	    }
	 
	 public static void traverse(ListNode n)
	 {
		 System.out.println();
		 while(n!=null)
		 {	
			 System.out.print(n.val+" ");
			 n=n.next;
			 
		 }
		 System.out.println();
	 }

}
