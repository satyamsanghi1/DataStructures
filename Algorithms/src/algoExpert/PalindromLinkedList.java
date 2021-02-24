package algoExpert;

import leetcode.ListNode;

//  public class ListNode {
//      int val;
//      ListNode next;
//      ListNode() {}
//      ListNode(int val) { this.val = val; }
//      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  }
 
public class PalindromLinkedList {
	//Leetcode 234
	//my solution 27 %dfast using recursion
	public static void main(String[] args) {
		
		
		
	}
	 public boolean isPalindrome(ListNode head) {
	        
	        if(helper(head,head)==null)
	            return true;
	        return false;
	    }
	    
	    public ListNode helper(ListNode head,ListNode n)
	    {
	        if(n==null)
	        {
	          //  System.out.println("n "+n.val);
	            return head;
	        }
	        ListNode com=helper(head,n.next);
	       // System.out.println("com "+com.val+" n "+n.val);
	        if(com.val==Integer.MAX_VALUE)
	        {
	            //System.out.println("com -1");
	            return com;
	        }
	        else if(com.val==n.val)
	        {
	            return com.next;
	        }
	        else
	              return new ListNode(Integer.MAX_VALUE);
	    }
}
