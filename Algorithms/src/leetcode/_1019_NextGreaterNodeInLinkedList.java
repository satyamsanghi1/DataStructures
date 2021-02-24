package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class _1019_NextGreaterNodeInLinkedList {
	
	public static void main(String[] args) {
		
		
		
	}
	 public int[] nextLargerNodes(ListNode head) {
	        
	        ArrayList<Integer>list=findSize(head);
	        Stack<Integer>stack=new Stack<>();
	         int array[]=new int [list.size()];
	        stack.push(0);
	        
	       for(int i=1;i<list.size();i++)
	       {
	            int val=list.get(i);
	           
	            while(!stack.isEmpty() && val>list.get(stack.peek()))
	            {
	                    array[stack.pop()]=val;
	            }
	           stack.push(i);
	       }
	     
	        //for(int i=0;i<list.size();i++)
	           // array[i]=list.get(i);
	        
	        return array;
	    }
	    public ArrayList<Integer> findSize(ListNode head)
	    {
	        ArrayList<Integer>list=new ArrayList<>();
	        
	        int size=1;
	        ListNode cur=head;
	        while(cur!=null)
	        {
	            list.add(cur.val);
	            cur=cur.next;
	        }
	       // System.out.println("list "+list.toString());
	        return list;
	    }

}
