package leetcode;

public class _1290_ConvertBinaryInLinkedListTonteger {

	static int sum=0;
	public static void main(String[] args) {
		
		
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(0);
		ListNode n3=new ListNode(1);
		ListNode n4=new ListNode(0);
		
		n1.next=n2;
		//n2.next=n3;
		//n3.next=n4;
			
		 //int x=1;
	        int p=0;
	        System.out.println(recurse(n1));
	        System.out.println(sum);
		
	}
	 public static int getDecimalValue(ListNode head) {
		 
		 return 0;
	 }
	 
	 public static int recurse(ListNode head)
	    {
	        if(head==null)
	            return 1;
	       //  x=x*2;
	        
	        int y=recurse(head.next);
	        System.out.println("val "+head.val+" x "+y);
	        sum+=head.val*y;
	        return y*2;
	    }
	 
}
