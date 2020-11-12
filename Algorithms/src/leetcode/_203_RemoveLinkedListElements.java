package leetcode;


 class _203_RemoveLinkedListElements {
	

	 
	public static void main(String[] args) {
		
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(2);
		ListNode node4=new ListNode(1);
	
		System.out.println("node 2"+node2);
		System.out.println("node 3"+node3);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=null;
		
		ListNode head=node1;
		
		
	System.out.println("Before calculation");
		ListNode node=removeElements(head,2);
		System.out.println("passed");
		System.out.println("Traversing");
		  while(node!=null)
			  
	        {
	           System.out.println("val "+node.val);
	           
	           node=node.next;
	        }
		
		
		
	}
	
	  public static ListNode removeElements(ListNode head, int val) {
	        
	     
	       
	       while(head!=null)
	       {
	    	   System.out.println("head "+head.val);
	    	   if(head.val==val)
	    	   head=head.next;
	    	   else
	    		   break;
	    	   
	       }
	       if(head==null)
	           return null;
	        ListNode node=head;
	        ListNode prev=head;
	        System.out.println("main head "+head.val);
	        while(node!=null)
	        {
	           System.out.println("prev val "+prev.val);
	           System.out.println("current val "+node.val);
	           boolean flag=false;
	            if(node.val==val)
	            {
	            	  System.out.println("found val "+node.val);
	                
	                  prev.next=node.next;
	                 
	                  flag=true;
	            }
	            else
	            	flag=false;
	            if(flag==false)
	            prev=node;
	        node=node.next;
	        }
	        return head;
	    }

}
